package com.example.deliveryappandroid.api.model.requests

data class RegisterRequest(
    val email: String,
    val password:String,
    val login: String
)