package com.example.sensor_10119088_if3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.sensor_10119088_if3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    //10119088 Laurentius Bryan Hermanto IF3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Fragment fragment = new MapsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentBase,fragment)
                .commit();
        replaceFragment(new ProfileFragment());


        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.Profil:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.Food:
                    replaceFragment(new FoodFragment());
                    break;
                case R.id.Maps:
                    replaceFragment(new MapsFragment());
                    break;
                case R.id.Info:
                    replaceFragment(new InfoFragment());
                    break;
            }

            return true;
        });
    }



    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBase,fragment);
        fragmentTransaction.commit();
    }

}