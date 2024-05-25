package com.example.nikita_shupliakou_testandroid_vacc_2024


import com.example.nikita_shupliakou_testandroid_vacc_2024.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)
}