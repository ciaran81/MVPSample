package com.example.cdoherty.simplemvpspike.SignIn;

/**
 * Created by cdoherty on 27/02/2018.
 */

public interface SignInImplementation {

     interface SignInListener {
        void onSignInReceived(String message);

        void onSignUpReceived(String message);
    }

    void signIn(String username, String password, SignInListener listener);

    void signUp(String name, String username, SignInListener listener);

}
