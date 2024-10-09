package com.example.baitapltdd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DetailActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                finish(); // Quay về MainActivity
                return true;
            } else if (item.getItemId() == R.id.navigation_dashboard) {
                finish();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("navigation_position", 1);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.navigation_notifications) {
                finish();
                Intent intent = new Intent(this, NotificationsActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}
