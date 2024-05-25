package com.example.nikita_shupliakou_testandroid_vacc_2024.repository

import android.app.Application
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.services.StoreService
import dagger.Module
import dagger.Provides


@Module
class CartRepositoryModule {

    @Provides
    fun provideGameRepository(
        application: Application,
        apiInterface: StoreService
    ): CartRepository {
        return CartRepository(application = application, apiInterface)
    }
}