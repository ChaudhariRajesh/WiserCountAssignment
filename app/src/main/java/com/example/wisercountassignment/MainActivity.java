package com.example.wisercountassignment;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.wisercountassignment.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainActivityBinding;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavController navController;
    private NavHostFragment navHostFragment;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainActivityBinding.getRoot());

        setSupportActionBar(mainActivityBinding.topAppBar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mainActivityBinding.drawerLayout, R.string.app_name, R.string.app_name);

        navHostFragment = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.homeFragment, R.id.newTaskFragment)
                        .setOpenableLayout(mainActivityBinding.drawerLayout)
                        .build();

        setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(mainActivityBinding.navigationView, navController);
        NavigationUI.setupWithNavController(mainActivityBinding.bottomNavView, navController);

        mainActivityBinding.navigationView.setNavigationItemSelectedListener(item -> {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
            return false;
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}