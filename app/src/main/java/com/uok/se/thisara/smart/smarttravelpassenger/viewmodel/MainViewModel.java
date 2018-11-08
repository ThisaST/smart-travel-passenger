package com.uok.se.thisara.smart.smarttravelpassenger.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.location.Location;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.uok.se.thisara.smart.smarttravelpassenger.MainActivity;
import com.uok.se.thisara.smart.smarttravelpassenger.entities.BusLocation;
import com.uok.se.thisara.smart.smarttravelpassenger.entities.PinnedLocations;
import com.uok.se.thisara.smart.smarttravelpassenger.remote.BusStopLocationsClient;
import com.uok.se.thisara.smart.smarttravelpassenger.remote.RemoteConfig;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    List<BusLocation> routeLocation = new ArrayList<>();
    List<LatLng> busRouteLocations = new ArrayList<>();

    public void getDataFromSerivce(String path) {

        BusStopLocationsClient locationData = RemoteConfig.getLocationDataClient();

        Call<List<BusLocation>> locationsCall = locationData.getPinnedLocations();

        Log.d("Url", locationsCall.request().url().toString());

        try {
            locationsCall.enqueue(new Callback<List<BusLocation>>() {
                @Override
                public void onResponse(Call<List<BusLocation>> call, Response<List<BusLocation>> response) {
                    getPinnedLocationData(response, call);
                }

                @Override
                public void onFailure(Call<List<BusLocation>> call, Throwable t) {

                    Log.e("retrofit error", t.toString());
                }
            });
        }catch (Exception e) {
            Log.e("error", e.toString());
        }

    }

    public void getPinnedLocationData(Response<List<BusLocation>> locationsResponse, Call<List<BusLocation>> call) {

        Log.d("executed", Boolean.toString(call.isExecuted()));
        routeLocation = locationsResponse.body();

    }

    public List<BusLocation> getPinPointLocationData() {

        return routeLocation;
    }


    public void getDataFromFirebase(String dbPath) {

        DatabaseReference firebaseDatabaseReference = FirebaseDatabase.getInstance().getReference(dbPath);

        firebaseDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                setBusRouteLocations(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setBusRouteLocations(DataSnapshot dataSnapshot) {

        List<BusLocation> busLocationList = new ArrayList<>();
        for (DataSnapshot locationData : dataSnapshot.getChildren()) {

            BusLocation busLocation = locationData.getValue(BusLocation.class);
            busLocationList.add(busLocation);
        }

        sendDataToTheView(busLocationList);
    }

    private void sendDataToTheView(List<BusLocation> busLocationList) {

        routeLocation = busLocationList;
    }

    public List<BusLocation> getRouteLocation() {

        return routeLocation;
    }
}
