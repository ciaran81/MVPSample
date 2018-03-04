package com.example.cdoherty.simplemvpspike.SignIn.SignIn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.cdoherty.simplemvpspike.R;

/**
 * Created by cdoherty on 03/03/2018.
 */

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.drawer_layout;
    }
    

    @Override
    public void onProfileMenuSelected() {
        Log.d(TAG, "onProfileMenuSelected: profile");

    }

    @Override
    public void onRequestMenuSelected() {

    }

    @Override
    public void onGroupsMenuSelected() {

    }

    @Override
    public void onMessagesMenuSelected() {

    }

    @Override
    public void onNotificationsMenuSelected() {

    }

    @Override
    public void onSettingsMenuSelected() {

    }

    @Override
    public void onTermsMenuSelected() {

    }

    @Override
    public void onLogoutMenuSelected() {

    }

}
