package com.example.mystore.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.mystore.data.favourite_provider.FavouriteProvider
import com.example.mystore.data.favourite_provider.SharedPreferenceFavourite
import com.example.mystore.data.firebase.ProductDataSource
import com.example.mystore.data.models.Product

class FavouriteRepository(context: Context) {
    private val favouriteProvider:FavouriteProvider = SharedPreferenceFavourite(context)
    private val productDatasource = ProductDataSource()

    fun isFavourite(productId: String): Boolean {
        return favouriteProvider.isFavorite(productId)
    }

    fun removeProduct(id: String) {
        favouriteProvider.removeFavorite(id)
    }

    fun addProduct(id: String) {
        favouriteProvider.addFavorite(id)
    }

    fun getAllFavourites(): MutableLiveData<List<String>>{
        return favouriteProvider.getFavoriteItems()
    }

    fun getProductFromIds(listOfIds: List<String>): MutableLiveData<List<Product>>{
        return productDatasource.getProductFromIds(listOfIds)
    }
}