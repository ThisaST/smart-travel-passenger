package com.uok.se.thisara.smart.smarttravelpassenger.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainViewModel extends ViewModel {

    List<LatLng> routeLocation = new ArrayList<>();

    public List<LatLng> getDataFromFirebase(String path) {


        DatabaseReference firebaseDatabaseReference = FirebaseDatabase.getInstance().getReference(path);

        firebaseDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                routeLocation = (ArrayList<LatLng>) dataSnapshot.getValue();
                /*Map<String, Object> objectMap = (HashMap<String, Object>)dataSnapshot.getValue();
                for (Object obj : objectMap.values()) {
                    if (obj instanceof Map) {
                        Map<String, Object> mapObj = (Map<String, Object>) obj;
                        LatLng locations = new LatLng(Double.valueOf(((Map<String, Object>) obj).get("latitude").toString()),
                                Double.valueOf(((Map<String, Object>) obj).get("latitude").toString()));
                        routeLocation.add(locations);
                    }
                }*/

                /*for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Map<String, String> map = (Map) postSnapshot.getValue();
                    if (map != null) {
                        double latitude = Double.parseDouble(map.get("latitude"));
                        double longitude = Double.parseDouble(map.get("longitude"));

                        routeLocation.add(new Location().setLatitude());
                    }
                }*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return routeLocation;
    }

    /*public List<LatLng> getDataFromService() {


    }*/

}
