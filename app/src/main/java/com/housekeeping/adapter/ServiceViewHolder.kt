package com.housekeeping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.housekeeping.model.entity.ServiceItem

class ServiceViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(TextView(parent.context).apply {
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }) {

    private val textView: TextView = itemView as TextView

    fun bind(item: ServiceItem, onClick: (ServiceItem) -> Unit) {
        textView.text = "${item.name}  ¥${item.price}"
        textView.setOnClickListener { onClick(item) }
    }
}
