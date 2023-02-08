package com.example.mystore.ui.favourites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.mystore.R
import com.example.mystore.databinding.FragmentFavouriteBinding
import com.example.mystore.ui.home.ProductsAdapter

class FavouriteFragment : Fragment() {
    private lateinit var fragmentFavouriteBinding: FragmentFavouriteBinding
    private lateinit var viewModel: FavouriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FavouriteViewModel::class.java)

        fragmentFavouriteBinding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return fragmentFavouriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAllFavouriteProducts().observe(viewLifecycleOwner){listOfIds ->
            viewModel.getProductFromIds(listOfIds).observe(viewLifecycleOwner) { listOfProducts ->
                if(listOfProducts.isNotEmpty()){

                    fragmentFavouriteBinding.listOfFavourites.visibility = View.VISIBLE
                    fragmentFavouriteBinding.notFound.visibility = View.GONE

                    fragmentFavouriteBinding.listOfFavourites.adapter = ProductsAdapter(requireContext(),listOfProducts, childFragmentManager)
                    fragmentFavouriteBinding.listOfFavourites.layoutManager = GridLayoutManager(requireContext(),2)
                }else{
                    //Favourite is empty message
                    fragmentFavouriteBinding.listOfFavourites.visibility = View.GONE
                    fragmentFavouriteBinding.notFound.visibility = View.VISIBLE


                }
            }
        }
    }
}