package com.education.homework3.user.page

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
import com.education.homework3.R
import com.education.homework3.firebase.sign.SignInActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserPageFragment : Fragment() {

    private val viewModel by viewModels<DishByUserViewModel>()

    private val dishAdapter = DishByUserAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerDish = view.findViewById<RecyclerView>(R.id.user_dishes_recycler)
        recyclerDish.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = dishAdapter
        }

        val exitButton = view.findViewById<ExtendedFloatingActionButton>(R.id.log_out_button)

        exitButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(exitButton.context, SignInActivity::class.java)
            startActivity(intent)
        }

        val progressBar = view.findViewById<ProgressBar>(R.id.progress_user_page)

        val noFavDishes = view.findViewById<TextView>(R.id.no_fav_dishes_text)

        viewLifecycleOwner.lifecycleScope.launch {
            progressBar.isVisible = true

            progressBar.setOnClickListener(null)

            try {
                val list = withContext(Dispatchers.IO) { viewModel.getDishByUser(userId) }
                dishAdapter.submitList(list)

                if (dishAdapter.itemCount == START_COUNT) {
                    noFavDishes.isVisible = !noFavDishes.isVisible
                }
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
        const val userId = 1
        const val START_COUNT = 0

        @JvmStatic
        fun newInstance() = UserPageFragment()
    }
}