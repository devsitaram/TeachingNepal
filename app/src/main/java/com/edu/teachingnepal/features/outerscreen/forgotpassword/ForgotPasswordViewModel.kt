package com.edu.teachingnepal.features.outerscreen.forgotpassword

import android.content.Context
import android.widget.Toast
import com.edu.teachingnepal.features.util.validation.Validation

class ForgotPasswordViewModel {

    private val validation = Validation()

    fun resetPassword(email: String, context: Context): Boolean {
        val emailValid = validation.emailValidation(email)
        return if (emailValid){
            true
        } else {
            Toast.makeText(context, "Email is not valid!", Toast.LENGTH_SHORT).show()
            false
        }
    }
}