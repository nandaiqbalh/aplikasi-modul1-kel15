package com.nandaiqbalh.aplikasimodul1kel15.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.nandaiqbalh.aplikasimodul1kel15.R;
import com.nandaiqbalh.aplikasimodul1kel15.ui.login.LoginActivity;

public class SplashscreenActivity extends AppCompatActivity {
    private static int splashInterval = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashcreen);

        handler();
    }
    private void handler(){
        new Handler().postDelayed(() -> {
            if (initPreference()){
                Intent main = new Intent(SplashscreenActivity.this, MainActivity.class);
                startActivity(main);
                finish();
            } else {
                Intent i = new Intent(SplashscreenActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, splashInterval);
    }

    private Boolean initPreference() {
        SharedPreferences preferences = getSharedPreferences("LoginPreference", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        if (username.isEmpty()){
            return false;
        }

        return true;
    }
}
