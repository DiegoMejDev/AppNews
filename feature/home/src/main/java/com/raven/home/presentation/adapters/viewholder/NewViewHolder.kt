package com.raven.home.presentation.adapters.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raven.home.R
import com.raven.home.data.remote.entities.NewItemResponse

class NewViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val tvName : TextView = view.findViewById(R.id.tvName)
    fun bind(item:NewItemResponse){
        tvName.text = item.title

    }
}