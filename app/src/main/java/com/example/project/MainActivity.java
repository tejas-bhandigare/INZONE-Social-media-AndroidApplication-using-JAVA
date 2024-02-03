package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_next;
        btn_next=findViewById(R.id.login_btn);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext;
                inext=new Intent(MainActivity.this,Log_in.class);
                startActivity(inext);
            }
        });

        Button btn_next1;
        btn_next1=findViewById(R.id.signup_btn);

        btn_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext;
                inext=new Intent(MainActivity.this,Sign_up.class);
                startActivity(inext);
            }
        });

        // Get the ImageView reference
        ImageView logoImageView = findViewById(R.id.logoImageView);

        // Load the animation from the XML file
        Animation popUpAnimation = AnimationUtils.loadAnimation(this, R.anim.p_name);

        // Set the animation on the ImageView
        logoImageView.startAnimation(popUpAnimation);











    }
}