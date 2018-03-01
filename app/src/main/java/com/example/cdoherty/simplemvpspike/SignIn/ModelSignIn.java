package com.example.cdoherty.simplemvpspike.SignIn;

import android.util.Log;

import com.google.firebase.crash.FirebaseCrash;

/**
 * Created by cdoherty on 27/02/2018.
 */

public class ModelSignIn implements SignInImplementation {

    public static final String TAG = ModelSignIn.class.getSimpleName();
    private SignUpDialog signUpDialog;


    @Override
    public void signIn(String name, String password, SignInListener listener) {
        //if sign in successful
        listener.onSignInReceived(validateSignIn(name, password));
    }

    @Override
    public void signUp(SignInListener listener) {
        listener.onSignUp();
    }

    private boolean validateSignIn(String username, String password) {
        //todo check shared prefs for username and password
        return (password.equals("password"));
    }
}
