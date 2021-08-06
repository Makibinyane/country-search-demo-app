package com.example.country_search_demo_app.ui.adapter

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.country_search_demo_app.R
import com.example.country_search_demo_app.model.CountryDetailsResponse
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


class CountryNameAdapter(
    val context: Context,
    private val onClick: (CountryDetailsResponse) -> Unit
):
    ListAdapter<CountryDetailsResponse, CountryNameAdapter.CountryNameViewHolder>(
        CountryNamesDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryNameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.country_name_list_item,
            parent,
            false
        )
        return CountryNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryNameViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class CountryNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtCountryName: TextView = itemView.findViewById(R.id.txtCountryName)
        var imgCountryFlag: ImageView = itemView.findViewById(R.id.imgCountryFlag)

        fun bind(response: CountryDetailsResponse) {

            txtCountryName.text = response.name

            val requestBuilder = GlideToVectorYou
                .init()
                .with(context)
                .requestBuilder

            requestBuilder
                .load(response.flag)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(
                    RequestOptions()
                        .centerCrop()
                )
                .into(imgCountryFlag)

            itemView.setOnClickListener {
                onClick(response)
            }
        }
    }

    class CountryNamesDiffCallback : DiffUtil.ItemCallback<CountryDetailsResponse>() {
        override fun areItemsTheSame(
            oldItem: CountryDetailsResponse,
            newItem: CountryDetailsResponse
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: CountryDetailsResponse,
            newItem: CountryDetailsResponse
        ): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.alpha3Code == oldItem.alpha3Code
        }
    }
}