package com.lokiiichauhan.mymaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lokiiichauhan.mymaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    //created Mountaines

    private LatLng mountEverest = new LatLng(28.003177, 86.928129);
    private LatLng mountKillManjaro = new LatLng(-3.075558, 37.344363);
    private LatLng theAlps = new LatLng(47.368955, 9.702579);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng hisar = new LatLng(29.1492, 75.7217);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.addMarker(new MarkerOptions().position(hisar).title("Marker in Hisar").icon(BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).alpha(0.8f));

        mMap.addMarker(new MarkerOptions().position(mountEverest).title("Mount Everest"));
        mMap.addMarker(new MarkerOptions().position(mountKillManjaro).title("Mount KillMounger"));
        mMap.addMarker(new MarkerOptions().position(theAlps).title("Alps"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(theAlps, 15)); //1 - 20


    }
}