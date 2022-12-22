package com.education.homework3.products.by.category

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.education.homework3.server.ProductDto

class ProductDiffItemCallback : DiffUtil.ItemCallback<ProductDto>() {
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ProductDto, newItem: ProductDto): Boolean {
        return oldItem.product_id == newItem.product_id
    }

    override fun areItemsTheSame(oldItem: ProductDto, newItem: ProductDto): Boolean {
        return oldItem == newItem
    }
}