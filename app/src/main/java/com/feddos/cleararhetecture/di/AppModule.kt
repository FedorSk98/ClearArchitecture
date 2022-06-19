package com.feddos.cleararhetecture.di

import android.content.Context
import com.feddos.cleararhetecture.domain.usercase.GetUserNameUseCase
import com.feddos.cleararhetecture.domain.usercase.SaveUserNameUseCase
import com.feddos.cleararhetecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUserCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase)
    }
}