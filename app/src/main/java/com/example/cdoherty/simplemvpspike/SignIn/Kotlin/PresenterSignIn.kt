package com.example.cdoherty.simplemvpspike.SignIn.Kotlin

import com.example.cdoherty.simplemvpspike.SignIn.ModelSignIn
import com.example.cdoherty.simplemvpspike.SignIn.SignInImplementation
import com.example.cdoherty.simplemvpspike.SignIn.SignInInteractor
import com.example.cdoherty.simplemvpspike.SignIn.ViewSignIn

/**
 * Created by cdoherty on 28/02/2018.
 */
class PresenterSignIn(private val viewSignIn: ViewSignIn, private val modelSignIn: ModelSignIn) : SignInInteractor, SignInImplementation.SignInListener {

    override fun onSignInClick(username: String, password: String) {
        modelSignIn.signIn(username, password, this)

    }

    override fun onSignUpClick() {
        modelSignIn.signUp(this)
    }

    override fun onSignInReceived(isSignedIn: Boolean) {
        viewSignIn.signIn(isSignedIn)
    }

    override fun onSignUp() {
        viewSignIn.signUp()
    }

}