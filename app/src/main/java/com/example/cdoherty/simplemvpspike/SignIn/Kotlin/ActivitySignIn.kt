package com.example.cdoherty.simplemvpspike.SignIn.Kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.EditText
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.cdoherty.simplemvpspike.R
import com.example.cdoherty.simplemvpspike.SignIn.*
import com.google.firebase.analytics.FirebaseAnalytics

class ActivitySignIn : AppCompatActivity(), ViewSignIn, SignInImplementation.SignUpListener {
    private var presenter: PresenterSignIn? = null
    private var firebaseAnalytics: FirebaseAnalytics? = null

    @BindView(R.id.username)
    internal var username: EditText? = null
    @BindView(R.id.password)
    internal var password: EditText? = null

    @OnClick(R.id.sign_in)
    internal fun signInClicked() {
        presenter!!.onSignInClick(username!!.text.toString(), password!!.text.toString())
    }

    @OnClick(R.id.sign_up)
    internal fun signUpClicked() {
        presenter!!.onSignUpClick()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        ButterKnife.bind(this)
        presenter = PresenterSignIn(this, ModelSignIn())
    }

    override fun signIn(isSignedIn: Boolean) {
        val signIn = if (isSignedIn) "success" else "failure"
        Log.d(TAG, "signIn: " + signIn)
    }

    override fun signUp() {
        showSignUpDialog()
    }

    private fun showSignUpDialog() {
        val signUpDialog = SignUpDialog()
        signUpDialog.show(fragmentManager, "SignUpDialog")
    }


    override fun onSignedUp(isSuccessful: Boolean) {
        Log.d(TAG, "onSignedUp: " + isSuccessful)
    }

    companion object {
        val TAG = ActivitySignIn::class.java!!.getSimpleName()
    }
}
