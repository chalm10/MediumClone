package com.example.mediumclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mediumclone.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_auth.*

class AuthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewPager.adapter = AuthScreenSliderAdapter(this)
        TabLayoutMediator(authTabLayout,authViewPager) { tab, position ->
            when(position){
                0 -> tab.text = "LOGIN"
                1 -> tab.text = "SIGNUP"
            }
        }.attach()

    }
}