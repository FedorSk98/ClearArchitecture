package com.feddos.cleararhetecture.data.storage

interface UserStorage {

    fun saveName(param: User): Boolean
    fun getUserName(): User
}