package com.housekeeping.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.housekeeping.model.entity.ServiceItem

class ServiceAdapter(
    private val data: MutableList<ServiceItem> = mutableListOf(),
    private val onClick: (ServiceItem) -> Unit
) : RecyclerView.Adapter<ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ServiceViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(data[position], onClick)
    }

    fun submitList(list: List<ServiceItem>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}
