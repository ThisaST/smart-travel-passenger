package com.uok.se.thisara.smart.smarttravelpassenger.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.uok.se.thisara.smart.smarttravelpassenger.BusLocationActivity;
import com.uok.se.thisara.smart.smarttravelpassenger.R;

public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public MarkerInfoWindowAdapter(Context context) {

        this.context = context.getApplicationContext();
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.map_marker_info_window, null);

        LatLng latLng = marker.getPosition();

        Button button = view.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, BusLocationActivity.class);
                context.getApplicationContext().startActivity(intent);
            }
        });
        return view;
    }
}
