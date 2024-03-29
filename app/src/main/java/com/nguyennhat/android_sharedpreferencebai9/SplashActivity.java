package com.nguyennhat.android_sharedpreferencebai9;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
//    private SharedPreferences sharedPreferences;
    private MyPreference sharedPreferences;
    boolean isLogged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //sharedPreferences = getSharedPreferences("abc", MODE_PRIVATE);
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences = MyPreference.getInstance();
        isLogged = sharedPreferences.get("key_auto", Boolean.class);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isLogged) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, 3000);

    }
}
