package com.osmanacikgoz.roomexample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {
    @Query("SELECT*FROM restaurants")
    fun getAllRestaurants(): Flow<List<Restaurant>>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(restaurant: List<Restaurant>)

    @Query("DELETE FROM restaurants")
    suspend fun  deleteAllRestaurant()

}