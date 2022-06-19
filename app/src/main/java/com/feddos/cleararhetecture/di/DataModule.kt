package com.feddos.cleararhetecture.di

import android.content.Context
import com.feddos.cleararhetecture.data.repository.UserRepositoryImpl
import com.feddos.cleararhetecture.data.storage.SharedPrefUserStorage
import com.feddos.cleararhetecture.data.storage.UserStorage
import com.feddos.cleararhetecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}