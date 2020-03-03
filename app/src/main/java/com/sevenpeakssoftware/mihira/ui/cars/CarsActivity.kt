package com.sevenpeakssoftware.mihira.ui.cars

import android.os.Bundle
import android.os.Handler
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sevenpeakssoftware.mihira.R
import com.sevenpeakssoftware.mihira.databinding.ActivityCarsBinding
import com.sevenpeakssoftware.mihira.injection.ViewModelFactory

class CarsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarsBinding
    private lateinit var viewModel: CarListViewModel

    private lateinit var mRunnable: Runnable
    private lateinit var mHandler: Handler

    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cars)
        binding.rvCars.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Initialize the handler instance
        mHandler = Handler()

        viewModel =
            ViewModelProviders.of(this, ViewModelFactory(this)).get(CarListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel

        binding?.srlCars?.setOnRefreshListener {
            // Initialize a new Runnable
            mRunnable = Runnable {

                // Hide swipe to refresh icon animation
                binding?.srlCars?.isRefreshing = false

                binding.viewModel = viewModel
            }

            // Execute the task after specified time
            mHandler.postDelayed(
                mRunnable,
                500
            )
        }
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
    }
}
