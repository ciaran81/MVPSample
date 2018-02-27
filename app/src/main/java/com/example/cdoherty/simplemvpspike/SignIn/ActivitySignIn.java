package com.example.cdoherty.simplemvpspike.SignIn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cdoherty.simplemvpspike.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivitySignIn extends AppCompatActivity implements ViewSignIn {
    public static final String TAG = ActivitySignIn.class.getSimpleName();
    private PresenterSignIn presenter;
    
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    @OnClick(R.id.sign_in)
    void signInClicked() {
        presenter.onSignInClick(username.getText().toString(), password.getText().toString());
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
    public void signIn(boolean isSignedIn) {
        //if signed in display the next activity 
        //else display login error
        String signIn = isSignedIn ? "success" : "failure";
        Log.d(TAG, "signIn: " + signIn);
    }

    @Override
    public void signUp() {
        //display signup view
        Log.d(TAG, "signUp: ");
    }
}
