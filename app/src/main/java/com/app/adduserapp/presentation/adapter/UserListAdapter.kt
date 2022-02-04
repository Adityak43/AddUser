package com.app.adduserapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.app.adduserapp.R
import com.app.adduserapp.data.database.local.entity.User

internal class UserListAdapter(private var userList: List<User>) :
    RecyclerView.Adapter<UserListAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.name)
        var number: TextView = view.findViewById(R.id.number)

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]
        holder.name.text = user.name
        holder.number.text =user.number

    }
    override fun getItemCount(): Int {
        return userList.size
    }
}