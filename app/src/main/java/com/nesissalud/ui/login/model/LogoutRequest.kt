package com.nesissalud.ui.login.model

data class LogoutRequest(
    val dispositivo: String,
    val usuario_pdp: String,
    val contrasenya_pdp: String,
)