package mobileappdevelopmet.homework_3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import mobileappdevelopmet.homework_3.fragments.ContactFragment;
import mobileappdevelopmet.homework_3.fragments.FavoriteFragment;
import mobileappdevelopmet.homework_3.fragments.HomeFragment;
import mobileappdevelopmet.homework_3.fragments.ProductsFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @SuppressLint("NonConstantResourceId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                selectedFragment = new HomeFragment();
            } else if (id == R.id.nav_products) {
                selectedFragment = new ProductsFragment();
            } else if (id == R.id.nav_favorites) {
                selectedFragment = new FavoriteFragment();
            } else if (id == R.id.nav_contact) {
                selectedFragment = new ContactFragment();
            }

            return loadFragment(selectedFragment);
        });

    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
