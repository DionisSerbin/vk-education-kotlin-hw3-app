package com.education.homework3.dish.page

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.education.homework3.R
import com.education.homework3.server.DishDto

class DishViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected val name by lazy { view.findViewById<TextView>(R.id.dish_name) }
    protected val subs by lazy { view.findViewById<TextView>(R.id.dish_subs) }
    protected val image by lazy { view.findViewById<ImageView>(R.id.dish_image) }


    fun bind(dish: DishDto) {
        name.text = dish.dishName
        val subsText = dish.dishSubs
            .subSequence(
                subsSeqStart,
                findThreeSpaceNumber(dish.dishSubs)
            ).toString() + "..."
        subs.text = subsText

        Glide.with(image)
            .load(dish.dishImage)
            .into(image)
    }

    private fun findThreeSpaceNumber(str: String): Int {
        var spacesCount = START_COUNT
        for (i in START_COUNT..str.length) {
            if (str[i] == ' ') {
                spacesCount++
                if (spacesNumber == spacesCount) {
                    return i
                }
            }
        }
        return subsSeqEnd
    }

    companion object {
        const val START_COUNT = 0
        const val spacesNumber = 3
        const val subsSeqStart = 0
        const val subsSeqEnd = 20
    }
}