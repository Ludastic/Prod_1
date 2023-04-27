package com.example.prod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.prod.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new AchivementsFragment());

        binding.bottom.setOnItemSelectedListener(item -> {

            /*switch (item.getItemId()) {
                case R.id.tasks:
                    replaceFragment(new TaskFragment());
                    break;
                case R.id.achivements:
                    replaceFragment(new AchivementsFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;


            }*/
            if (item.getItemId() == R.id.tasks) {
                replaceFragment(new TaskFragment());
            }
            else if(item.getItemId() == R.id.achivements) {
                replaceFragment(new AchivementsFragment());
            }
            else if(item.getItemId() == R.id.profile) {
                replaceFragment(new ProfileFragment());
            }

            return true;
        } );
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}