package com.example.drawernavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
     DrawerLayout drawerLayout;
     ImageButton buttonDrawerToggle;
     NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        drawerLayout = findViewById(R.id.main);
        buttonDrawerToggle = findViewById(R.id.button_Drawer_Toggle);
        navigationView = findViewById(R.id.navigationView);

        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });
        View headerView = navigationView.getHeaderView(0);
        ImageView userImage = headerView.findViewById(R.id.userImage);
        TextView textUsername = headerView.findViewById(R.id.textUsername);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, textUsername.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navMenu) {
                    Toast.makeText(MainActivity.this, "Menu Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navCart) {
                    Toast.makeText(MainActivity.this, "Cart Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navFavourite) {
                    Toast.makeText(MainActivity.this, "Favourite Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navOrder) {
                    Toast.makeText(MainActivity.this, "Orders Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navHistory) {
                    Toast.makeText(MainActivity.this, "History Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navFeedback) {
                    Toast.makeText(MainActivity.this, "Feedback Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navTerms) {
                    Toast.makeText(MainActivity.this, "Terms and Conditions Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navContact) {
                    Toast.makeText(MainActivity.this, "Contact Us Clicked", Toast.LENGTH_SHORT).show();
                }
                if (itemId == R.id.navShare) {
                    Toast.makeText(MainActivity.this, "Share Clicked", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.close();

                return false;
            }
        });
    }
}