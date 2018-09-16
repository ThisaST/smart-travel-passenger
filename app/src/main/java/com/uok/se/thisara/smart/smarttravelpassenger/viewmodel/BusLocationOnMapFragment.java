package com.uok.se.thisara.smart.smarttravelpassenger.viewmodel;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uok.se.thisara.smart.smarttravelpassenger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusLocationOnMapFragment extends Fragment {


    public BusLocationOnMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bus_location_on_map, container, false);
    }

}
