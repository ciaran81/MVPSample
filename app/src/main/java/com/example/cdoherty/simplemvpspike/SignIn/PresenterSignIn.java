package com.example.cdoherty.simplemvpspike.SignIn;

import android.util.Log;
import android.view.View;

/**
 * Created by cdoherty on 27/02/2018.
 */

public class PresenterSignIn implements SignInInteractor, SignInImplementation.SignInListener{

    private ViewSignIn viewSignIn;
    private ModelSignIn modelSignIn;

    public PresenterSignIn(ViewSignIn viewSignIn, ModelSignIn modelSignIn) {
        this.viewSignIn = viewSignIn;
        this.modelSignIn = modelSignIn;
    }

    @Override
    public void onSignInClick() {
        modelSignIn.signIn("....", "...", this);

    }

    @Override
    public void onSignUpClick() {
        modelSignIn.signUp("..", "...", this);
    }

    @Override
    public void onSignInReceived(String message) {
        viewSignIn.provideFeedback(message);
    }

    @Override
    public void onSignUpReceived(String message) {
        viewSignIn.provideFeedback(message);
    }

}
