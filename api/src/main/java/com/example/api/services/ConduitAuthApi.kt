package com.example.api.services

import com.example.api.models.requests.UpdateUserRequest
import com.example.api.models.responses.ArticlesResponse
import com.example.api.models.responses.ProfileResponse
import com.example.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthApi {

    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponse>

    @GET("profiles/username")
    suspend fun getUserProfile(
        @Path("username") username : String
    ) : Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles() : Response<ArticlesResponse>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body updateUserRequest: UpdateUserRequest
    ) : Response<UserResponse>

    @POST("profiles/{username}/follow")
    suspend fun followUser(
        @Path("username") username: String
    ) : Response<ProfileResponse>

    @DELETE("profiles/{username}/follow")
    suspend fun unfollowUser(
        @Path("username") username: String
    ) : Response<ProfileResponse>









}