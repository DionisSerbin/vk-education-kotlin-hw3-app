package com.education.homework3.user.page

import Server
import com.education.homework3.server.CategoryDto
import com.education.homework3.server.DishDto

class DishByUserProvider(val server: Server) {
    suspend fun getDishByUser(userId: Int): List<DishDto> {
        return server.selectDishWhereUser(userId)
    }
}