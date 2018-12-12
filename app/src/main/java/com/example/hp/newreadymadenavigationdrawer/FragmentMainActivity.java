package com.example.hp.newreadymadenavigationdrawer;

import android.content.ClipData;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class FragmentMainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.Trip1:
                    Toast.makeText(FragmentMainActivity.this, "Trip1 Clicked", Toast.LENGTH_SHORT).show();

                    selectedFragment = new Trip1Fragment();
                    break;
                case R.id.Trip2:
                    Toast.makeText(FragmentMainActivity.this, "Trip2 Clicked", Toast.LENGTH_SHORT).show();
                    selectedFragment = new Trip2Fragment();
                    break;

                case R.id.Trip3:
                    Toast.makeText(FragmentMainActivity.this, "Trip3 Clicked", Toast.LENGTH_SHORT).show();
                    selectedFragment = new Trip3Fragment();
                    break;


            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        BottomNavigationView navigationView = (BottomNavigationView)findViewById(R.id.navigation);

        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Trip1Fragment()).commit();
    }



}
