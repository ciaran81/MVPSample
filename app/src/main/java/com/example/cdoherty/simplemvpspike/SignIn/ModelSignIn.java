package com.example.cdoherty.simplemvpspike.SignIn;

import android.util.Log;

/**
 * Created by cdoherty on 27/02/2018.
 */

public class ModelSignIn implements SignInImplementation {

    public ModelSignIn() {
    }

    @Override
    public void signIn(String name, String username, SignInListener listener) {
        listener.onSignInReceived("sign in received");
    }

    @Override
    public void signUp(String name, String username, SignInListener listener) {
        listener.onSignUpReceived("sign up received");
    }

    //todo act on when the buttons are pressed through the presenter
}
