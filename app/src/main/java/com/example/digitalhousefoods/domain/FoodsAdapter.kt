package com.example.digitalhousefoods.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R

class FoodsAdapter (val listFoods: ArrayList<Foods>, val listener: OnClickFoodsListener): RecyclerView.Adapter<FoodsAdapter.FoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodsViewHolder(itemView)
    }

    override fun getItemCount() = listFoods.size

    override fun onBindViewHolder(holder: FoodsViewHolder, position: Int) {
        var food = listFoods[position]
        holder.tvName.text = food.name
        holder.ivFoods.setImageResource(food.imageId)
    }

    interface OnClickFoodsListener {
        fun onClickFoods(position: Int)
    }

    inner class FoodsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var ivFoods: ImageView = itemView.findViewById(R.id.image_food)
        var tvName: TextView = itemView.findViewById(R.id.tv_name_food)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) listener.onClickFoods(
                adapterPosition
            )
        }
    }
}