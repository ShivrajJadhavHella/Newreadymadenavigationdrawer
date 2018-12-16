package com.example.hp.newreadymadenavigationdrawer;

import android.content.Intent;

import com.example.hp.LoginPages.LoginActivity;
import com.example.hp.currentprojectnearbyplaces.*;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.OnMapReadyCallback;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent fab_intent = new Intent(MainActivity.this, NearbyPlacesMap.class );
                startActivity(fab_intent);
            }
        });

        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab2);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fab1_intent = new Intent(MainActivity.this, NavigatetoCar.class);
                startActivity(fab1_intent);



            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng pune = new LatLng(18.5308, 73.8475);
        mMap.addMarker(new MarkerOptions().position(pune).title("Current Location"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pune,14));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_trip_analysis) {
            Toast.makeText(this, "Trip Analysis Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, FragmentMainActivity.class);
            startActivity(intent);

        }else if(id==R.id.nav_past_behavior){
            Toast.makeText(this, "Past Behavior Clicked", Toast.LENGTH_SHORT).show();
            Intent intent_past_behavior = new Intent(MainActivity.this, PastBehavior.class);
            startActivity(intent_past_behavior);
        }
        else if (id == R.id.nav_geo_fencing) {

            Toast.makeText(this,"Geo-Fencing Clicked",Toast.LENGTH_SHORT).show();
            Intent geo_fencing_Activity = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(geo_fencing_Activity);


        } else if (id == R.id.nav_account) {

        } else if (id == R.id.nav_driver_behavior) {
            Toast.makeText(this, "Driver Behavior Clicked", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(MainActivity.this, Activity_top_fragments.class);
            startActivity(intent1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
