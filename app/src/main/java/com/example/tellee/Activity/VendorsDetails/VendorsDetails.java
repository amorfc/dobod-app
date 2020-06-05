package com.example.tellee.Activity.VendorsDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tellee.Activity.BaseAcitivity;
import com.example.tellee.Activity.Shopping.ShoppingActivity;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tellee.Models.Vendor;
import com.example.tellee.R;

import java.util.Map;

public class VendorsDetails extends BaseAcitivity implements OnMapReadyCallback,View.OnClickListener {

     public Vendor vendor;
    TextView name;
    TextView compony_name;
    TextView date;
    TextView credit;
    TextView discount;
    TextView adress;
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendors_details);
        setTitle("Details");
        getVeriables();
        initListeners();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }
    public void initListeners(){
        btn.setOnClickListener(this);
    }
    public void getVeriables(){

        Intent intent = getIntent();
        vendor = (Vendor) intent.getSerializableExtra("Vendor");
        name = (TextView) findViewById(R.id.MarketInfoLayMarketName);
        name.setText(vendor.getName());

        compony_name = (TextView) findViewById(R.id.textView4);
        compony_name.setText(vendor.getCompany_name());

        credit = (TextView) findViewById(R.id.MarketInfoKrediTextView);
        credit.setText(vendor.getCredit().toString()+" tl");

        date = (TextView) findViewById(R.id.DeliveryDayTextView);
        date.setText(vendor.getVisit_date());

        discount = (TextView) findViewById(R.id.MarketinfoSaleTextView);
        discount.setText("%"+vendor.getDicount().toString());

        adress = (TextView) findViewById(R.id.MarketInfoAdresTextView);
        adress.setText(vendor.getAdress());

        btn = (ImageButton) findViewById(R.id.MarketinfoLayOrderButton);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng vendorLocation = new LatLng(vendor.getLattitude(), vendor.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(vendorLocation).title(vendor.getName()));
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(vendorLocation, 18.0f, 50.0f, 45.0f)));

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.MarketinfoLayOrderButton:
                Intent intent = new Intent(v.getContext(),ShoppingActivity.class);
                intent.putExtra("Vendor1",vendor);
                v.getContext().startActivity(intent);
                break;
        }

    }
}

/*



        googleMap.setLatLngBoundsForCameraTarget(new LatLngBounds(
                new LatLng(vendor.getLattitude() + 3.0, vendor.getLongitude()  + 3.0),
                new LatLng(vendor.getLattitude() - 3.0,vendor.getLongitude() - 3.0)
        ));

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                new LatLng(vendor.getLattitude(),vendor.getLongitude()), 15.0f, 0.0f, 0.0f

        )));




    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle mapViewBundle = (Bundle) outState.getBundle(getString(R.string.api));
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(getString(R.string.api), mapViewBundle);
        }

        mapView.onSaveInstanceState(mapViewBundle);
    }



    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }
    @Override
    protected void  onStop() {
        super.onStop();
        mapView.onStop();
    }
    @Override
    public void onMapReady(GoogleMap map) {



        map.addMarker(new MarkerOptions()
                .position(new LatLng(vendor.getLattitude(),vendor.getLongitude()))
                .title("Location"));
        map.setLatLngBoundsForCameraTarget(new LatLngBounds(
                new LatLng(vendor.getLattitude(), vendor.getLongitude()),

        new LatLng(vendor.getLattitude(), vendor.getLongitude())
        ));

        map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(
                new LatLng(vendor.getLattitude(),vendor.getLongitude()), 15.0f, 0.0f, 0.0f

        )));
    }
    @Override
    protected void onPause() {
        mapView.onPause();
        super.onPause();
    }
    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }



 */