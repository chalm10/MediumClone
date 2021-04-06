package com.example.mediumclone.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.models.entities.User
import com.example.mediumclone.data.UserRepo
import kotlinx.coroutines.launch


//global viewmodel observable to the activity level
class AuthViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()

    val user: LiveData<User> = _user

    fun loginUser(email: String , password: String){
        viewModelScope.launch {
            UserRepo.loginUser(email , password).let {
                _user.postValue(it?.user)
            }
        }
    }

}