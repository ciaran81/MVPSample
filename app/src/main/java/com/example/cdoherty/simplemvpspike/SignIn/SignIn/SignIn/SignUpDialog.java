package com.example.cdoherty.simplemvpspike.SignIn.SignIn.SignIn;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


import com.example.cdoherty.simplemvpspike.R;


/**
 * Created by cdoherty on 28/02/2018.
 */

public class SignUpDialog extends DialogFragment {

    private SignInImplementation.SignUpListener listener;
    public static final String TAG = SignUpDialog.class.getSimpleName();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (SignInImplementation.SignUpListener) activity;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.signup_dialog, null);
        final EditText name = view.findViewById(R.id.signup_name);
        final EditText username = view.findViewById(R.id.signup_username);
        final EditText password = view.findViewById(R.id.signup_password);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Sign Up", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //todo validate the credentials and update view
                listener.onSignedUp(validateCredentials(String.valueOf(name.getText()),
                        String.valueOf(username.getText()), String.valueOf(password.getText())));
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SignUpDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    private boolean validateCredentials(String name, String username, String password) {
        return (!name.isEmpty() && !username.isEmpty() && !password.isEmpty());
    }
}

