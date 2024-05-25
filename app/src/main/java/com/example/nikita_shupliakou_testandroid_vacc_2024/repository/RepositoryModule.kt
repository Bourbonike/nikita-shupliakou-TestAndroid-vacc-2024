package com.example.nikita_shupliakou_testandroid_vacc_2024.repository

import com.example.nikita_shupliakou_testandroid_vacc_2024.network.services.StoreService
import dagger.Module
import dagger.Provides


@Module
 class RepositoryModule {

    @Provides
    fun provideStoreRepository(apiInterface: StoreService): StoreRepository {
        return StoreRepository(apiInterface)
    }
}