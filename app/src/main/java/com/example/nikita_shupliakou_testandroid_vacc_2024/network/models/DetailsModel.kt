package com.example.nikita_shupliakou_testandroid_vacc_2024.network.models

import com.google.gson.annotations.SerializedName

data class DetailsModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("rating")
    val rating: Rating,

)

data class Rating(
    @SerializedName("rate")
    val rate: Float,
    @SerializedName("count")
    val count: Int,
)