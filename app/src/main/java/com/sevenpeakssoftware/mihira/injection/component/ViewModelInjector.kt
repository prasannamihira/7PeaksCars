package com.sevenpeakssoftware.mihira.injection.component

import com.sevenpeakssoftware.mihira.injection.model.NetworkModule
import com.sevenpeakssoftware.mihira.ui.cars.CarListViewModel
import com.sevenpeakssoftware.mihira.ui.cars.CarViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    /**
     * Injects required dependencies into the specified PostListViewModel.
     * @param carListViewModel CarListViewModel in which to inject the dependencies
     */
    fun inject(carListViewModel: CarListViewModel)

    /**
     * Injects required dependencies into the specified PostViewModel.
     * @param carViewModel CarViewModel in which to inject the dependencies
     */
    fun inject(carViewModel: CarViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModel(networkModel: NetworkModule): Builder
    }
}
