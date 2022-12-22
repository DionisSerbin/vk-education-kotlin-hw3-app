package com.education.homework3.category.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.education.homework3.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryListFragment : Fragment() {

    private val viewModel by viewModels<CategoryViewModel>()

    private val categoryAdapter = CategoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerCats = view.findViewById<RecyclerView>(R.id.category_recycler)
        recyclerCats.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
        }

        val pickDishButton = view.findViewById<ExtendedFloatingActionButton>(R.id.pick_dish)
        pickDishButton.setOnClickListener {
            val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
            val item = bottomNavigationView.menu.findItem(R.id.navigation_dish)
            NavigationUI.onNavDestinationSelected(item, findNavController())
        }

        recyclerCats.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerCats, dx, dy)
                if (dy > 0 && pickDishButton.visibility == View.VISIBLE) {
                    pickDishButton.hide()
                } else if (dy < 0 && pickDishButton.visibility != View.VISIBLE) {
                    pickDishButton.show()
                }
            }
        })

        val progressBar = view.findViewById<ProgressBar>(R.id.progress_category)

        viewLifecycleOwner.lifecycleScope.launch {
            progressBar.isVisible = true

            progressBar.setOnClickListener(null)

            try {
                val list = withContext(Dispatchers.IO) { viewModel.getCategory() }
                categoryAdapter.submitList(list)

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
        @JvmStatic
        fun newInstance() = CategoryListFragment()
    }
}