package com.uok.se.thisara.smart.smarttravelpassenger;

import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

public class PlacesApiHandler implements PlaceSelectionListener {

    private static final String TAG = "Test";

    @Override
    public void onPlaceSelected(Place place) {

        Log.i(TAG, "Place Selected: " + place.getName());
    }

    @Override
    public void onError(Status status) {

    }
}
