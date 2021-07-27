package com.osmanacikgoz.roomexample.data

import androidx.room.withTransaction
import com.osmanacikgoz.roomexample.api.RestaurantApi
import com.osmanacikgoz.roomexample.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val  api:RestaurantApi,
    private val db:RestaurantDatabase
) {
    private  val restaurantDao = db.restaurantDao()

    fun getRestaurants()= networkBoundResource(
        query = {
          restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurants()
        },
        saveFetchResult = {
            restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurant()
                restaurantDao.insertRestaurant(restaurants)
            }
        }
    )
}