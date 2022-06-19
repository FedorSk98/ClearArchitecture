package com.feddos.cleararhetecture.data.storage

import android.content.Context

private const val SHARED_PREFS_NAME = "haredPrefsName"
private const val KEY_FIRST_NAME = "firstName"

class SharedPrefUserStorage(context: Context): UserStorage {


    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(param: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, param.firstName).apply()
        return true
    }

    override fun getUserName(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "None")
        val secondName =sharedPreferences.getString(KEY_FIRST_NAME, "Default Last Name")

        return User(firstName.toString(), secondName.toString())
    }
}