package com.education.homework3.user.page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.education.homework3.R
import com.education.homework3.dish.page.DishDiffItemCallBack
import com.education.homework3.server.DishDto

class DishByUserAdapter : ListAdapter<DishDto, DishByUserViewHolder>(DishDiffItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishByUserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.dish_by_user_item, parent, false)
        return DishByUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishByUserViewHolder, position: Int) {
        val dish = getItem(position)
        holder.bind(dish)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

}