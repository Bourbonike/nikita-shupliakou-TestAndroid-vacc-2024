package com.example.nikita_shupliakou_testandroid_vacc_2024.di

import android.app.Application
import com.example.nikita_shupliakou_testandroid_vacc_2024.App
import com.example.nikita_shupliakou_testandroid_vacc_2024.network.NetworkModule
import com.example.nikita_shupliakou_testandroid_vacc_2024.repository.RepositoryModule
import com.example.testdagger2application.di.FragmentBuildersModule

import dagger.BindsInstance
import dagger.Component

import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        FragmentBuildersModule::class,
        ViewModelModule::class,
        MainModule::class,

        RepositoryModule::class,
        NetworkModule::class,

    ]
)
interface AppComponent : AndroidInjector<App> {


    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}

