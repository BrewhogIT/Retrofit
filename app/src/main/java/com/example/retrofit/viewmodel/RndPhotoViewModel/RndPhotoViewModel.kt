package com.example.retrofit.viewmodel.RndPhotoViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.model.RandomModel.RandomModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class RndPhotoViewModel(private val repo : PhotosRepository):ViewModel() {
    private val _apiData = MutableSharedFlow<RandomModel>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val apiData: SharedFlow<RandomModel> = _apiData.asSharedFlow()

    //val apiLiveData = MutableLiveData<RandomModel>()


    init{
        getRandomImage()
    }

    private fun getRandomImage() {
        viewModelScope.launch {

            _apiData.emitAll(
                flow {
                    repo.getRandomPhoto()?.body()?.let {
                        emit(it)
                    }
                }
            )

//            val randomPhoto = repo.getRandomPhoto()
//
//            randomPhoto?.let {
//                if (randomPhoto.isSuccessful){
//                    apiLiveData.value = randomPhoto.body()
//                }else{
//                    Log.d("Load image", randomPhoto.message())
//                    Log.d("Load image", randomPhoto.errorBody().toString())
//                }
//            }
        }
    }
}