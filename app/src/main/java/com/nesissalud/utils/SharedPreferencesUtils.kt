package com.nesissalud.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.nesissalud.annotation.Constants

object SharedPreferencesUtils {

    private const val SHARED_PREFERENCES = Constants.PREFERENCE_NAME
    private var sPreferences: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private const val IS_USER_LOGIN = Constants.IS_USER_LOGIN
    private const val USER_ID = Constants.USER_ID
    private const val TOKEN = Constants.TOKEN

    private const val USER_NAME = Constants.USER_NAME
    private const val USER_EMAIL = Constants.USER_EMAIL
    private const val USER_PHONE = Constants.USER_PHONE
    private const val USER_PASSWORD = "PASSWORD"
    private const val Address = Constants.Address
    private const val MOM = Constants.MOM
    private const val STUDENT_COUNT = Constants.STUDENT_COUNT
    private const val Country = Constants.Country
    private const val State = Constants.State
    private const val City = Constants.City
    private const val Pin = Constants.Pin
    private const val Gender = Constants.Gender
    private const val PARENT_ID = Constants.PARENT_ID
    private const val IMAGE = Constants.IMAGE
    private const val FcmToken = Constants.FcmToken
    private const val DeviceId = Constants.DeviceId
    private const val transport_id = Constants.TRANSPORT_ID
    private const val Current_lat = Constants.LAT
    private const val Current_long = Constants.LONG
    private const val NUMBER_OF_STUDENT = Constants.NUMBER_OF_STUDENT

    @SuppressLint("CommitPrefEdits")
    fun init(context: Context?) {
        sPreferences = context?.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
        editor = sPreferences!!.edit()
    }

    //get is user login?
    fun isUserLogin(): Boolean? {
        return sPreferences?.getBoolean(IS_USER_LOGIN, false)
    }

    //get user detail
    fun getUserId(): String? {
        return sPreferences?.getString(USER_ID, "")
    }

    fun getUserName(): String? {
        return sPreferences?.getString(USER_NAME, "")
    }

    fun getUserPassword(): String? {
        return sPreferences?.getString(USER_PASSWORD, "")
    }

    fun getUserEmail(): String? {
        return sPreferences?.getString(USER_EMAIL, "")
    }

    fun getUserNumber(): String? {
        return sPreferences?.getString(USER_PHONE, "")
    }


    fun getDeviceId(): String? {
        return sPreferences?.getString(DeviceId, "")
    }

    fun getFcmToken(): String? {
        return sPreferences?.getString(FcmToken, "")
    }


    // set user and company detail

    fun setFcmToken(token: String) {
        sPreferences?.edit()
            ?.putString(FcmToken, token)
            ?.apply()
    }


    fun setUserLogin(status: Boolean, email: String, password: String) {
        sPreferences?.edit()
            ?.putBoolean(IS_USER_LOGIN, status)
            ?.putString(USER_EMAIL, email)
            ?.putString(USER_PASSWORD, password)
            ?.apply()
    }


    fun clearUser() {
        sPreferences?.edit()
            ?.clear()
            ?.apply()
    }


}