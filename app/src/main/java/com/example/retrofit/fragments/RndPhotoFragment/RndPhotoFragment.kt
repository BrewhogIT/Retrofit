package com.example.retrofit.fragments.RndPhotoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.retrofit.R
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.databinding.FragmentRndPhotoBinding
import com.example.retrofit.viewmodel.PhotoVMFactory
import com.example.retrofit.viewmodel.RndPhotoViewModel.RndPhotoViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

class RndPhotoFragment : Fragment() {
    lateinit var binding: FragmentRndPhotoBinding
    val viewModel : RndPhotoViewModel by viewModels {PhotoVMFactory(PhotosRepository())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activity : AppCompatActivity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.title = "Random image from Unsplash"

        binding = FragmentRndPhotoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.apiData
                .onEach { data->
                    val imageUrl = data.urls.regular

                    Glide.with(requireActivity()).load(imageUrl).into(binding.ivRandomImage)
                }.collect()
        }

//        viewModel.apiLiveData.observe(viewLifecycleOwner,{
//            val imageUrl = it.urls.regular
//
//            Glide.with(requireActivity()).load(imageUrl).into(binding.ivRandomImage)
//            binding.idText.text = it.alt_description
//        })
    }

}