package com.app.adduserapp.data.database.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey (autoGenerate = true)val id: Int?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "number") val number: String?,
)
