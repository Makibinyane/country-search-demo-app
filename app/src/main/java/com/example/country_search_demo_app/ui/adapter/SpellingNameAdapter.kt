package com.example.country_search_demo_app.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.country_search_demo_app.R

class SpellingNameAdapter (private val languages: Array<String>) :
    RecyclerView.Adapter<SpellingNameAdapter.SpellingNameViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): SpellingNameViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.country_spelling_name_list_item, viewGroup, false)
        return SpellingNameViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: SpellingNameViewHolder, position: Int) {
        viewHolder.txtSpellingName.text = languages[position]
    }

    override fun getItemCount() = languages.size

    class SpellingNameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtSpellingName: TextView = view.findViewById(R.id.txtSpellingName)
    }
}