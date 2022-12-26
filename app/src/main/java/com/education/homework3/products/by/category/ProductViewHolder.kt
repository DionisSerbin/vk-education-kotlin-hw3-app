package com.education.homework3.products.by.category

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.education.homework3.R

import com.education.homework3.server.ProductDto

class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val productNameView by lazy { view.findViewById<TextView>(R.id.product_item) }
    private val cardProd by lazy { view.findViewById<CardView>(R.id.card_product) }
    private val checkBox by lazy { view.findViewById<CheckBox>(R.id.checkbox_product) }

    fun bind(prod: ProductDto) {

        cardProd.setOnClickListener {
            checkBox.isChecked = !checkBox.isChecked
        }

        val productName = prod.productName
        productNameView.text = productName

    }
}