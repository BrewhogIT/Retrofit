package com.example.retrofit.navigator

import androidx.fragment.app.Fragment
import com.example.retrofit.databinding.FragmentPhotosBinding

fun Fragment.navigator():Navigator{
    return requireActivity() as Navigator
}

interface Navigator {
    fun goBack()
    fun openSecondActivity()
}