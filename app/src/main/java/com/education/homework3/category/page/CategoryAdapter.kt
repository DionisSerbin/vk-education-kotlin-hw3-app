package com.education.homework3.category.page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.education.homework3.R


import com.education.homework3.server.CategoryDto

class CategoryAdapter : ListAdapter<CategoryDto, CategoryViewHolder>(CategoryDiffItemCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val cat = getItem(position)
        holder.bind(cat)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}


