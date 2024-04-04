package com.raven.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raven.home.R
import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.presentation.adapters.viewholder.NewViewHolder

class NewsAdapter(private val news: List<NewItemResponse>) : RecyclerView.Adapter<NewViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewViewHolder(view)
        }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
    val new = news[position]
        holder.bind(new)
    }

    override fun getItemCount() = news.size

    }
