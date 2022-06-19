package com.feddos.cleararhetecture.domain.usercase

import com.feddos.cleararhetecture.domain.models.UserName
import com.feddos.cleararhetecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getUserName()
    }
}