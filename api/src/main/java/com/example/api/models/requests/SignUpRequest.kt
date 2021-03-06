package com.example.api.models.requests


import com.example.api.models.entities.UserCredsSignUp
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "user")
    val user: UserCredsSignUp
)