package com.example.nikita_shupliakou_testandroid_vacc_2024.network.services

import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.DetailsModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.ProductListModel
import retrofit2.http.GET
import retrofit2.http.Path


interface StoreService {

    @GET("products")
    suspend fun getProducts(): List<ProductListModel>

    @GET("products/{product_id}")
    suspend fun getDetails(
        @Path("product_id") productId: Int,
    ): DetailsModel

}