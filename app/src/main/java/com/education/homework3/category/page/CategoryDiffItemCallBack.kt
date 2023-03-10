package com.education.homework3.category.page

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.education.homework3.server.CategoryDto


class CategoryDiffItemCallBack : DiffUtil.ItemCallback<CategoryDto>() {
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean {
        return oldItem.categoryName == newItem.categoryName
    }

    override fun areItemsTheSame(oldItem: CategoryDto, newItem: CategoryDto): Boolean {
        return oldItem == newItem
    }
}