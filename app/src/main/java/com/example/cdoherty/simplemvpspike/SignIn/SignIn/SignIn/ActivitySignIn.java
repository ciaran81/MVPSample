package com.example.cdoherty.simplemvpspike.SignIn.SignIn.SignIn;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cdoherty.simplemvpspike.R;
import com.example.cdoherty.simplemvpspike.SignIn.SignIn.CalendarActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivitySignIn extends AppCompatActivity implements ViewSignIn, SignInImplementation.SignUpListener {
    public static final String TAG = ActivitySignIn.class.getSimpleName();
    public static final int RC_SIGN_IN = 1111;
    private PresenterSignIn presenter;
    private FirebaseAnalytics firebaseAnalytics;
    private GoogleSignInClient mGoogleSignInClient;

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.sign_in_button)
    SignInButton signInButton;

    @OnClick(R.id.sign_in)
    void signInClicked() {
        presenter.onSignInClick(username.getText().toString(), password.getText().toString());
    }

    @OnClick(R.id.sign_up)
    void signUpClicked() {
        presenter.onSignUpClick();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ButterKnife.bind(this);
        presenter = new PresenterSignIn(this, new ModelSignIn());
        FirebaseCrash.log("Activity created");
        setUpGoogleClient();

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void setUpGoogleClient() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    @Override
    public void signIn(boolean isSignedIn) {
        if (isSignedIn) {
            Log.d(TAG, "signIn: ");
        } else {
            Toast.makeText(this, "Sign in unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            Toast.makeText(this,
                    "Welcome back " + account.getDisplayName(), Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startNextActivity();
        }
    }

    private void startNextActivity() {
        Intent calendarIntent = new Intent(this, CalendarActivity.class);
        startActivity(calendarIntent);
    }

    @Override
    public void signUp() {
        showSignUpDialog();
    }

    private void showSignUpDialog() {
        DialogFragment signUpDialog = new SignUpDialog();
        signUpDialog.show(getFragmentManager(), "SignUpDialog");
    }


    @Override
    public void onSignedUp(boolean isSuccessful) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Toast.makeText(this,
                    "Welcome " + account.getDisplayName(), Toast.LENGTH_SHORT).show();
            startNextActivity();

        } catch (ApiException e) {
            Toast.makeText(this, "Sign In Failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
