package com.education.homework3.dish.page

import Server
import androidx.lifecycle.ViewModel
import com.education.homework3.server.DishDto


class DishViewModel : ViewModel() {
    private val server = Server()
    private val provider = DishProvider(server)
    suspend fun getDish(): List<DishDto> {
        server.startConnection()
        return provider.getDish()
    }
}