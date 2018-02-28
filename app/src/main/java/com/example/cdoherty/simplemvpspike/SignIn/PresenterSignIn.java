package com.example.cdoherty.simplemvpspike.SignIn;

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
    public void onSignInClick(String username, String password) {
        modelSignIn.signIn(username, password, this);

    }

    @Override
    public void onSignUpClick() {
        modelSignIn.signUp( this);
    }

    @Override
    public void onSignInReceived(boolean isSignedIn) {
        viewSignIn.signIn(isSignedIn);
    }

    @Override
    public void onSignUp() {
        viewSignIn.signUp();
    }

}
