package com.example.nikita_shupliakou_testandroid_vacc_2024.repository

import android.app.Application
import android.content.Context
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.models.DetailsModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.services.StoreService

private const val CART_SHARED_PREFS = "CART_SHARED_PREFS"
private const val TOTAL_CART_ITEMS = "TOTAL_CART_ITEMS"
class CartRepository(
    application: Application,
    private val storeService: StoreService
) {
    private val sharedPreferences =
        application.getSharedPreferences(CART_SHARED_PREFS, Context.MODE_PRIVATE)
    suspend fun getDetails(): DetailsModel =
        storeService.getDetails(getCartItems())

    private fun getCartItems(): Int = sharedPreferences.getInt(TOTAL_CART_ITEMS, 3)
}