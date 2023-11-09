package com.nesissalud.ui.login.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nesissalud.annotation.Status
import com.nesissalud.retrofit.WebResponse
import com.nesissalud.exception.ErrorHandler
import com.nesissalud.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.nesissalud.ui.login.model.LoginRequest
import com.nesissalud.ui.login.model.LogoutRequest
import okhttp3.ResponseBody


class LoginViewModel : ViewModel() {
    var responseLoginData: MutableLiveData<WebResponse<ResponseBody>> = MutableLiveData()
    var responseLogoutData: MutableLiveData<WebResponse<ResponseBody>> = MutableLiveData()

    var isLoading = MutableLiveData<Boolean>()
    var isViewEnable = MutableLiveData<Boolean>()

    var errorHandler: ErrorHandler? = ErrorHandler()


    /*
     * method to call login api
     * */
    fun callGetLoginApi(email: String, password: String, fcmToken: String, token: String) {
        isLoading.postValue(true)
        isViewEnable.postValue(true)

        val loginRequest = LoginRequest(
            dispositivo = fcmToken,
            usuario_portal = email,
            contrasenya_portal = password,
            token = token
        )
        val call = ApiClient().getClient().getLogin(loginRequest)
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(
                call: Call<ResponseBody?>, response: Response<ResponseBody?>
            ) {
                isLoading.postValue(false)
                isViewEnable.postValue(false)
                if (response.isSuccessful && response.body() != null) {
                    val result: ResponseBody? = response.body()

                    responseLoginData.value = (WebResponse(Status.SUCCESS, result, null))

                } else {
                    // val errorMsg = errorHandler!!.reportError(response.code())
                    responseLoginData.value = (WebResponse(
                        Status.FAILURE, null, response.message()
                    ))
                }
            }

            override fun onFailure(
                call: Call<ResponseBody?>, t: Throwable
            ) {
                isLoading.postValue(false)
                isViewEnable.postValue(false)
                val errorMsg = errorHandler!!.reportError(t)
                responseLoginData.value = WebResponse(Status.FAILURE, null, errorMsg)
            }
        })
    }


    /*
    * method to call logout api
    * */
    fun callGetLogoutApi(email: String, password: String, fcmToken: String,token: String) {
        isLoading.postValue(true)
        isViewEnable.postValue(true)

        val loginRequest = LoginRequest(
            dispositivo = fcmToken,
            usuario_portal = email,
            contrasenya_portal = password,
            token = token
        )
        val call = ApiClient().getClient().getLogout(loginRequest)
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(
                call: Call<ResponseBody?>, response: Response<ResponseBody?>
            ) {
                isLoading.postValue(false)
                isViewEnable.postValue(false)
                if (response.isSuccessful && response.body() != null) {
                    val result: ResponseBody? = response.body()

                    responseLogoutData.value = (WebResponse(Status.SUCCESS, result, null))

                } else {
                    // val errorMsg = errorHandler!!.reportError(response.code())
                    responseLogoutData.value = (WebResponse(
                        Status.FAILURE, null, response.message()
                    ))
                }
            }

            override fun onFailure(
                call: Call<ResponseBody?>, t: Throwable
            ) {
                isLoading.postValue(false)
                isViewEnable.postValue(false)
                val errorMsg = errorHandler!!.reportError(t)
                responseLogoutData.value = WebResponse(Status.FAILURE, null, errorMsg)
            }
        })
    }

}