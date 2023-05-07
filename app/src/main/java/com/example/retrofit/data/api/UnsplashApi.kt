package com.example.retrofit.data.api

import com.example.retrofit.model.MyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Content-Type:  application/json;charset=utf-8")
    @GET("/photos")
    suspend fun getImages(@Query("client_id") API_KEY:String) : Response<MyModel>

}