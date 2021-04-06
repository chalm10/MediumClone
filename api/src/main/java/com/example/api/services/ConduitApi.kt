package com.example.api.services

import com.example.api.models.requests.LogInRequest
import com.example.api.models.requests.SignUpRequest
import com.example.api.models.responses.ArticleResponse
import com.example.api.models.responses.ArticlesResponse
import com.example.api.models.responses.TagsResponse
import com.example.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitApi {

    @POST("users")
    suspend fun signUpUser(
        @Body signUpRequest: SignUpRequest
    ) : Response<UserResponse>

    @POST("users/login")
    suspend fun logInUser(
        @Body logInRequest: LogInRequest
    ) : Response<UserResponse>

    @GET("articles")
    suspend fun getArticles(
        @Query("author") author : String? = null,
        @Query("tag") tag: String? = null,
        @Query("favorited") favorited : String? = null
    ) : Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
        @Path("slug") slug : String
    ) : Response<ArticleResponse>

    @GET("tags")
    suspend fun getAllTags() : Response<TagsResponse>



}