package com.example.mediumclone.data

import com.example.api.ConduitClient
import com.example.api.models.entities.UserCredsLogIn
import com.example.api.models.requests.LogInRequest

object UserRepo {
    val api = ConduitClient().api
    suspend fun loginUser(email : String,password : String) = api.logInUser(LogInRequest(
        UserCredsLogIn(
            email,
            password
        )
    )).body()

}