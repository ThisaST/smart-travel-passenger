package com.uok.se.thisara.smart.smarttravelpassenger.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    List<BusLocation> routeLocation = new ArrayList<>();

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

                }
            });
        }catch (Exception e) {
            Log.e("error", e.toString());
        }



        DatabaseReference firebaseDatabaseReference = FirebaseDatabase.getInstance().getReference(path);

        /*firebaseDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //routeLocation = (ArrayList<LatLng>) dataSnapshot.getValue();
                *//**//*Map<String, Object> objectMap = (HashMap<String, Object>)dataSnapshot.getValue();
                for (Object obj : objectMap.values()) {
                    if (obj instanceof Map) {
                        Map<String, Object> mapObj = (Map<String, Object>) obj;
                        LatLng locations = new LatLng(Double.valueOf(((Map<String, Object>) obj).get("latitude").toString()),
                                Double.valueOf(((Map<String, Object>) obj).get("latitude").toString()));
                        routeLocation.add(locations);
                    }
                }*//**//*

                *//**//*for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Map<String, String> map = (Map) postSnapshot.getValue();
                    if (map != null) {
                        double latitude = Double.parseDouble(map.get("latitude"));
                        double longitude = Double.parseDouble(map.get("longitude"));

                        routeLocation.add(new Location().setLatitude());
                    }
                }*//*
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }

    public void getPinnedLocationData(Response<List<BusLocation>> locationsResponse, Call<List<BusLocation>> call) {

        Log.d("executed", Boolean.toString(call.isExecuted()));
        routeLocation = locationsResponse.body();

    }

    public List<BusLocation> getPinPointLocationData() {

        return routeLocation;
    }


}
