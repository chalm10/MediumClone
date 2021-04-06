package com.example.mediumclone.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mediumclone.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val authViewModel : AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBtn.setOnClickListener {
            authViewModel.loginUser(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }

//        authViewModel.user.observe(viewLifecycleOwner, {
////            Log.d("TAG", it.toString())
//            if (it!=null){
//                Toast.makeText(context, "logged in as ${it.username}", Toast.LENGTH_SHORT).show()
//            }else{
//                Toast.makeText(context, "incorrect username/password", Toast.LENGTH_SHORT).show()
//            }
//        })

    }

}
