package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class set_your_profile extends AppCompatActivity {
    private EditText Usernameedt, UserBioedt;
    private Button profilesubmit;
    private FirebaseFirestore db;

    private String User_name, User_bio;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_your_profile);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView myImageView = findViewById(R.id.backbtn);
     myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event, e.g., start the next activity
                Intent intent = new Intent(set_your_profile.this, firstview.class);
                startActivity(intent);
            }
        });

        db = FirebaseFirestore.getInstance();

        Usernameedt= findViewById(R.id.profile_username);

        UserBioedt = findViewById(R.id.profile_bio);

        profilesubmit = findViewById(R.id.Profile_Submit);

        profilesubmit.setOnClickListener(v -> {
                    User_name = Usernameedt.getText().toString();

                    User_bio = UserBioedt.getText().toString();


            if (TextUtils.isEmpty(User_name)){
                Usernameedt.setError("Please enter Course Name");
            }else if (TextUtils.isEmpty(User_bio)) {
                UserBioedt.setError("Please enter Course Description");
            }  else {
                // calling method to add data to Firebase Firestore.
                addDataToFirestore(User_name, User_bio);
            }
        });
    }
    private void addDataToFirestore(String User_name, String User_bio) {

        // creating a collection reference
        // for our Firebase Firestore database.
        CollectionReference dbCourses = db.collection("user_profile");

        // adding our data to our courses object class.
        user_profile profile = new user_profile(User_name, User_bio);

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(profile).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(set_your_profile.this, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(set_your_profile.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

}


