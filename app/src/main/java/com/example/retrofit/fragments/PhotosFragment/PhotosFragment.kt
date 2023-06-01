package com.example.retrofit.fragments.PhotosFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofit.R
import com.example.retrofit.data.repository.PhotosRepository
import com.example.retrofit.databinding.FragmentPhotosBinding
import com.example.retrofit.viewmodel.PhotoVMFactory
import com.example.retrofit.viewmodel.PhotoViewModel.PhotoViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private val viewModel: PhotoViewModel by viewModels{ PhotoVMFactory(PhotosRepository()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPhotosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomImageBtn.setOnClickListener {
            findNavController().navigate(R.id.rndPhotoFragment)
        }

        val adapter = PhotosAdapter()
        val layoutManager = GridLayoutManager(requireContext(),3)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = layoutManager

        lifecycleScope.launch {
            viewModel.apiData
                .onEach { list->
                    adapter.setData(list)
                }.collect()
        }
    }
}