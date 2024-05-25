package com.example.nikita_shupliakou_testandroid_vacc_2024.details

import androidx.lifecycle.ViewModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindViewModel(viewModel: DetailsViewModel): ViewModel
}