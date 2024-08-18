package com.example.riding_balloon.presentation.search

import android.content.Context
import android.print.PrintDocumentAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.riding_balloon.R
import com.example.riding_balloon.data.model.TravelSpotInfo

class SearchFragmentAdapter(private val data : List<TravelSpotInfo>
) : RecyclerView.Adapter<SearchFragmentAdapter.ViewHolder>() {
        interface ItemClick {
            fun onClick(view: View, position: Int)
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.iv_item_image)
        val countryTextView : TextView = itemView.findViewById(R.id.it_country_name)
        val cityTextView : TextView = itemView.findViewById(R.id.it_city_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gridview_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        Glide.with(holder.imageView.context)
            .load(data.thumbnailUrl)
            .into(holder.imageView)

        holder.countryTextView.text = data.country
        holder.cityTextView.text = data.region
    }
}