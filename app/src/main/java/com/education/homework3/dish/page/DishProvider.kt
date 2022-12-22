package com.education.homework3.dish.page

import Server
import com.education.homework3.server.DishDto


class DishProvider(val server: Server) {

    suspend fun getDish(): List<DishDto> {
        return server.selectAllFromDishes()
    }
}