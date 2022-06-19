package com.feddos.cleararhetecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.feddos.cleararhetecture.data.repository.UserRepositoryImpl
import com.feddos.cleararhetecture.data.storage.SharedPrefUserStorage
import com.feddos.cleararhetecture.domain.usercase.GetUserNameUseCase
import com.feddos.cleararhetecture.domain.usercase.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    // region UseCase
    private val userRepository by lazy {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context))
    }
    private val getUserNameUserCase by lazy(LazyThreadSafetyMode.NONE) { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) { SaveUserNameUseCase(userRepository) }
    // endregion

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUserCase = getUserNameUserCase
        ) as T
    }
}