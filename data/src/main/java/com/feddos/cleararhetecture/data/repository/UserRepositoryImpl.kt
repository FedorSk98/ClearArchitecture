package com.feddos.cleararhetecture.data.repository

import com.feddos.cleararhetecture.data.storage.User
import com.feddos.cleararhetecture.data.storage.UserStorage
import com.feddos.cleararhetecture.domain.models.SaveUserName
import com.feddos.cleararhetecture.domain.models.UserName

import com.feddos.cleararhetecture.domain.repository.UserRepository




class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository {


    override fun saveName(param: SaveUserName): Boolean {
        val userName = User(param.name, "Антонов")
        return userStorage.saveName(userName)
    }


    override fun getUserName(): UserName {
        val user =  userStorage.getUserName()
        return UserName(user.firstName, user.secondName)
    }

}