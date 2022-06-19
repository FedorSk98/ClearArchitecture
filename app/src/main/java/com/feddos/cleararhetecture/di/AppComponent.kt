package com.feddos.cleararhetecture.di

import com.feddos.cleararhetecture.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}