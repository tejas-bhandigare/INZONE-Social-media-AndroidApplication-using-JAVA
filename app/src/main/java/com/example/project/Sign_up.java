package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;

import android.widget.EditText;

import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_up extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText signupEmail,signupPassword;
    private Button signupButton;
    private TextView loginRedirectText;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextView txt;
        txt=findViewById(R.id.log_in_Redirect);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent itxt;
                itxt=new Intent(Sign_up.this,Log_in.class);
                startActivity(itxt);

            }
        });

        auth=FirebaseAuth.getInstance();
        signupEmail=findViewById(R.id.sign_up_mail);
        signupPassword =findViewById(R.id.sign_up_pass);
        signupButton=findViewById(R.id.sign_up_btn);
        loginRedirectText=findViewById(R.id.log_in_Redirect);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= signupEmail.getText().toString().trim();
                String pass=signupPassword.getText().toString().trim();


                if(user.isEmpty()){
                    signupEmail.setError("Email can not be empty");
                }
                if(pass.isEmpty()){
                    signupPassword.setError("Password can not be empty");
                }else {
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Sign_up.this, "signup sucessfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Sign_up.this,Log_in.class));
                            } else {
                                Toast.makeText(Sign_up.this, "signup failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



    }
}