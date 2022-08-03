package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class PreLoginActivity extends AppCompatActivity {

    ImageView logo;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the action bar when not needed
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pre_login);
        btn = findViewById(R.id.startBtn);
        logo = findViewById(R.id.logo);

        // These start the animations (source:https://www.youtube.com/watch?v=fqU4zc_XeX0)
        Animation animation=AnimationUtils.loadAnimation(this, R.anim.fadein);
        Animation animation2 =AnimationUtils.loadAnimation(this, R.anim.fadein);
        logo.startAnimation(animation);
        // Slight delay for second animation
        try {
            Thread.sleep(10000);
            btn.startAnimation((animation2));
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PreLoginActivity.this, LoginActivity.class));
            }
        });
    }
}