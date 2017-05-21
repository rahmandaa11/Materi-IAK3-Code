package com.example.rahmanda.iakranda1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Splash Screen adalah tampilan awal sekilas(hanya beberapa detik) ketika aplikasi pertama kali di buka
public class SplashScreen extends AppCompatActivity {
    private static int WAKTU_SPLASH = 3000; //mengatur lama nya waktu splash screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class); //pindah halaman dari SplashScreen ke MainActivity
                startActivity(i);
                finish();
            }
        }, WAKTU_SPLASH);
    }
}
