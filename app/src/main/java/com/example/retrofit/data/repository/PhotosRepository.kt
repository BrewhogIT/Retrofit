package com.example.retrofit.data.repository

import androidx.compose.ui.unit.Constraints
import com.example.retrofit.Constants
import com.example.retrofit.MyApp
import com.example.retrofit.model.MyModel
import retrofit2.Response

class PhotosRepository{

    suspend fun getPhotos():Response<MyModel>?{
        return MyApp.api?.getImages(Constants.KEY)
    }
}