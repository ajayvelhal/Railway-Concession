package com.example.ajay.concession.Activity;

import android.os.Bundle;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ajay.concession.Fragments.Update;
import com.example.ajay.concession.Fragments.ViewStatus;
import com.example.ajay.concession.R;
import com.example.ajay.concession.utils.SharedPreference;
import com.example.ajay.concession.Fragments.ApplyConcession;
import com.example.ajay.concession.Fragments.CancelConcession;
import com.example.ajay.concession.Fragments.Feedback;
import com.example.ajay.concession.Fragments.Logout;

public class MainPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View navHeader = navigationView.getHeaderView(0);

        SharedPreference pref = new SharedPreference(this);
        TextView lbl = (TextView) navHeader.findViewById(R.id.lbl);
        lbl.setText(pref.getName());
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
        getMenuInflater().inflate(R.menu.main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    private void displaySelected(int id){
        android.support.v4.app.Fragment fragment=null;

        switch (id){
            case R.id.nav_update:
                fragment = new Update();
                break;
            case R.id.nav_apply:
                fragment = new ApplyConcession();
                break;
            case  R.id.nav_cancel:
                fragment = new CancelConcession();
                break;
            case R.id.nav_view:
                fragment = new ViewStatus();
                break;
            case R.id.nav_feedback:
                fragment = new Feedback();
                break;
            case R.id.nav_logout:
                fragment = new Logout();
                break;
        }

        if (fragment!=null){
            android.support.v4.app.FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_main,fragment);
            fragmentTransaction.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override


    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        displaySelected(id);



        return true;
    }
}
