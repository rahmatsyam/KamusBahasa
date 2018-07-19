package com.example.user.kamusbahasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        View easySplashScreenView = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundResource(R.color.colorPrimary)
                //.withHeaderText("Header")
                .withFooterText("Copyright 2018 by \nNur Fitriah Mukhlis")
                .withBeforeLogoText("Kamus Aneka Bahasa")
                .withLogo(R.drawable.splash_logo)
                .withBackgroundColor(R.color.colorWhite)
                //.withAfterLogoText("Kamus Aneka Bahasa")
                .create();

        setContentView(easySplashScreenView);
    }
}
