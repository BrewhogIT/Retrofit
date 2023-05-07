package com.example.retrofit.data.repository

import com.example.retrofit.MyApp
import com.example.retrofit.model.MyModel
import retrofit2.Response

class PhotosRepository{

    suspend fun getPhotos(API_KEY:String):Response<MyModel>{
        return MyApp.api!!.getImages(API_KEY)
    }
}