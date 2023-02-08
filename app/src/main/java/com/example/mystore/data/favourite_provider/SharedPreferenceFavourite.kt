package com.example.mystore.data.favourite_provider

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData

class SharedPreferenceFavourite (context: Context):FavouriteProvider {
    //Created our shared preferences file
    private val favouriteStorage: SharedPreferences = context.getSharedPreferences("FAVOURITES",
        Context.MODE_PRIVATE)
    //Create an editor instance
    private val editor: SharedPreferences.Editor = favouriteStorage.edit()
    //Create an instance of a live data
    private val livedata = MutableLiveData<List<String>>(listOf())

    override fun addFavorite(productId: String) {
        editor.putString(productId,productId)
        editor.commit()

        notifyObservers()
    }

    override fun removeFavorite(productId: String) {
        editor.remove(productId)
        editor.commit()

        notifyObservers()
    }

    override fun isFavorite(productId: String): Boolean {
        val item:String? = favouriteStorage.getString(productId,"")
        if(item.isNullOrEmpty()){
            return false
        }
        return true
    }

    override fun getFavoriteItems(): MutableLiveData<List<String>> {
        notifyObservers()
        return livedata

    }

    private fun notifyObservers(){
        livedata.value = favouriteStorage.all.keys.toList()
    }
}