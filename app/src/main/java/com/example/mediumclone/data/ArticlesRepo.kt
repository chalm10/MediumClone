package com.example.mediumclone.data

import com.example.api.ConduitClient

object ArticlesRepo {
    val api = ConduitClient().api
    suspend fun getGlobalFeed() = api.getArticles().body()
}