package com.sevenpeakssoftware.mihira.ui.cars

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.mihira.R
import com.sevenpeakssoftware.mihira.databinding.ListItemCarBinding
import com.sevenpeakssoftware.mihira.model.Car

class CarListAdapter : RecyclerView.Adapter<CarListAdapter.ViewHolder>() {
    private lateinit var carList: List<Car>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemCarBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_car,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int {
        return if (::carList.isInitialized) carList.size else 0
    }

    fun updateCarList(carList: List<Car>) {
        this.carList = carList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val viewModel = CarViewModel()

        fun bind(car: Car) {
            viewModel.bind(car)
            binding.viewModel = viewModel
        }
    }
}