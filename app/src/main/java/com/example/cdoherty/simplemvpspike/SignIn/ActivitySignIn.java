package com.example.cdoherty.simplemvpspike.SignIn;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.crashlytics.android.Crashlytics;
import com.example.cdoherty.simplemvpspike.R;
import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivitySignIn extends AppCompatActivity implements ViewSignIn, SignInImplementation.SignUpListener {
    public static final String TAG = ActivitySignIn.class.getSimpleName();
    private PresenterSignIn presenter;
    private FirebaseAnalytics firebaseAnalytics;
    
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
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ButterKnife.bind(this);
        presenter = new PresenterSignIn(this, new ModelSignIn());
    }

    @Override
    public void signIn(boolean isSignedIn) {
        String signIn = isSignedIn ? "success" : "failure";
        Log.d(TAG, "signIn: " + signIn);
    }

    @Override
    public void signUp() {
        showSignUpDialog();
    }

    private void showSignUpDialog(){
        DialogFragment signUpDialog = new SignUpDialog();
        signUpDialog.show(getFragmentManager(), "SignUpDialog");
    }


    @Override
    public void onSignedUp(boolean isSuccessful) {
        Log.d(TAG, "onSignedUp: " + isSuccessful);
    }
}
