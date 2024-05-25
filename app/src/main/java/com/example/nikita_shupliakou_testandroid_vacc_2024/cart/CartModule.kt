package com.example.nikita_shupliakou_testandroid_vacc_2024.cart

import androidx.lifecycle.ViewModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CartModule {

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    abstract fun bindViewModel(viewModel: CartViewModel): ViewModel
}