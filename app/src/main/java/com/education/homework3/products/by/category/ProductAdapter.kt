package com.education.homework3.products.by.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.education.homework3.R
import com.education.homework3.server.ProductDto

class ProductAdapter : ListAdapter<ProductDto, ProductViewHolder>(ProductDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val prod = getItem(position)
        holder.bind(prod)
    }
}