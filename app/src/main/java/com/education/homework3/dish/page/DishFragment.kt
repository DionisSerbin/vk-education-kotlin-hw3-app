package com.education.homework3.dish.page

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator

import com.yuyakaido.android.cardstackview.*
import com.education.homework3.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DishFragment : Fragment(), CardStackListener {

    private val viewModel by viewModels<DishViewModel>()

    private val dishAdapter = DishAdapter()

    private val manager by lazy { CardStackLayoutManager(context, this) }

    private lateinit var dishEndTextView: TextView

    private var dishCount: Int = START_COUNT

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dish, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardStackView = view.findViewById<CardStackView>(R.id.card_stack_view)

        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(VISIBLE_COUNT)
        manager.setTranslationInterval(TRANSLATION_INTERVAL)
        manager.setScaleInterval(SCALE_INTERVAL)
        manager.setSwipeThreshold(SWIPE_THRESHOLD)
        manager.setMaxDegree(MAX_DEGREE)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())

        cardStackView.apply {
            layoutManager = manager
            adapter = dishAdapter
        }

        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }

        dishEndTextView = view.findViewById(R.id.dishes_end)

        val skip = view.findViewById<View>(R.id.skip_button)
        skip.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }

        val rewind = view.findViewById<View>(R.id.rewind_button)
        rewind.setOnClickListener {
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            cardStackView.rewind()
        }

        val like = view.findViewById<View>(R.id.like_button)
        like.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }

        val progressBar = view.findViewById<ProgressBar>(R.id.progress_dish)

        viewLifecycleOwner.lifecycleScope.launch {

            progressBar.isVisible = true

            progressBar.setOnClickListener(null)

            try {
                val list = withContext(Dispatchers.IO) { viewModel.getDish() }
                dishCount = list.size
                dishAdapter.submitList(list)

                progressBar.isVisible = false
            } catch (error: Throwable) {
                progressBar.isVisible = true
                error.printStackTrace()
                progressBar.setOnClickListener {

                }
            }
        }
    }

    override fun onCardDragging(direction: Direction, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction) {
        val itemCount = manager.topPosition
        if (itemCount == dishCount) {
            dishEndTextView.isVisible = !dishEndTextView.isVisible
        }
    }


    override fun onCardRewound() {
        if (dishEndTextView.isVisible) {
            dishEndTextView.isVisible = !dishEndTextView.isVisible
        }
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View, position: Int) {
    }

    override fun onCardDisappeared(view: View, position: Int) {
    }
//
//    //pagination
////    override fun onCardSwiped(direction: Direction) {
////        if (manager.topPosition == adapter.itemCount - 5) {
////            paginate()
////        }
////    }
////
//    override fun onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawers()
//        } else {
//            super.onBackPressed()
//        }
//    }

    companion object {
        const val START_COUNT = 0
        const val VISIBLE_COUNT = 3
        const val TRANSLATION_INTERVAL = 8.0f
        const val SCALE_INTERVAL = 0.95f
        const val SWIPE_THRESHOLD = 0.3f
        const val MAX_DEGREE = 20.0f

        @JvmStatic
        fun newInstance() = DishFragment()
    }
}