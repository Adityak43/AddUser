package com.app.adduserapp.data.database.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.adduserapp.data.database.local.dao.UserDao
import com.app.adduserapp.data.database.local.entity.User
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseBuilderTest : TestCase(){

    private lateinit var db: AppDatabase
    private lateinit var dao: UserDao

   @Before
    public override fun setUp() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.userDao()
    }


    @After
    fun closeDb() {
        db.close()
    }



}