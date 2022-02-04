package com.app.adduserapp.data.database.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.adduserapp.data.database.local.dao.UserDao
import com.app.adduserapp.data.database.local.entity.User

@Database(entities = [User::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}