package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.admin_login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered username and password
                EditText usernameEditText = findViewById(R.id.admin_username);
                EditText passwordEditText = findViewById(R.id.admin_password);
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if the entered username and password match the admin credentials
                if (username.equals("admin1") && password.equals("admin@123")) {
                    // Credentials match, proceed to the next activity
                    Intent intent = new Intent(MainActivity.this, Admin_Panel.class);
                    startActivity(intent);
                } else {
                    // Credentials do not match, display an error message
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}