package com.sevenpeakssoftware.mihira.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sevenpeakssoftware.mihira.model.Car
import com.sevenpeakssoftware.mihira.model.CarsDao

@Database(entities = [Car::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carDao(): CarsDao
}