package com.education.homework3.category.page

import Server
import androidx.lifecycle.ViewModel
import com.education.homework3.server.CategoryDto

class CategoryViewModel : ViewModel() {
    private val server = Server()
    private val provider = CategoryProvider(server)
    suspend fun getCategory(): List<CategoryDto> {
        server.startConnection()
        return provider.getCategory()
    }
}