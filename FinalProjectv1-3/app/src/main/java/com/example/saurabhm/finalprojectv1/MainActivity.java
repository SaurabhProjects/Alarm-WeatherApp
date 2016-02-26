package com.example.saurabhm.finalprojectv1;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
// Provides the list of the alarm clock and the menus to set alarm and receive weather
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static int GET_NAME_REQUEST = 65535;
    public static String PACKAGE_NAME;

    private String time, description;
    Context context = MainActivity.this;

    ArrayList<String> days ;
    List<String> time1 = new ArrayList<String>();

    List<String> description1 = new ArrayList<String>();
    List<String> days1 = new ArrayList<String>();

    List<Alarm> rowItems;
    ListView mylistview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PACKAGE_NAME = getApplicationContext().getPackageName();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }
    private ArrayList<Alarm> getAlarm(){
        ArrayList<Alarm> alarms= new ArrayList<Alarm>();
        for (int i =0; i<time1.size();i++){
            alarms.add(new Alarm (time1.get(i),description1.get(i),days1.get(i)));
        }
        return alarms;
    }
    @Override
    protected void onResume (){
        //run this method on the finish of second activity and update the database
        super.onResume();
        mylistview=(ListView) findViewById(R.id.alarmListView);
        AlarmAdapter adapter =new AlarmAdapter (this,getAlarm());
        mylistview.setAdapter(adapter);

    }
    private void getDataInList() {
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
            Intent intent = new Intent (this,AlarmClock.class);
            startActivityForResult(intent, GET_NAME_REQUEST);
        }else if(id == R.id.action_settings2){
            Intent intent = new Intent (this,WeatherGPS.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int responseCode, Intent resultIntent) {
        super.onActivityResult(requestCode, responseCode, resultIntent);

        if (responseCode == RESULT_OK) {
            time1.add(resultIntent.getStringExtra("time"));
            description1.add(resultIntent.getStringExtra("description"));
            days1.add(resultIntent.getStringArrayListExtra("days").toString());
        }
    }
}
