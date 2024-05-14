package com.nguyenthanhphong.aquariumshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Loading extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    TextView welcome, wish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        getSupportActionBar().hide();

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        welcome = findViewById(R.id.welcome);
        welcome.setAnimation(topAnim);
        wish = findViewById(R.id.wish);
        wish.setAnimation(bottomAnim);

        Thread time = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch (Exception e) {
                } finally {
                    startActivity(new Intent(Loading.this, Login.class));
                }
            }
        };
        time.start();
    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}