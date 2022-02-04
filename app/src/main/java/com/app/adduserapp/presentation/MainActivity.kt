package com.app.adduserapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.adduserapp.R
import com.app.adduserapp.data.database.local.AppDatabase
import com.app.adduserapp.data.database.local.DatabaseBuilder
import com.app.adduserapp.data.database.local.entity.User
import com.app.adduserapp.data.repositoryImpl.DatabaseHelperImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var   databaseHelper:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseHelper=DatabaseBuilder.getInstance(applicationContext)
    }
}