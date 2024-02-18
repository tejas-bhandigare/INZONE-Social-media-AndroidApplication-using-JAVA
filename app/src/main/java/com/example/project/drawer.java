package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class drawer extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageView buttonDrawerToggle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView);


        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();





                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        int itemId = item.getItemId();

                        switch (itemId) {
                            case R.id.navprofileedit:
                                startActivity(new Intent(drawer.this, set_your_profile.class));
                                break;
                            case R.id.navlout:
                                startActivity(new Intent(drawer.this, Log_in.class));
                                break;

                            case R.id.navforgot:
                                startActivity(new Intent(drawer.this, Forgot_Password.class));
                                break;

                            case R.id.nav_setting:
                                startActivity(new Intent(drawer.this, Settings.class));
                                break;

                            case R.id.navabout:
                                startActivity(new Intent(drawer.this, Aboutus.class));
                                break;

                            // Add cases for other menu items as needed
                        }
                        drawerLayout.close();

                        return false;
                    }


                });
            }
        });


    }
}