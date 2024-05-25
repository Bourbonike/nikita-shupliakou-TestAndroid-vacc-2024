package com.example.nikita_shupliakou_testandroid_vacc_2024.di


import com.example.nikita_shupliakou_testandroid_vacc_2024.cart.CartFragment
import com.example.nikita_shupliakou_testandroid_vacc_2024.cart.CartModule
import com.example.nikita_shupliakou_testandroid_vacc_2024.details.DetailsFragment
import com.example.nikita_shupliakou_testandroid_vacc_2024.details.DetailsModule
import com.example.nikita_shupliakou_testandroid_vacc_2024.menu.MenuFragment
import com.example.nikita_shupliakou_testandroid_vacc_2024.menu.MenuModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = [MenuModule::class])
    abstract fun menuFragment(): MenuFragment

    @ContributesAndroidInjector(modules = [DetailsModule::class])
    abstract fun detailsFragment(): DetailsFragment

    @ContributesAndroidInjector(modules = [CartModule::class])
    abstract fun cartFragment(): CartFragment
}