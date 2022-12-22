package com.education.homework3.products.by.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.education.homework3.R


class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val categoryId = intent.extras?.getInt("category_id")
        val categoryName = intent.extras?.getString("category_name")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.product_list_activity,
                    ProductListFragment.newInstance(categoryId, categoryName),
                    "product"
                )
                .commit()
        }
    }
}