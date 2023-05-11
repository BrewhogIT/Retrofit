package com.example.retrofit

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.fragments.PhotosFragment.PhotosFragment
import com.example.retrofit.fragments.RndPhotoFragment.RndPhotoFragment
import com.example.retrofit.navigator.Navigator


class MainActivity : AppCompatActivity(),Navigator{
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, PhotosFragment())
                .commit()
        }
        }

    override fun goBack() {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun openSecondActivity() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container,RndPhotoFragment())
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        goBack()
        return super.onSupportNavigateUp()
    }

}

