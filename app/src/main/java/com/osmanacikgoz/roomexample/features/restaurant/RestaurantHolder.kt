package com.osmanacikgoz.roomexample.features.restaurant

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osmanacikgoz.roomexample.data.Restaurant
import com.osmanacikgoz.roomexample.databinding.RestaurantItemBinding

class RestaurantHolder(private val binding: RestaurantItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(restaurant: Restaurant) {
        binding.apply {
            Glide.with(itemView)
                .load(restaurant.logo)
                .into(restaurantImage)
            val restaurantName = binding.textViewName
            restaurantName.text = restaurant.name
            val restaurantType = binding.textViewType
            restaurantType.text = restaurant.type
            val restaurantAddress = binding.textViewAddress
            restaurantAddress.text = restaurant.address

        }

    }
}