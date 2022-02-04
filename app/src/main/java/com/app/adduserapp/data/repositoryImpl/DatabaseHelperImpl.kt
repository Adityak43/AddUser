package com.app.adduserapp.data.repositoryImpl

import com.app.adduserapp.data.database.local.AppDatabase
import com.app.adduserapp.data.database.local.entity.User
import com.app.adduserapp.domain.repository.DatabaseHelper


class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun insert(users: User) = appDatabase.userDao().insert(users)

}