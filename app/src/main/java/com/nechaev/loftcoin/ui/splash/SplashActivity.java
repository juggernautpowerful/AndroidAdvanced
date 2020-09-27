package com.nechaev.loftcoin.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.nechaev.loftcoin.R;
import com.nechaev.loftcoin.ui.main.MainActivity;
import com.nechaev.loftcoin.ui.welcome.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {

    private final Handler handler = new Handler();

    private SharedPreferences prefs;

    private Runnable goNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (prefs.getBoolean(WelcomeActivity.KEY_SHOW_WELCOME, true)){
            goNext = () -> startActivity(new Intent(this, WelcomeActivity.class));
        } else {
            goNext = () -> startActivity(new Intent(this, MainActivity.class));
        }

        handler.postDelayed(goNext, 1500);
    }

    @Override
    protected void onStop() {
        handler.removeCallbacks(goNext);
        super.onStop();
    }
}
