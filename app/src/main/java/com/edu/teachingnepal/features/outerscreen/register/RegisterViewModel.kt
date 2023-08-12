package com.edu.teachingnepal.features.outerscreen.register

import android.content.Context
import android.widget.Toast
import com.edu.teachingnepal.features.util.validation.Validation

class RegisterViewModel {
    private val validation = Validation()
    fun registerDetails(name: String, email: String, password: String, context: Context): Boolean {
//        val validName = validation.nameValidation(name)
        val validEmail = validation.emailValidation(email)
        return if (validEmail){
            true
        } else {
            Toast.makeText(context, "Not valid details", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}