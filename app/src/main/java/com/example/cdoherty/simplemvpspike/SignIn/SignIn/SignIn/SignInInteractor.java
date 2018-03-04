package com.example.cdoherty.simplemvpspike.SignIn.SignIn.SignIn;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

/**
 * Created by cdoherty on 27/02/2018.
 */

public interface SignInInteractor {
    void onSignInClick(String username, String password);

    void onSignUpClick();
}
