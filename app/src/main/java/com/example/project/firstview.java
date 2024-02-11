package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;



public class firstview extends AppCompatActivity {

    Button btn;


   @SuppressLint({"MissingInflatedId", "WrongViewCast"})

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstview);

       Button logoutButton = findViewById(R.id.logout);

       logoutButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // Implement logout functionality here
               logout();
           }
       });


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

//       ImageView myImageView5 = findViewById(R.id.displayallposts);
//
//       myImageView5.setOnClickListener(new OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               // Handle the click event, e.g., start the next activity
//               Intent intent = new Intent(firstview.this,DisplayAllPost.class);
//               startActivity(intent);
//           }
//       });

       ImageView myImageView3 = findViewById(R.id.usersinfo);

       myImageView3.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               // Handle the click event, e.g., start the next activity
               Intent intent = new Intent(firstview.this, UserDataActivity.class);
               startActivity(intent);
           }
       });



//       ImageView myImageView4 = findViewById(R.id.drawer_menu);
//
//       myImageView4.setOnClickListener(new OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               // Handle the click event, e.g., start the next activity
//               Intent intent = new Intent(firstview.this, Drawer_Activity.class);
//               startActivity(intent);
//           }
//       });

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
    private void logout() {
        // Perform any necessary logout actions, such as clearing user session, etc.

        // After logout, you might want to navigate to the login screen or any other desired screen.
        Intent intent = new Intent(this, Log_in.class);
        startActivity(intent);

        // Finish the current activity to prevent the user from going back to the main screen using the back button.
        finish();
    }


}