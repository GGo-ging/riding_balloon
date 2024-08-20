package com.example.riding_balloon.presentation.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.riding_balloon.R
import com.example.riding_balloon.data.model.TravelSpotInfo

class SearchFragmentAdapter(private var data : List<TravelSpotInfo>, private val itemClickListener: (TravelSpotInfo) -> Unit
) : RecyclerView.Adapter<SearchFragmentAdapter.ViewHolder>() {
    var itemClick : ItemClick? = null

    interface ItemClick {
        fun onClickItem(view : View, position: Int)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_item_image)
        val countryTextView: TextView = itemView.findViewById(R.id.it_country_name)
        val cityTextView: TextView = itemView.findViewById(R.id.it_city_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_gridview_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]

        holder.itemView.setOnClickListener{
            itemClick?.onClickItem(it, position)
            itemClickListener(data)
        }

        Glide.with(holder.imageView.context)
            .load(data.thumbnailUrl)
            .into(holder.imageView)

        holder.countryTextView.text = data.country
        holder.cityTextView.text = data.region

//        holder.itemView.setOnClickListener {
//            itemClickListener(data)
//        }
    }

    fun updateData(newData: List<TravelSpotInfo>) {
        data = newData // 새로운 데이터로 교체
        notifyDataSetChanged() // 데이터 변경을 알림
    }

    fun getItem(position: Int): TravelSpotInfo {
        return data[position]
    }
}