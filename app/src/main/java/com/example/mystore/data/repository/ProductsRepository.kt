package com.example.mystore.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.mystore.data.firebase.ProductDataSource
import com.example.mystore.data.models.Product

class ProductsRepository {
    fun getProducts(): MutableLiveData<List<Product>>{
        val productDataSource = ProductDataSource()

        return productDataSource.getProductsInfo()
    }
}