package com.example.nikita_shupliakou_testandroid_vacc_2024.network.models

import com.google.gson.annotations.SerializedName


data class ProductListModel (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
)
