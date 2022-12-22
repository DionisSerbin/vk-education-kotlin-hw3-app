package com.education.homework3.products.by.category

import Server
import androidx.lifecycle.ViewModel
import com.education.homework3.products.by.category.ProductProvider
import com.education.homework3.server.ProductDto

class ProductViewModel : ViewModel() {
    private val server = Server()
    private val provider = ProductProvider(server)
    suspend fun getProduct(categoryId: Int): List<ProductDto> {
        server.startConnection()
        return provider.getProduct(categoryId)
    }
}