package com.example.retrofit.fragments.RndPhotoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.example.retrofit.R
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.databinding.FragmentRndPhotoBinding
import com.example.retrofit.viewmodel.PhotoVMFactory
import com.example.retrofit.viewmodel.RndPhotoViewModel.RndPhotoViewModel

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

        viewModel.apiLiveData.observe(viewLifecycleOwner,{
            binding.idText.text = it.id
        })
    }

}