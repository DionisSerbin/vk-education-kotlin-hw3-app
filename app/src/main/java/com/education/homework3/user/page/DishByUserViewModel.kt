package com.education.homework3.user.page

import Server
import androidx.lifecycle.ViewModel
import com.education.homework3.server.DishDto
import com.education.homework3.user.page.DishByUserProvider

class DishByUserViewModel : ViewModel() {
    private val server = Server()
    private val provider = DishByUserProvider(server)
    suspend fun getDishByUser(userId: Int): List<DishDto> {
        server.startConnection()
        return provider.getDishByUser(userId)
    }
}

