package com.feddos.cleararhetecture.di

import com.feddos.cleararhetecture.domain.repository.UserRepository
import com.feddos.cleararhetecture.domain.usercase.GetUserNameUseCase
import com.feddos.cleararhetecture.domain.usercase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUserCase(userRepository: UserRepository): GetUserNameUseCase{
        return GetUserNameUseCase(userRepository)
    }

    @Provides
    fun provideSaveUserNameUserCase(userRepository: UserRepository): SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository)
    }

}