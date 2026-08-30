package com.example.playzone.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.playzone.R;

// Contains an ActionBar and BottomNavigationView / TabLayout with a FrameLayout for Fragments

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.playzone.R;
import com.example.playzone.fragment.CartFragment;
import com.example.playzone.fragment.CategoriesFragment;
import com.example.playzone.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize BottomNavigationView from layout
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 2. Set default fragment on initial launch (HomeFragment)
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }

        // 3. Set listener for bottom navigation item selection
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();

                if (itemId == R.id.nav_home) {
                    selectedFragment = new HomeFragment();
                } else if (itemId == R.id.nav_categories) {
                    selectedFragment = new CategoriesFragment();
                } else if (itemId == R.id.nav_cart) {
                    selectedFragment = new CartFragment();
                }

                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                    return true;
                }
                return false;
            }
        });
    }

    // Helper method to handle fragment transactions smoothly
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}