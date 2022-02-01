package com.example.exam01022022

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter(val restaurantList: ArrayList<Restaurant>, val listener: Listener): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById<ImageView>(R.id.image)
        var name = itemView.findViewById<TextView>(R.id.name)
        var rate = itemView.findViewById<RatingBar>(R.id.rate)
        var meal1 = itemView.findViewById<TextView>(R.id.meal1)
        var meal2 = itemView.findViewById<TextView>(R.id.meal2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(v)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        if(position == restaurantList.size - 1){
            listener.onBottomReachedListener(position)
        }
        holder.image.setImageResource(restaurantList.get(position).imgUrl)
        holder.name.text = restaurantList.get(position).name
        holder.rate.rating = restaurantList.get(position).rating
        holder.meal1.text = restaurantList.get(position).meal1
        holder.meal2.text = restaurantList.get(position).meal2
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    interface Listener{

        fun onBottomReachedListener(position: Int)

    }
}