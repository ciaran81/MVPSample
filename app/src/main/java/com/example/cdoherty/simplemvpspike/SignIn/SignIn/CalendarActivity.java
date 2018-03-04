package com.example.cdoherty.simplemvpspike.SignIn.SignIn;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.cdoherty.simplemvpspike.R;

/**
 * Created by cdoherty on 04/03/2018.
 */

public class CalendarActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_calendar, null, false);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_calendar;
    }

    @Override
    public void onProfileMenuSelected() {

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
