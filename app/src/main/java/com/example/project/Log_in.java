package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Log_in extends AppCompatActivity {


    private FirebaseAuth auth;
    private EditText loginEmail,loginPassword;
    private TextView signupRedirectText;
    private Button loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView txt;
        txt=findViewById(R.id.sign_up_Redirect);


        // Check if the user is already logged in when the activity starts
        SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            // User is already logged in, navigate to the main screen
            startActivity(new Intent(this, firstview.class));
            finish(); // Finish the LoginActivity
        }

// Login logic...

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itxt;
                itxt=new Intent(Log_in.this,Sign_up.class);
                startActivity(itxt);

            }
        });

        auth=FirebaseAuth.getInstance();
        loginEmail=findViewById(R.id.log_in_mail);
        loginPassword=findViewById(R.id.log_in_pass);
        loginButton=findViewById(R.id.log_in_btn);
        signupRedirectText=findViewById(R.id.sign_up_Redirect);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =loginEmail.getText().toString();
                String pass = loginPassword.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    if (!pass.isEmpty()){
                        auth.signInWithEmailAndPassword(email,pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(Log_in.this, "Lognin sucessfull", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Log_in.this,firstview.class));
                                       finish();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Log_in.this, "Log in failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        loginPassword.setError("Password can not be empty");
                    }

                } else if (email.isEmpty()){
                    loginEmail.setError("email can not be blank ");
                } else {
                    loginEmail.setError("please enter valid email");
                }
            }
        });





    }
}