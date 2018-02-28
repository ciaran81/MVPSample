package com.example.cdoherty.simplemvpspike.SignIn.Kotlin

/**
 * Created by cdoherty on 28/02/2018.
 */
interface SignInImplementation {

    interface SignInListener {
        fun onSignInReceived(isSignedIn: Boolean)

        fun onSignUp()

    }

    interface SignUpListener {
        fun onSignedUp(isSuccessful: Boolean)
    }

    fun signIn(username: String, password: String, listener: SignInListener)

    fun signUp(listener: SignInListener)

}