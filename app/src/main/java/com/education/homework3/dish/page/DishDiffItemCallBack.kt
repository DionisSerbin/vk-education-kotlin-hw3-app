package com.education.homework3.dish.page

import androidx.recyclerview.widget.DiffUtil
import com.education.homework3.server.DishDto

class DishDiffItemCallBack : DiffUtil.ItemCallback<DishDto>() {
    override fun areItemsTheSame(oldItem: DishDto, newItem: DishDto): Boolean {
        return oldItem.dish_id == newItem.dish_id
    }

    override fun areContentsTheSame(oldItem: DishDto, newItem: DishDto): Boolean {
        return oldItem == newItem
    }
}