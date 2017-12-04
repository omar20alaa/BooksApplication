package com.ahlyclub.omar2.booksapplication.Activity.Activity.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.ahlyclub.omar2.booksapplication.R;

public class SplashScreen extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_splash_screen);
        findID();
        AnimationScreen();
        runnable();
    }




    public void findID()
    {
        textView = findViewById(R.id.splashScreen);
    }


    public void AnimationScreen() {
        Animation animation = new AnimationUtils().loadAnimation(SplashScreen.this, R.anim.animate);
        textView.startAnimation(animation);

    }

    public void runnable()
    {
        new Handler().postDelayed(new Runnable()
        {

            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this ,MainActivity.class );
                startActivity(intent);
                finish();
            }
        }, 5000);
    }



}