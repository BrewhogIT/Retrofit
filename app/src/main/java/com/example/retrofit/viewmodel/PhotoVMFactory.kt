package com.example.retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.viewmodel.PhotoViewModel.PhotoViewModel
import com.example.retrofit.viewmodel.RndPhotoViewModel.RndPhotoViewModel
import java.lang.IllegalArgumentException

class PhotoVMFactory(private val repository: PhotosRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoViewModel::class.java)){
            return PhotoViewModel(repository) as T
        }else if (modelClass.isAssignableFrom(RndPhotoViewModel::class.java)){
            return RndPhotoViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown view model class")
    }
}