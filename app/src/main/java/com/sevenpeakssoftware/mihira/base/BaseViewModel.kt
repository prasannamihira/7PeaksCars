package com.sevenpeakssoftware.mihira.base

import androidx.lifecycle.ViewModel
import com.sevenpeakssoftware.mihira.injection.component.DaggerViewModelInjector
import com.sevenpeakssoftware.mihira.injection.component.ViewModelInjector
import com.sevenpeakssoftware.mihira.injection.model.NetworkModule
import com.sevenpeakssoftware.mihira.ui.cars.CarListViewModel
import com.sevenpeakssoftware.mihira.ui.cars.CarViewModel


abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModel(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CarListViewModel -> injector.inject(this)
            is CarViewModel -> injector.inject(this)
        }
    }
}