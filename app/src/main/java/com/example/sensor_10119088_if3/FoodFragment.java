package com.example.sensor_10119088_if3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//10119088 Laurentius Bryan Hermanto IF3
public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        SupportMapFragment mapFragment=(SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_maps);

        // check condition
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            mapFragment.getMapAsync(googleMap -> {
                //Lokasi 1
                LatLng lokasi1 = new LatLng(-6.906416777554799, 107.59519399484526);
                MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Cekeran Midun");
                //Lokasi 2
                LatLng lokasi2 = new LatLng(-6.906080241333885, 107.59452536315906);
                MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Nasi Goreng Super Pa Rowi");
                //Lokasi 3
                LatLng lokasi3 = new LatLng(-6.906350676523023, 107.59593521329516);
                MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Teabumi Tea House");
                //Lokasi 4
                LatLng lokasi4 = new LatLng(-6.9055606160726954, 107.59609469618186);
                MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Batagor Hanjuang Astina");
                //Lokasi 5
                LatLng lokasi5 = new LatLng(-6.906136117431744, 107.59720295971924);
                MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("McDonald's");

                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi3,17));
                googleMap.addMarker(options1);
                googleMap.addMarker(options2);
                googleMap.addMarker(options3);
                googleMap.addMarker(options4);
                googleMap.addMarker(options5);


            });
        }
        else {
            // When permission is not granted
            // Call method
            requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION }, 100);
        }
        // Return view
        return view;
    }

}