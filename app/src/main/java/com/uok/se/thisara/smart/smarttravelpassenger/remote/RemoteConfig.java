package com.uok.se.thisara.smart.smarttravelpassenger.remote;

public class RemoteConfig {

    public static final String baseUrl = "http://192.168.8.101:9090";

    public static BusStopLocationsClient getLocationDataClient() {
        return RetrofitClient.getRetrofitClient(baseUrl).create(BusStopLocationsClient.class);
    }
}
