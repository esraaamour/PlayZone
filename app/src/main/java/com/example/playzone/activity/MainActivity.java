package com.example.playzone.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.playzone.R;
import com.example.playzone.fragment.CartFragment;
import com.example.playzone.fragment.CategoriesFragment;
import com.example.playzone.fragment.HomeFragment;
import com.example.playzone.utils.CartManager;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize BottomNavigationView from layout
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // set default fragment on initial launch (HomeFragment)
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }

        // Set listener for bottom navigation item selection
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

    @Override
    protected void onResume() {
        super.onResume();
        // Retrieve the actual count stored in CartManager and update the counter whenever the screen appears.
        int currentCount = CartManager.getInstance().getCartCount();
        updateCartBadge(currentCount);
    }

    // Helper method to handle fragment transactions smoothly
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    public void updateCartBadge(int count) {
        if (bottomNavigationView != null) {
            BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.nav_cart);
            if (count > 0) {
                badgeDrawable.setVisible(true);
                badgeDrawable.setNumber(count);
                badgeDrawable.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
                badgeDrawable.setBadgeTextColor(ContextCompat.getColor(this, android.R.color.white));
            } else {
                badgeDrawable.setVisible(false);
            }
        }
    }
}