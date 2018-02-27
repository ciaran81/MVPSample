package com.example.cdoherty.simplemvpspike.SignIn;

/**
 * Created by cdoherty on 27/02/2018.
 */

public interface SignInInteractor {
    void onSignInClick(String username, String password);

    void onSignUpClick();
}
