package com.artis.virat.tildenmap;

import android.content.pm.PackageManager;
import android.location.Location;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MapsActivity extends FragmentActivity implements
        OnMapReadyCallback, ValueEventListener {

    private GoogleMap mMap;
    private GPS_Tracker gpsTracker;
    private Location mLocation;
    double latitude, longitude;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("Virat Singh");
    DatabaseReference myRef1 = FirebaseDatabase.getInstance().getReference().child("Naveen Saini");
    DatabaseReference myRef2 = FirebaseDatabase.getInstance().getReference().child("Raunak Trikha");
    DatabaseReference myRef3 = FirebaseDatabase.getInstance().getReference().child("Saransh Vyas");
    DatabaseReference myRef4 = FirebaseDatabase.getInstance().getReference().child("Hemu Singh");
    DatabaseReference myRef5 = FirebaseDatabase.getInstance().getReference().child("Avi Sharma");
    DatabaseReference myRef6 = FirebaseDatabase.getInstance().getReference().child("Harshav Kumar");

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        gpsTracker = new GPS_Tracker(getApplicationContext());
        mLocation = gpsTracker.getLocation();

        latitude = mLocation.getLatitude();
        longitude = mLocation.getLongitude();



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        myRef.child("id/lat").setValue(latitude);
        myRef.child("id/long").setValue(longitude);

        //myRef1.setValue(longitude);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

     myRef2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                double rlat = dataSnapshot.child("id/lat").getValue(double.class);
                double rlong = dataSnapshot.child("id/long").getValue(double.class);
                LatLng r = new LatLng(rlat, rlong);
                mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").snippet("Last seen at " + rlat+ "," + rlong).icon(BitmapDescriptorFactory.fromResource(R.mipmap.raunak)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(rlat,rlong),15));

                //mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                double rlat = dataSnapshot.child("id/lat").getValue(double.class);
                double rlong = dataSnapshot.child("id/long").getValue(double.class);
                LatLng r = new LatLng(rlat, rlong);
                mMap.addMarker(new MarkerOptions().position(r).title("Naveen Saini").snippet("Last seen at " + rlat + "," + rlong).icon(BitmapDescriptorFactory.fromResource(R.mipmap.naveen)));


                //mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                double rlat = dataSnapshot.child("id/lat").getValue(double.class);
                double rlong = dataSnapshot.child("id/long").getValue(double.class);
                LatLng r = new LatLng(rlat, rlong);
                mMap.addMarker(new MarkerOptions().position(r).title("Saransh Vyas").snippet("Last seen at " + rlat + "," + rlong).icon(BitmapDescriptorFactory.fromResource(R.mipmap.saransh)));


                //mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                double rlat = dataSnapshot.child("id/lat").getValue(double.class);
                double rlong = dataSnapshot.child("id/long").getValue(double.class);
                LatLng r = new LatLng(rlat, rlong);
                mMap.addMarker(new MarkerOptions().position(r).title("Hemendra Singh").snippet("Last seen at " + rlat + "," + rlong).icon(BitmapDescriptorFactory.fromResource(R.mipmap.hemu)));


                //mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef5.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                double rlat = dataSnapshot.child("id/lat").getValue(double.class);
                double rlong = dataSnapshot.child("id/long").getValue(double.class);
                float e = (float) rlat;
                float t = (float) rlong;
                LatLng r = new LatLng(rlat, rlong);
                mMap.addMarker(new MarkerOptions().position(r).title("Avi Sharma").snippet("Last seen at " + rlat + "," + rlong).icon(BitmapDescriptorFactory.fromResource(R.mipmap.avi)));


                //mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        myRef6.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                double rlat = dataSnapshot.child("id/lat").getValue(double.class);
                double rlong = dataSnapshot.child("id/long").getValue(double.class);
                float e = (float) rlat;
                float t = (float) rlong;
                LatLng r = new LatLng(rlat, rlong);
                mMap.addMarker(new MarkerOptions().position(r).title("Harshav Kumar").snippet("Last seen at " + rlat + "," + rlong).icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));


                //mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        LatLng sydney = new LatLng(latitude, longitude);
        /*LatLng n=new LatLng(28.369955, 75.584406);
        LatLng a=new LatLng(48.8584, 2.2945);
        LatLng h=new LatLng(28.369287, 75.59085);
        LatLng s=new LatLng(28.6353, 75.382);
        LatLng v=new LatLng(28.3696, 75.5626);
        LatLng r=new LatLng(28.368435,75.588725);*/
        mMap.addMarker(new MarkerOptions().position(sydney).title("Me").icon(BitmapDescriptorFactory.fromResource(R.mipmap.cl)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,longitude),15));
        //moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), zoom));
        /*mMap.addMarker(new MarkerOptions().position(n).title("Naveen Saini").snippet("Last seen at").icon(BitmapDescriptorFactory.fromResource(R.mipmap.hemu)));
        mMap.addMarker(new MarkerOptions().position(a).title("Avi Sharma").icon(BitmapDescriptorFactory.fromResource(R.mipmap.naveen)));
        mMap.addMarker(new MarkerOptions().position(h).title("Hemendra Singh").icon(BitmapDescriptorFactory.fromResource(R.mipmap.saransh)));
        mMap.addMarker(new MarkerOptions().position(s).title("Saransh Vyas").icon(BitmapDescriptorFactory.fromResource(R.mipmap.avi)));
        mMap.addMarker(new MarkerOptions().position(v).title("Harshav Kumar").icon(BitmapDescriptorFactory.fromResource(R.mipmap.harshavpin)));
        mMap.addMarker(new MarkerOptions().position(r).title("Raunak Trikha").icon(BitmapDescriptorFactory.fromResource(R.mipmap.raunak)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.368435,75.588725),15));*/


    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }


}

