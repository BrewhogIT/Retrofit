package com.example.retrofit.viewmodel.RndPhotoViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.model.RandomModel.RandomModel
import kotlinx.coroutines.launch

class RndPhotoViewModel(private val repo : PhotosRepository):ViewModel() {
    val apiLiveData = MutableLiveData<RandomModel>()

    init{
        getRandomImage()
    }

    private fun getRandomImage() {
        viewModelScope.launch {
            val randomPhoto = repo.getRandomPhoto()

            randomPhoto?.let {
                if (randomPhoto.isSuccessful){
                    apiLiveData.value = randomPhoto.body()
                }else{
                    Log.d("Load image", randomPhoto.message())
                    Log.d("Load image", randomPhoto.errorBody().toString())
                }
            }
        }
    }
}