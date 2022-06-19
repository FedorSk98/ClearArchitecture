package com.feddos.cleararhetecture.domain.usercase

import com.feddos.cleararhetecture.domain.models.SaveUserName
import com.feddos.cleararhetecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserName): Boolean {
        if (param.name.isEmpty()) return false
        return userRepository.saveName(param)
    }
}