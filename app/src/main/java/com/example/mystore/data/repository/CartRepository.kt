package com.example.mystore.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.mystore.data.models.Product

object CartRepository {
    private val selectedProducts = mutableMapOf<Product, Int>()
    private val cartLivedata = MutableLiveData<MutableMap<Product, Int>>(selectedProducts)

    fun addToCart(product: Product){
        selectedProducts.put(product, 1)
    }

    fun getQuantity(product: Product): Int{
        return selectedProducts[product]!!
    }

    fun removeFromCart (product: Product){
        selectedProducts.remove(product)
        notifyValueChange()
    }

    fun reduceQuantity(product: Product){
        //get quantity
        var quantity:Int = selectedProducts[product]!!
        quantity--
        selectedProducts[product] = quantity
        notifyValueChange()
    }
    fun increaseQuantity(product: Product){
        var quantity:Int = selectedProducts[product]!!
        quantity++
        selectedProducts[product] = quantity
        notifyValueChange()
    }

    fun getPrice(): Double{
        var price: Double = 0.0
        for(items in selectedProducts.keys){
            val totalPrice = items.price * selectedProducts[items]!!
            price += totalPrice
        }
        return price
    }

    fun getSelectedProducts():Map<Product, Int>{
        return selectedProducts.toMap()
    }

    fun getCartLiveData(): MutableLiveData<MutableMap<Product, Int>> {
        return cartLivedata
    }
    //update all observers that the data has changed
    private fun notifyValueChange() {
        cartLivedata.value = selectedProducts
    }
    fun clearCart(){
        selectedProducts.clear()
        notifyValueChange()
    }
}