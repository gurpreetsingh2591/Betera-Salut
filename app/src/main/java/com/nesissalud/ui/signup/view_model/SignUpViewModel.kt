package com.nesissalud.ui.signup.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nesissalud.annotation.Status
import com.nesissalud.retrofit.WebResponse
import com.nesissalud.exception.ErrorHandler
import com.nesissalud.ui.login.model.DefaultModel
import com.nesissalud.ui.signup.model.SignUpModel
import com.nesissalud.retrofit.ApiClient
import com.nesissalud.ui.login.model.LoginModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel : ViewModel() {
    var responseSignUpData: MutableLiveData<WebResponse<SignUpModel>> = MutableLiveData()

    var isLoading = MutableLiveData<Boolean>()
    var isViewEnable = MutableLiveData<Boolean>()

    var errorHandler: ErrorHandler? = ErrorHandler()




/*
    fun callGetRegistrationApi(dni: String,name: String,surname: String,phone: String,email: String, cp: String,fcmToken:String) {
        isLoading.postValue(true)
        isViewEnable.postValue(true)


        val call = ApiClient().getClient().getSignUp(email, surname,fcmToken)
        call.enqueue(object : Callback<SignUpModel?> {
            override fun onResponse(
                call: Call<SignUpModel?>,
                response: Response<SignUpModel?>
            ) {
                isLoading.postValue(false)
                isViewEnable.postValue(false)
                if (response.isSuccessful && response.body() != null) {
                    val result: SignUpModel? = response.body()
                    if (result?.status == 200)
                        responseSignUpData.setValue(
                            WebResponse(Status.SUCCESS, result, null)
                        ) else {
                        responseSignUpData.setValue(
                            WebResponse(Status.FAILURE, null, response.body()!!.message)
                        )
                    }
                } else {
                    val errorMsg = errorHandler!!.reportError(response.code())
                    responseSignUpData.setValue(
                        WebResponse(
                            Status.FAILURE,
                            null,
                            response.message()
                        )
                    )
                }
            }

            override fun onFailure(
                call: Call<SignUpModel?>,
                t: Throwable
            ) {
                isLoading.postValue(false)
                isViewEnable.postValue(false)
                val errorMsg = errorHandler!!.reportError(t)
                responseSignUpData.setValue(WebResponse(Status.FAILURE, null, errorMsg))
            }
        })
    }
*/

}