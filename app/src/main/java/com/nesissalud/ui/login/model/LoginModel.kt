package com.nesissalud.ui.login.model

import com.nesissalud.ui.signup.model.Result


data class LoginModel(
    val message: String,
    val result: Result,
    val status: Int
)