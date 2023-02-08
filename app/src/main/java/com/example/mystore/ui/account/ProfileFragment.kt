package com.example.mystore.ui.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.mystore.R
import com.example.mystore.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileFragment : Fragment() {
    private val user: FirebaseUser? = FirebaseAuth.getInstance().currentUser
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            binding.username.text = user?.displayName!!

            binding.email.text = user?.email!!

            Glide.with(this)
                .load(user.photoUrl)
                .into(binding.displayImage)
        }
}