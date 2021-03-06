package com.uok.se.thisara.smart.smarttravelpassenger.entities;

import com.google.gson.annotations.SerializedName;

public class BusLocation {

    @SerializedName("id")
    private Long id;

    @SerializedName("name")
    private String locationName;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    @SerializedName("route_id")
    private Long route_id;

    public BusLocation() {
    }


    public BusLocation(String locationName, String latitude, String longitude) {
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    /*public BusLocation(Long id, String locationName, double latitude, double longitude, Long route_id) {
        this.id = id;
        this.locationName = locationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.route_id = route_id;
    }*/

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRouteId() {
        return route_id;
    }

    public void setRouteId(Long route_id) {
        this.route_id = route_id;
    }
}
