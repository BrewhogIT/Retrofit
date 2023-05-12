package com.example.retrofit.fragments.PhotosFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.PhotoViewBinding
import com.example.retrofit.model.MyModel.MyModelItem

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
        val photoDescription = photosList[position].description
        val photoUrl = photosList[position].urls.regular

        Glide.with(holder.binding.root).load(photoUrl).into(holder.binding.ivImage)
        //holder.binding.idText.text = photoDescription
    }

    fun setData(list: List<MyModelItem>){
        photosList = list
        notifyDataSetChanged()
    }
}