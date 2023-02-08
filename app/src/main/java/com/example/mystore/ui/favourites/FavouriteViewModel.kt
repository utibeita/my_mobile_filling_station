package com.example.mystore.ui.favourites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mystore.data.models.Product
import com.example.mystore.data.repository.FavouriteRepository

class FavouriteViewModel(application: Application) : AndroidViewModel(application) {
    private val favouriteRepository = FavouriteRepository(application)

    fun isFavourite(productId: String): Boolean{
        return favouriteRepository.isFavourite(productId)
    }

    fun removeFromFavourite(id: String) {
        favouriteRepository.removeProduct(id)
    }

    fun addToFavourite(id: String) {
        favouriteRepository.addProduct(id)
    }

    fun getAllFavouriteProducts(): MutableLiveData<List<String>>{
        return favouriteRepository.getAllFavourites()
    }

    fun getProductFromIds(listOfIds: List<String>) : MutableLiveData<List<Product>>{
        return favouriteRepository.getProductFromIds(listOfIds)

    }
}