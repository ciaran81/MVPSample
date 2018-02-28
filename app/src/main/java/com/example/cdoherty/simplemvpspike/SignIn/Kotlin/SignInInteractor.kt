package com.example.cdoherty.simplemvpspike.SignIn.Kotlin

/**
 * Created by cdoherty on 28/02/2018.
 */
interface SignInInteractor {
    fun onSignInClick(username: String, password: String)

    fun onSignUpClick()
}