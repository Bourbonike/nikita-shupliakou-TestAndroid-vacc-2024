package com.example.nikita_shupliakou_testandroid_vacc_2024.di

import androidx.lifecycle.ViewModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}