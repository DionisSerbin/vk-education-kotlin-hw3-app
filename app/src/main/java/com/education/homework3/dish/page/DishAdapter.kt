package com.education.homework3.dish.page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.education.homework3.R

import com.education.homework3.server.DishDto

class DishAdapter : ListAdapter<DishDto, DishViewHolder>(DishDiffItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dish_item, parent, false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val dish = getItem(position)
        holder.bind(dish)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

}