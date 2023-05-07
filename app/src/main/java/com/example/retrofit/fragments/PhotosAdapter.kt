package com.example.retrofit.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.retrofit.databinding.PhotoViewBinding
import com.example.retrofit.model.MyModelItem

class PhotosAdapter : Adapter<PhotosAdapter.PhotosViewHolder>() {
    private var photosList = emptyList<MyModelItem>()

    class PhotosViewHolder(view:View): ViewHolder(view) {
        lateinit var  binding : PhotoViewBinding

        constructor(b : PhotoViewBinding) : this(b.root) {
            binding = b
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = PhotoViewBinding.inflate(LayoutInflater.from(parent.context))
        return PhotosViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return photosList.size
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        var photoId = photosList[position].id

        holder.binding.idText.text = photoId
    }

    fun setData(list: List<MyModelItem>){
        photosList = list
        notifyDataSetChanged()
    }
}