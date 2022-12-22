package com.education.homework3.user.page

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.education.homework3.R
import com.education.homework3.server.DishDto

class DishByUserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected val dishNameView by lazy { view.findViewById<TextView>(R.id.dish_by_user_name) }
    protected val dishImage by lazy { view.findViewById<ImageView>(R.id.dish_by_user_image) }

    fun bind(dish: DishDto) {

        val dishName = dish.dish_name
        val dishTime = dish.minutes
        val dishText = "$dishName, $dishTime минут"
        dishNameView.text = dishText

        Glide.with(dishImage)
            .load(dish.dish_image)
            .into(dishImage)
    }
}