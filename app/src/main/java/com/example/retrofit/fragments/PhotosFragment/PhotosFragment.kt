package com.example.retrofit.fragments.PhotosFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.databinding.FragmentPhotosBinding
import com.example.retrofit.fragments.PhotosFragment.PhotosAdapter
import com.example.retrofit.navigator.navigator
import com.example.retrofit.viewmodel.PhotoVMFactory
import com.example.retrofit.viewmodel.PhotoViewModel.PhotoViewModel

class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private val viewModel: PhotoViewModel by viewModels{ PhotoVMFactory(PhotosRepository()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val activity : AppCompatActivity = requireActivity() as AppCompatActivity
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        activity.supportActionBar?.title = "Images from Unsplash"

        binding = FragmentPhotosBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomImageBtn.setOnClickListener {
            navigator().openSecondActivity()
        }

        val adapter = PhotosAdapter()
        val layoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = layoutManager

        viewModel.apiLiveData.observe(viewLifecycleOwner,{list ->
            adapter.setData(list)
        })

    }

}