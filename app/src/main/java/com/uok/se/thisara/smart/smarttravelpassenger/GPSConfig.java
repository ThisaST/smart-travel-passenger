package com.uok.se.thisara.smart.smarttravelpassenger;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import static android.content.Context.LOCATION_SERVICE;


public class GPSConfig {

    private static final int PERMISSIONS_REQUEST = 1;

    public static boolean isGPSEnabled(Context context) {

        boolean isEnabled = false;
        // Check GPS is enabled
        LocationManager lm = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            isEnabled = false;
        }else {
            isEnabled = true;
        }

        return isEnabled;
    }
}

