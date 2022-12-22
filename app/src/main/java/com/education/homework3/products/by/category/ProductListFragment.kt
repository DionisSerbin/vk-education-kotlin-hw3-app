package com.education.homework3.products.by.category

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.education.homework3.MainActivity
import com.education.homework3.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProductListFragment : Fragment() {

    private var categoryId: Int? = null
    private var categoryName: String? = null

    private val viewModel by viewModels<ProductViewModel>()

    private val productAdapter = ProductAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            categoryId = it.getInt(CATEGORY_ID)
            categoryName = it.getString(CATEGORY_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerProds = view.findViewById<RecyclerView>(R.id.product_recycler)

        recyclerProds.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = productAdapter
        }

        val doneButton = view.findViewById<ExtendedFloatingActionButton>(R.id.button_done)

        doneButton.setOnClickListener {
            val intent = Intent(doneButton.context, MainActivity::class.java)
            startActivity(intent)
        }

        recyclerProds.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerProds, dx, dy)
                if (dy > 0 && doneButton.visibility == View.VISIBLE) {
                    doneButton.hide()
                } else if (dy < 0 && doneButton.visibility != View.VISIBLE) {
                    doneButton.show()
                }
            }
        })

        val categoryNameView = view.findViewById<TextView>(R.id.product_name_by_category)
        categoryNameView.text = categoryName

        val progressBar = view.findViewById<ProgressBar>(R.id.progress_product)

        viewLifecycleOwner.lifecycleScope.launch {
            progressBar.isVisible = true

            progressBar.setOnClickListener(null)

            try {
                val list =
                    withContext(Dispatchers.IO) { categoryId?.let { viewModel.getProduct(it) } }
                productAdapter.submitList(list)

                progressBar.isVisible = false
            } catch (error: Throwable) {
                progressBar.isVisible = true
                error.printStackTrace()
                progressBar.setOnClickListener {

                }
            }
        }
    }

    companion object {
        private const val CATEGORY_ID = "category_id"
        private const val CATEGORY_NAME = "category_name"

        @JvmStatic
        fun newInstance(categoryId: Int?, categoryName: String?) =
            ProductListFragment().apply {
                arguments = Bundle().apply {
                    if (categoryId != null) {
                        putInt(CATEGORY_ID, categoryId)
                        putString(CATEGORY_NAME, categoryName)
                    }
                }
            }
    }
}