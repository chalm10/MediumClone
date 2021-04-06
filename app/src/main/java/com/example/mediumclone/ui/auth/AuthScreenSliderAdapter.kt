package com.example.mediumclone.ui.auth

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class AuthScreenSliderAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LoginFragment()
            else -> SignUpFragment()
        }
    }
}
