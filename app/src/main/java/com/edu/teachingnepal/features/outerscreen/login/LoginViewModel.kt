package com.edu.teachingnepal.features.outerscreen.login

import android.content.Context
import android.widget.Toast
import com.edu.teachingnepal.features.util.validation.Validation

class LoginViewModel {

    private val validation = Validation()
    fun loginDetails(email: String, password: String, context: Context): Boolean {
        val emailValid = validation.emailValidation(email)
        return if (emailValid){
            true
        } else {
            Toast.makeText(context, "Email is not valid!", Toast.LENGTH_SHORT).show()
            false
        }
    }
}