package com.education.homework3.products.by.category

import Server
import com.education.homework3.server.ProductDto

class ProductProvider(val server: Server) {
    suspend fun getProduct(categoryId: Int): List<ProductDto> {
        return server.selectProductWhereCategory(categoryId)
    }
}