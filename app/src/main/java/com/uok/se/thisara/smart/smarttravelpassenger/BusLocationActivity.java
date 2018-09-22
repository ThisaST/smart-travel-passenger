package com.uok.se.thisara.smart.smarttravelpassenger;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.uok.se.thisara.smart.smarttravelpassenger.ui.BusLocationOnMapFragment;

public class BusLocationActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment bottomNavigationViewFragments = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    bottomNavigationViewFragments = new BusLocationOnMapFragment();
                    loadFragment(bottomNavigationViewFragments);
                    return true;

                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;

                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_location);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new BusLocationOnMapFragment());
    }

    /**
     * Sets up the fragment in the bottom navigation.
     * @param fragment The loading Fragment in the view.
     * @return Boolean.
     */
    private boolean loadFragment(Fragment fragment) {
        //switching fragment

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
