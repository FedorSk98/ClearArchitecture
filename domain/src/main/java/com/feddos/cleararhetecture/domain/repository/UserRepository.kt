package com.feddos.cleararhetecture.domain.repository

import com.feddos.cleararhetecture.domain.models.SaveUserName
import com.feddos.cleararhetecture.domain.models.UserName

interface UserRepository {

    fun saveName(param: SaveUserName): Boolean

    fun getUserName(): UserName
}