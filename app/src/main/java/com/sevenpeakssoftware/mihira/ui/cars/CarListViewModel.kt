package com.sevenpeakssoftware.mihira.ui.cars

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.sevenpeakssoftware.mihira.R
import com.sevenpeakssoftware.mihira.base.BaseViewModel
import com.sevenpeakssoftware.mihira.model.Car
import com.sevenpeakssoftware.mihira.model.CarsDao
import com.sevenpeakssoftware.mihira.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CarListViewModel(private val carsDao: CarsDao) : BaseViewModel() {

    @Inject
    lateinit var carApi: ApiService

    val carListAdapter: CarListAdapter = CarListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadCars() }

    private lateinit var subscription: Disposable

    init {
        loadCars()
    }

    /**
     * load car details
     */
    private fun loadCars() {
        subscription = Observable.fromCallable { carsDao.all }
            .concatMap { dbCarList ->
                if (dbCarList.isEmpty())
                    carApi.fetchCarsList().concatMap { apiCarList ->
                        carsDao.insertAll(*apiCarList.content.toTypedArray())
                        Observable.just(apiCarList)
                    }
                else
                    Observable.just(dbCarList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveCarListStart() }
            .doOnTerminate { onRetrieveCarListFinish() }
            .subscribe(
                // Add result
                { result -> onRetrieveCarListSuccess(result as List<Car>) },
                { onRetrieveCarListError() }
            )
    }


    private fun onRetrieveCarListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveCarListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveCarListSuccess(carList: List<Car>) {
        carListAdapter.updateCarList(carList)
    }

    private fun onRetrieveCarListError() {
        errorMessage.value = R.string.car_loading_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}