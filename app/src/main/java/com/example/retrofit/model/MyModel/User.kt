package com.example.retrofit.model.MyModel

import com.example.retrofit.model.MyModel.LinksX
import com.example.retrofit.model.MyModel.ProfileImage

data class User(
    val bio: String,
    val id: String,
    val instagram_username: String,
    val links: LinksX,
    val location: String,
    val name: String,
    val portfolio_url: String,
    val profile_image: ProfileImage,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: String,
    val username: String
)