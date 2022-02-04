package com.app.adduserapp.domain.repository

import com.app.adduserapp.data.database.local.entity.User


interface DatabaseHelper {

    suspend fun getUsers(): List<User>

    suspend fun insert(users: User)

}