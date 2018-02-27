package com.example.cdoherty.simplemvpspike.SignIn;

import android.util.Log;

/**
 * Created by cdoherty on 27/02/2018.
 */

public class ModelSignIn implements SignInImplementation {

    public static final String TAG = ModelSignIn.class.getSimpleName();

    @Override
    public void signIn(String name, String password, SignInListener listener) {
        Log.d(TAG, "signIn: " + name + " " + password);
        //if sign in successful
        listener.onSignInReceived(validateSignIn(name, password));
    }

    @Override
    public void signUp(SignInListener listener) {
        listener.onSignUpReceived();
    }

    private boolean validateSignIn(String username, String password) {
        //todo check shared prefs for username and password
        return (password.equals("password"));
    }
}
