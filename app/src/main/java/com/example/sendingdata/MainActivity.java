package com.example.sendingdata;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sendingdata.Fragments.TechnologyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragment(new TechnologyFragment("Technology"));

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                bottomNavigationView.getMenu().findItem(item.getItemId()).setChecked(true);

                Fragment fragment = null;
                if (item.getItemId() == R.id.item_chats) {
                    fragment=new TechnologyFragment("Technology");
                } else if (item.getItemId() == R.id.item_status) {
                    fragment = new TechnologyFragment("sport");
                } else if (item.getItemId() == R.id.item_calls) {
                    fragment = new TechnologyFragment("business");
                }
              showFragment(fragment);
                return false;
            }
        });

    }
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();

    }


}

