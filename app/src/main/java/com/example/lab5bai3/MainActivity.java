package com.example.lab5bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_frame, new ChatFragment())
                .commit();

        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setOnItemSelectedListener(item -> {
            Fragment frag = new ChatFragment();
            if (item.getItemId() == R.id.map)
                frag = new MapFragment();
            if (item.getItemId() == R.id.collec)
                frag = new CollectionFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame, frag)
                    .commit();
            return true;
        });
    }
}