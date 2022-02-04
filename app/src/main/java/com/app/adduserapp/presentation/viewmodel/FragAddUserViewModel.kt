package com.app.adduserapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.adduserapp.data.database.local.entity.User
import com.app.adduserapp.data.repositoryImpl.DatabaseHelperImpl
import kotlinx.coroutines.launch

class FragAddUserViewModel : ViewModel() {

    fun addUser(databaseHelperImpl: DatabaseHelperImpl,user: User){
        viewModelScope.launch {
            databaseHelperImpl.insert(user)
        }

    }
}