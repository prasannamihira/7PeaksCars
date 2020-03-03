package com.sevenpeakssoftware.mihira.ui.cars

import androidx.lifecycle.MutableLiveData
import com.sevenpeakssoftware.mihira.base.BaseViewModel
import com.sevenpeakssoftware.mihira.model.Car
import com.sevenpeakssoftware.mihira.utils.DateTimeUtil

class CarViewModel : BaseViewModel() {

    private val carTitle = MutableLiveData<String>()
    private val carDescription = MutableLiveData<String>()
    private val carImageUrl = MutableLiveData<String>()
    private val dateTime = MutableLiveData<String>()

    fun bind(car: Car) {
        carTitle.value = car.title
        carDescription.value = car.ingress
        var dateDisplay = DateTimeUtil.getFullDateDisplay(car.dateTime)
        dateTime.value = dateDisplay
        carImageUrl.value = car.image
    }

    fun getCarTitle(): MutableLiveData<String> {
        return carTitle
    }

    fun getCarDescription(): MutableLiveData<String> {
        return carDescription
    }

    fun getDateTime(): MutableLiveData<String> {
        return dateTime
    }

    fun getImageUrl(): MutableLiveData<String> {
        return carImageUrl
    }
}