package com.example.api.models.requests


import com.example.api.models.entities.UserCredsLogIn
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LogInRequest(
    @Json(name = "user")
    val user : UserCredsLogIn
)