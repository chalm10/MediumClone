package com.example.api

import com.example.api.models.entities.UserCredsLogIn
import com.example.api.models.entities.UserCredsSignUp
import com.example.api.models.requests.LogInRequest
import com.example.api.models.requests.SignUpRequest
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {

    val conduitClient = ConduitClient()

    @Test
    fun `GET articles`() {
        runBlocking {
            val response = conduitClient.api.getArticles()
            if (response.isSuccessful) {
                response.body()?.articles
            }
        }
    }

    @Test
    fun `GET articles by author`() {
        runBlocking {
            val response = conduitClient.api.getArticles(author = "jake")
            if (response.isSuccessful) {
                response.body()?.articles
            }
        }
    }

    @Test
    fun `GET articles by tag`() {
        runBlocking {
            val response = conduitClient.api.getArticles(tag = "dragons,butt")
            if (response.isSuccessful) {
                response.body()?.articles
            }
        }
    }

    @Test
    fun `GET articles by favorited`() {
        runBlocking {
            val response = conduitClient.api.getArticles(favorited = "jake")
            if (response.isSuccessful) {
                response.body()?.articles
            }
        }
    }

    @Test
    fun `GET article by slug`() {
        runBlocking {
            val response = conduitClient.api.getArticleBySlug(slug = "slug")
            if (response.isSuccessful) {
                response.body()?.article
            }
        }
    }

    @Test
    fun `GET tags`() {
        runBlocking {
            val response = conduitClient.api.getAllTags()
            if (response.isSuccessful) {
                response.body()?.tags
            }
        }
    }

    @Test
    fun `POST users - create user`() {
        runBlocking {
            val userCreds = UserCredsSignUp(
                email = "testemail${Random.nextInt(999, 9999)}@testemail.com",
                password = "pass${Random.nextInt(9999, 99999)}",
                username = "testusername${Random.nextInt(99, 999)}"
            )
            val signUpRequest = SignUpRequest(userCreds)
            val response = conduitClient.api.signUpUser(signUpRequest)
            if (response.isSuccessful) {
                if (response.body()?.user?.username == userCreds.username) {
                    response.body()?.user
                }
            }
        }
    }

    @Test
    fun `POST users - login user`() {
        runBlocking {
            val userCreds = UserCredsLogIn(
                email = "randomemail@gmail.com",
                password = "12345678"
            )
            val logInRequest = LogInRequest(userCreds)
            val response = conduitClient.api.logInUser(logInRequest)
            if (response.isSuccessful) {
                if (response.body()?.user?.email == userCreds.email) {
                    response.body()?.user
                }
            }

        }
    }


//    @Test
//    fun `GET current user`(){
//        runBlocking {
//            val response = conduitClient.api.getCurrentUser()
//            if (response.isSuccessful){
//                response.body()?.user
//            }
//        }
//    }


}
