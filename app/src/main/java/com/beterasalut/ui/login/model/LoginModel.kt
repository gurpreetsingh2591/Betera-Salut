package com.beterasalut.ui.login.model

import com.beterasalut.ui.signup.model.Result


data class LoginModel(
    val message: String,
    val result: Result,
    val status: Int
)