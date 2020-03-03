package com.sevenpeakssoftware.mihira.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.sevenpeakssoftware.mihira.model.database.AppDatabase
import com.sevenpeakssoftware.mihira.ui.cars.CarListViewModel

class ViewModelFactory(private val activity: AppCompatActivity) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CarListViewModel::class.java)) {
            val db =
                Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "cars")
                    .build()
            @Suppress("UNCHECKED_CAST")
            return CarListViewModel(db.carDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}