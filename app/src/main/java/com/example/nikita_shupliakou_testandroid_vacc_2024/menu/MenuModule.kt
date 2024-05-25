package com.example.nikita_shupliakou_testandroid_vacc_2024.menu

import androidx.lifecycle.ViewModel
import com.example.nikita_shupliakou_testandroid_vacc_2024.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MenuModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindViewModel(viewModel: MenuViewModel): ViewModel
}