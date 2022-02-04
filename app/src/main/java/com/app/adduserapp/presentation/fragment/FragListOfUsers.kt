package com.app.adduserapp.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.adduserapp.R
import com.app.adduserapp.data.database.local.entity.User
import com.app.adduserapp.data.repositoryImpl.DatabaseHelperImpl
import com.app.adduserapp.databinding.FragListOfUsersFragmentBinding
import com.app.adduserapp.presentation.adapter.UserListAdapter
import com.app.adduserapp.presentation.viewmodel.FragListOfUsersViewModel
import com.app.adduserapp.util.Status

class FragListOfUsers : BaseFragment(){
    private lateinit var viewModel: FragListOfUsersViewModel
    private val users = ArrayList<User>()
    private lateinit var userListAdapter:UserListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var fragListOfUsersFragmentBinding: FragListOfUsersFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragListOfUsersFragmentBinding=DataBindingUtil.inflate(inflater,R.layout.frag_list_of_users_fragment, container, false)
        return fragListOfUsersFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragListOfUsersViewModel::class.java)

        recyclerView = fragListOfUsersFragmentBinding.userList

        val layoutManager = LinearLayoutManager(mainActivity)
        recyclerView.layoutManager = layoutManager
        userListAdapter= UserListAdapter(users)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = userListAdapter
        fragListOfUsersFragmentBinding.addUser.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_fragListOfUsers_to_fragAdduser)
        }
       setupObserver()
        viewModel.getAllUsers(DatabaseHelperImpl(mainActivity.databaseHelper))
    }
    private fun setupObserver() {
        viewModel.getUsers().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {

                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                    fragListOfUsersFragmentBinding.emptyText.visibility=View.GONE
                }
                Status.LOADING -> {

                    recyclerView.visibility = View.GONE
                }
                Status.EMPTY->{
                    recyclerView.visibility = View.GONE
                    fragListOfUsersFragmentBinding.emptyText.visibility=View.VISIBLE

                }
                Status.ERROR -> {
                    //Handle Error
                    Toast.makeText(mainActivity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }
    private fun renderList(usersList: List<User>) {
        if(users.isNotEmpty()){
            users.clear()

        }
        users.addAll(usersList)
        userListAdapter.notifyDataSetChanged()
    }

}