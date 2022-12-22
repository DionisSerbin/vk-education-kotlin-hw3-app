package com.education.homework3.category.page

import Server
import com.education.homework3.server.CategoryDto


class CategoryProvider(val server: Server) {

    suspend fun getCategory(): List<CategoryDto> {
        return server.selectAllFromCategories()
    }
}