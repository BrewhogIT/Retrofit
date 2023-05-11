package com.example.retrofit.data.repository

import com.example.retrofit.Constants
import com.example.retrofit.MyApp
import com.example.retrofit.model.MyModel.MyModel
import com.example.retrofit.model.RandomModel.RandomModel
import retrofit2.Response

class PhotosRepository{

    suspend fun getPhotos():Response<MyModel>?{
        return MyApp.api?.getImages(Constants.KEY)
    }

    suspend fun getRandomPhoto():Response<RandomModel>?{
        return MyApp.api?.getRandomImage(Constants.KEY)
    }
}