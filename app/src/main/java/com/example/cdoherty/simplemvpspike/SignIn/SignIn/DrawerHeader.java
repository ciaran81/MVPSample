package com.example.cdoherty.simplemvpspike.SignIn.SignIn;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.cdoherty.simplemvpspike.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by cdoherty on 04/03/2018.
 */

@NonReusable
@Layout(R.layout.nav_header_layout)
public class DrawerHeader {

    @View(R.id.profileImageView)
    private ImageView profileImage;

    @View(R.id.nameTxt)
    private TextView nameTxt;

    @View(R.id.emailTxt)
    private TextView emailTxt;

    @Resolve
    private void onResolved() {
        nameTxt.setText("Ciaran Doherty");
        emailTxt.setText("gmail.com");
    }
}