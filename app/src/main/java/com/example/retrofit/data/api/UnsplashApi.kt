package com.example.retrofit.data.api

import com.example.retrofit.model.MyModel.MyModel
import com.example.retrofit.model.RandomModel.RandomModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Content-Type:  application/json;charset=utf-8")
    @GET("/photos?per_page=30")
    suspend fun getImages(@Query("client_id") API_KEY:String) : Response<MyModel>

    @Headers("Content-Type:  application/json;charset=utf-8")
    @GET("/photos/random")
    suspend fun getRandomImage(@Query("client_id") API_KEY: String) : Response<RandomModel>

}