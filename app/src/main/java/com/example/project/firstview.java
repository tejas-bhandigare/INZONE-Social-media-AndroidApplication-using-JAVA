package com.example.project;

import static com.google.android.material.navigation.NavigationView.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class firstview extends AppCompatActivity {

    Button btn;


   @SuppressLint({"MissingInflatedId", "WrongViewCast"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstview);


       ImageView myImageView4 = findViewById(R.id.buttonDrawerToggle);

       myImageView4.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               // Handle the click event, e.g., start the next activity
               Intent intent = new Intent(firstview.this,drawer.class);
               startActivity(intent);
           }
       });




       animateLetter(R.id.textViewI, 1000); // Delay by 1000 milliseconds (1 second)
       animateLetter(R.id.textViewN, 2000); // Delay by 2000 milliseconds (2 seconds)
       animateLetter(R.id.textViewz, 3000);
       animateLetter(R.id.textViewo, 4000);
       animateLetter(R.id.textViewN2, 5000);
       animateLetter(R.id.textViewe, 6000);












       ImageView myImageView1 = findViewById(R.id.add_post);

       myImageView1.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               // Handle the click event, e.g., start the next activity
               Intent intent = new Intent(firstview.this, UploadPostsActivity.class);
               startActivity(intent);
           }
       });



       ImageView myImageView2 = findViewById(R.id.search_user);

       myImageView2.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               // Handle the click event, e.g., start the next activity
               Intent intent = new Intent(firstview.this, search_user.class);
               startActivity(intent);
           }
       });






       ImageView myImageView = findViewById(R.id.profileset);

        myImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event, e.g., start the next activity
                Intent intent = new Intent(firstview.this,PostViewActivity.class);
                startActivity(intent);
            }
        });



    }



    private void animateLetter(int textViewId, int startDelay) {
        TextView textView = findViewById(textViewId);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.p_name);
        animation.setStartOffset(startDelay);
        textView.startAnimation(animation);
    }


}