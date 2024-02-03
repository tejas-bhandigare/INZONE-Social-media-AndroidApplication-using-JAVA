package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

public class UserDataActivity extends AppCompatActivity {

    private EditText usernameEditText, bioEditText, emailEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        usernameEditText = findViewById(R.id.usernameEditText);
        bioEditText = findViewById(R.id.bioEditText);
        emailEditText = findViewById(R.id.emailEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserDataToFirebase();
            }
        });
    }

    private void saveUserDataToFirebase() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();

        if (firebaseUser != null) {
            String userId = firebaseUser.getUid();
            String username = usernameEditText.getText().toString().trim();
            String bio = bioEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();

            if (!username.isEmpty() && !bio.isEmpty() && !email.isEmpty()) {
                DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");

                // Create a User object
                UserInfo userInfo = new UserInfo(userId, username, bio, email);

                // Store the user information in the Realtime Database
                usersRef.child(userId).setValue(userInfo);

                // Optionally, you can also show a success message or redirect the user
                // based on your app's flow.
            } else {
                // Handle empty fields, show an error message, etc.
            }
        }
    }

}
