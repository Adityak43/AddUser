package com.app.adduserapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.adduserapp.data.database.local.entity.User
import com.app.adduserapp.data.repositoryImpl.DatabaseHelperImpl
import com.app.adduserapp.util.Resource
import kotlinx.coroutines.launch

class FragListOfUsersViewModel : ViewModel() {
    private val users = MutableLiveData<Resource<List<User>>>()

    fun getAllUsers(databaseHelperImpl: DatabaseHelperImpl){
        viewModelScope.launch {

            users.postValue(Resource.loading(null))
          val usersFromDb=databaseHelperImpl.getUsers()
            if(usersFromDb.isEmpty()){
                users.postValue(Resource.empty())
                }
            else{
              users.postValue(Resource.success(usersFromDb))
            }



        }
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }
}