package com.sevenpeakssoftware.mihira.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CarsDao {

    /**
     * fetch all car information from local db to offline use
     */
    @get:Query("SELECT * FROM car")
    val all: List<Car>

    /**
     * Insert all the car details to local db
     *
     * @param cars
     */
    @Insert
    fun insertAll(vararg cars: Car)
}