package com.app.adduserapp.presentation.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.app.adduserapp.R
import com.app.adduserapp.data.database.local.entity.User
import com.app.adduserapp.data.repositoryImpl.DatabaseHelperImpl
import com.app.adduserapp.databinding.FragAddUserFragmentBinding
import com.app.adduserapp.presentation.viewmodel.FragAddUserViewModel

class FragAddUser : BaseFragment(){

    private lateinit var viewModel: FragAddUserViewModel
    private lateinit var  fragAddUserFragmentBinding:FragAddUserFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragAddUserFragmentBinding=DataBindingUtil.inflate(inflater,R.layout.frag_add_user_fragment, container, false)
        return fragAddUserFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragAddUserViewModel::class.java)
        fragAddUserFragmentBinding.button.setOnClickListener {
            var name=fragAddUserFragmentBinding.editTextTextPersonName.text.toString()
            var number=fragAddUserFragmentBinding.editTextNumber.text.toString()
            if(name.isNotEmpty() && number.isNotEmpty()){
                viewModel.addUser(DatabaseHelperImpl(mainActivity.databaseHelper), User(null,name,number))
                findNavController().popBackStack()
            }
            else
                Toast.makeText(mainActivity, "Please check all fields are added", Toast.LENGTH_LONG).show()

        }
    }

}