package com.example.nikita_shupliakou_testandroid_vacc_2024.repository

import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.DetailsModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.ProductListModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.services.StoreService

class StoreRepository(
    private val storeService: StoreService) {
    suspend fun getProducts(): List<ProductListModel> = storeService.getProducts()

    suspend fun getDetails(productId: Int): DetailsModel =
        storeService.getDetails(productId)
}