package com.feddos.cleararhetecture.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feddos.cleararhetecture.domain.models.SaveUserName
import com.feddos.cleararhetecture.domain.usercase.GetUserNameUseCase
import com.feddos.cleararhetecture.domain.usercase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUserCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    private val resultMutableLive = MutableLiveData<String>()
    val resultLive = resultMutableLive

    fun save(text: String){

        val param = SaveUserName(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param=param)
        resultMutableLive.value = result.toString()
    }

    fun load(){
        val userName = getUserNameUserCase.execute()
        resultMutableLive.value = userName.firstName
    }

}