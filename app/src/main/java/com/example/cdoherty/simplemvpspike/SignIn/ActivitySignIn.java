package com.example.cdoherty.simplemvpspike.SignIn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cdoherty.simplemvpspike.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivitySignIn extends AppCompatActivity implements ViewSignIn {

    private PresenterSignIn presenter;

    @OnClick(R.id.sign_in)
    void signInClicked() {
        presenter.onSignInClick();
    }

    @OnClick(R.id.sign_up)
    void signUpClicked(){
        presenter.onSignUpClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenter = new PresenterSignIn(this, new ModelSignIn());
    }

    @Override
    public void provideFeedback(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
