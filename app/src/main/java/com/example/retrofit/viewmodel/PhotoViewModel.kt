package com.example.retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Constants
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.model.MyModel
import kotlinx.coroutines.launch

class PhotoViewModel:ViewModel() {
    var repo = PhotosRepository()
    val apiLiveData = MutableLiveData<MyModel>()

    init{
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch {
            val images = repo.getPhotos(Constants.KEY)

            if (images.isSuccessful){
                apiLiveData.value = images.body()
            }else{
                Log.d("Load image",images.message())
                Log.d("Load image",images.errorBody().toString())
            }
        }
    }

}