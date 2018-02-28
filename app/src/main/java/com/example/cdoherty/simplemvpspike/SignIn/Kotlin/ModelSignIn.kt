package com.example.cdoherty.simplemvpspike.SignIn.Kotlin

import android.util.Log
import com.example.cdoherty.simplemvpspike.SignIn.SignInImplementation
import com.example.cdoherty.simplemvpspike.SignIn.SignUpDialog

/**
 * Created by cdoherty on 28/02/2018.
 */
class ModelSignIn : SignInImplementation {
    private val signUpDialog: SignUpDialog? = null


    override fun signIn(name: String, password: String, listener: SignInImplementation.SignInListener) {
        Log.d(TAG, "signIn: $name $password")
        //if sign in successful
        listener.onSignInReceived(validateSignIn(name, password))
    }

    override fun signUp(listener: SignInImplementation.SignInListener) {
        listener.onSignUp()
    }

    private fun validateSignIn(username: String, password: String): Boolean {
        //todo check shared prefs for username and password
        //firebase 3
        return password == "password"
    }

    companion object {

        val TAG = ModelSignIn::class.java.simpleName
    }
}