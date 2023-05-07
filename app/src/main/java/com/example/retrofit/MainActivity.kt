package com.example.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.fragments.PhotosFragment


class MainActivity : AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,PhotosFragment())
                .commit()
        }
        }

    }

