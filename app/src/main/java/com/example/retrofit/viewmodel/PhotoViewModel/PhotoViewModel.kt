package com.example.retrofit.viewmodel.PhotoViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.model.MyModel.MyModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class PhotoViewModel(private val repo:PhotosRepository):ViewModel() {
    private val _apiData = MutableSharedFlow<MyModel>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val apiData : SharedFlow<MyModel> = _apiData.asSharedFlow()

    //val apiLiveData = MutableLiveData<MyModel>()


    init{
        getImages()
    }

    private fun getImages() {

        viewModelScope.launch {

            _apiData.emitAll(
                flow {
                    repo.getPhotos()?.body()?.let {
                        emit(it)
                    }
                }
            )

        }

//        viewModelScope.launch {
//            val images = repo.getPhotos()
//
//            images?.let {
//                if (images.isSuccessful){
//                    apiLiveData.value = images.body()
//                }else{
//                    Log.d("Load image",images.message())
//                    Log.d("Load image",images.errorBody().toString())
//                }
//            }
//        }
    }
}