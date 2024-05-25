package com.example.nikita_shupliakou_testandroid_vacc_2024.di

import com.example.nikita_shupliakou_testandroid_vacc_2024.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMyActivity(): MainActivity

    companion object{

        @Provides
        fun someString():String{
            return "Hello world from view model"
        }
    }
}