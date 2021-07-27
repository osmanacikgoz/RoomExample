package com.osmanacikgoz.roomexample.features.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.osmanacikgoz.roomexample.data.Restaurant
import com.osmanacikgoz.roomexample.databinding.RestaurantItemBinding

class RestaurantAdapter:ListAdapter<Restaurant,RestaurantHolder>(RestaurantComparator()) {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHolder {
      val binding: RestaurantItemBinding =
          RestaurantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return RestaurantHolder(binding)
  }

    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class RestaurantComparator:DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem.name ==newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant)=
            oldItem ==newItem

    }




}