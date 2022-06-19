package com.feddos.cleararhetecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.feddos.cleararhetecture.domain.usercase.GetUserNameUseCase
import com.feddos.cleararhetecture.domain.usercase.SaveUserNameUseCase


class MainViewModelFactory(
    private val getUserNameUserCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUserCase = getUserNameUserCase
        ) as T
    }
}