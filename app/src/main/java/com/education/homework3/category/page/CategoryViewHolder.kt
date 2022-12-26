package com.education.homework3.category.page

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.education.homework3.R
import com.education.homework3.products.by.category.ProductListActivity

import com.education.homework3.server.CategoryDto


class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val categoryNameView by lazy { view.findViewById<TextView>(R.id.category_item) }
    val card = view.findViewById<CardView>(R.id.card_category)

    fun bind(cat: CategoryDto) {

        card.setOnClickListener {
            val intent = Intent(card.context, ProductListActivity::class.java)
            intent.putExtra("category_id", cat.categoryId)
            intent.putExtra("category_name", cat.categoryName)
            card.context.startActivity(intent)
        }

        val categoryName = cat.categoryName
        categoryNameView.text = categoryName
    }
}