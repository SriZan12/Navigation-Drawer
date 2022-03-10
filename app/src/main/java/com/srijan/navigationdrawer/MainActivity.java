package com.srijan.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import Fragments.AccountFragment;
import Fragments.HelpFragment;
import Fragments.HomeFragment;
import Fragments.SettingFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout layout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        layout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationdraw);


        toggle = new ActionBarDrawerToggle(this,layout,toolbar,R.string.open,R.string.close);
        layout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment tempFragment = null;

                switch (item.getItemId()){
                    case R.id.home :
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        tempFragment = new HomeFragment();
                        layout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Your Account", Toast.LENGTH_SHORT).show();
                        tempFragment = new AccountFragment();
                        layout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.setting:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        tempFragment = new SettingFragment();
                        layout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.help:
                        Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
                        tempFragment = new HelpFragment();
                        layout.closeDrawer(GravityCompat.START);
                        break;

                    case R.layout.nav_header:
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.linearLayout,tempFragment).commit();
                return true;
            }
        });




    }
}