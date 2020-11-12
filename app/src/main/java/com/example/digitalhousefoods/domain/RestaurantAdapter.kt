package com.example.digitalhousefoods.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R

class RestaurantAdapter(val listRestaurant: ArrayList<Restaurant>, val listener: OnClickRestaurantListener): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(itemView)
    }

    override fun getItemCount() = listRestaurant.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        var restaurant = listRestaurant[position]
        holder.tvName.text = restaurant.name
        holder.tvAdress.text = restaurant.adress
        holder.tvHour.text = "Fecha às ${restaurant.hour}"
        holder.ivRestaurat.setImageResource(restaurant.imageViewid)
    }

    interface OnClickRestaurantListener{
        fun onClickRestaurant(position: Int)
    }

    inner class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var ivRestaurat: ImageView = itemView.findViewById(R.id.image_restaurant)
        var tvName: TextView = itemView.findViewById(R.id.text_restaurant_name)
        var tvAdress: TextView = itemView.findViewById(R.id.text_restaurant_adress)
        var tvHour: TextView = itemView.findViewById(R.id.text_restaurant_hour)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) listener.onClickRestaurant(adapterPosition)
        }
    }
}