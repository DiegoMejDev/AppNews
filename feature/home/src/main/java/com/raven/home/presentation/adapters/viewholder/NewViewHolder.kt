package com.raven.home.presentation.adapters.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raven.home.R
import com.raven.home.data.remote.entities.NewItemResponse
import com.raven.home.domain.entities.NewItem

class NewViewHolder(view: View) : RecyclerView.ViewHolder(view){

    private val tvName : TextView = view.findViewById(R.id.tvName)
    private val tvAbstract : TextView = view.findViewById(R.id.tvAbstract)
    private val tvAuthor : TextView = view.findViewById(R.id.tvAuthor)
    private val tvPublished : TextView = view.findViewById(R.id.tvPublished)

    fun bind(item: NewItemResponse){
        tvName.text = item.title
        tvAbstract.text= item.abstract
        tvAuthor.text= item.byline
        tvPublished.text = item.published_date

    }
}