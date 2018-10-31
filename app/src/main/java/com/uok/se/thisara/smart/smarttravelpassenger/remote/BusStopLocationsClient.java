package com.uok.se.thisara.smart.smarttravelpassenger.remote;

import com.uok.se.thisara.smart.smarttravelpassenger.entities.BusLocation;
import com.uok.se.thisara.smart.smarttravelpassenger.entities.PinnedLocations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BusStopLocationsClient {

    @GET("api/busroute/1/pinpoints")
    Call<List<BusLocation>> getPinnedLocations();
}
