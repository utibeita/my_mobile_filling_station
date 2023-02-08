package com.example.mystore.ui.productDetails

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.mystore.data.models.Product
import com.example.mystore.data.repository.CartRepository

class ProductDetailsViewModel() :ViewModel() {

    fun saveToCart(product: Product){
        //add product to repository
        CartRepository.addToCart(product)
    }
}