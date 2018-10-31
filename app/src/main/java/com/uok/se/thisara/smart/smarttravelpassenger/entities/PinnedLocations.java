package com.uok.se.thisara.smart.smarttravelpassenger.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PinnedLocations {

    @SerializedName("location_list")
    private ArrayList<BusLocation> pinnedLocations;

    public ArrayList<BusLocation> getLocationArrayList() {
        return pinnedLocations;
    }

    public void setLocationArrayList(ArrayList<BusLocation> locationArrayList) {
        this.pinnedLocations = locationArrayList;
    }
}
