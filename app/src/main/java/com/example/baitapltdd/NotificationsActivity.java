package com.example.baitapltdd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotificationsActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navigation_notifications);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_home) {
                finish();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("navigation_position", 0);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.navigation_dashboard) {
                finish();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("navigation_position", 1);
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.navigation_notifications) {
                return true;
            }
            return false;
        });
    }
}
