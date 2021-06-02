package org.kmebin.androidpractices.data.api

import org.kmebin.androidpractices.data.model.UserResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("/api/users")
    suspend fun getUser(
        @Query("page") page : Int
    ): Response<UserResponse>

    companion object {
        operator fun invoke(): UserApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://reqres.in")
                .build()
                .create(UserApi::class.java)
        }
    }
}