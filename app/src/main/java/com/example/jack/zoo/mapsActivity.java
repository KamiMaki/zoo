package com.example.jack.zoo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        intent = this.getIntent();


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
        LatLng a = new LatLng(24.9953692,24.9951333);
        LatLng b = new LatLng(24.996650, 121.580523);
        LatLng c = new LatLng(24.997329, 121.583091);
        LatLng d = new LatLng(24.997597, 121.582034);
        LatLng e = new LatLng(24.998182, 121.582468);
        LatLng f = new LatLng(24.994570, 121.589930);
        LatLng g = new LatLng(24.992944, 121.590773);
        LatLng h = new LatLng(24.997923, 121.580458);
        LatLng i = new LatLng(24.998885, 121.582295);
        LatLng j = new LatLng(24.994722, 121.583016);
        LatLng k = new LatLng(24.995008, 121.585454);
        LatLng l = new LatLng(24.994663, 121.585767);
        LatLng m = new LatLng(24.9951333, 121.5880094);
        LatLng n = new LatLng(24.992773, 121.590272);
        LatLng o = new LatLng(24.995604, 121.589816);
        LatLng p = new LatLng(24.995394, 121.585483);

        mMap.addMarker(new MarkerOptions().position(a).title("高氏宗祠文史館"));
        mMap.addMarker(new MarkerOptions().position(b).title("昆蟲館"));
        mMap.addMarker(new MarkerOptions().position(c).title("大貓熊館"));
        mMap.addMarker(new MarkerOptions().position(d).title("教育中心"));
        mMap.addMarker(new MarkerOptions().position(e).title("無尾熊館"));
        mMap.addMarker(new MarkerOptions().position(f).title("兩棲爬蟲動物館"));
        mMap.addMarker(new MarkerOptions().position(g).title("企鵝館"));
        mMap.addMarker(new MarkerOptions().position(h).title("臺灣動物區"));
        mMap.addMarker(new MarkerOptions().position(i).title("兒童動物區"));
        mMap.addMarker(new MarkerOptions().position(j).title("亞洲熱帶雨林區"));
        mMap.addMarker(new MarkerOptions().position(k).title("沙漠動物區"));
        mMap.addMarker(new MarkerOptions().position(l).title("澳洲動物區"));
        mMap.addMarker(new MarkerOptions().position(m).title("非洲動物區"));
        mMap.addMarker(new MarkerOptions().position(n).title("溫帶動物區"));
        mMap.addMarker(new MarkerOptions().position(o).title("鳥園區"));
        mMap.addMarker(new MarkerOptions().position(p).title("酷Cool節能屋"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(l));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);
        mMap.animateCamera(zoom);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);


    }
}
