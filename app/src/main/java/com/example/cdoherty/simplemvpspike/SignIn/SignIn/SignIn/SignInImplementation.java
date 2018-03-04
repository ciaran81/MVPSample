package com.example.cdoherty.simplemvpspike.SignIn.SignIn.SignIn;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;

/**
 * Created by cdoherty on 27/02/2018.
 */

public interface SignInImplementation {

    interface SignInListener {
        void onSignInReceived(boolean isSignedIn);

        void onSignUp();

    }

    interface SignUpListener {
        void onSignedUp(boolean isSuccessful);
    }

    void signIn(String username, String password, SignInListener listener);

    void signUp(SignInListener listener);

}
