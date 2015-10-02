package com.joanmungai.droidlab.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    //declaring google map
    private GoogleMap googleMap;
    private MarkerOptions markerOptions;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialising  Maps

        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment)).getMap();

        markerOptions = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Nairobi");

        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.powered_by_google_light));


        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                new LatLng(17.385044, 78.486671)).zoom(12).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        googleMap.setMyLocationEnabled(true);

        //Enabling zooming gestures but by default is true
        googleMap.getUiSettings().setZoomGesturesEnabled(false);


        googleMap.getUiSettings().setCompassEnabled(true);

        googleMap.addMarker(markerOptions);

        //Button

    }
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.MapNormal:
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;

        }
    }

}






