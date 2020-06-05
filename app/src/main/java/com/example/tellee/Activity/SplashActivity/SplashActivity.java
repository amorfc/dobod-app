package com.example.tellee.Activity.SplashActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.tellee.Activity.BaseAcitivity;


import com.example.tellee.Activity.LoginActivity.LoginAcivity;
import com.example.tellee.Activity.Shopping.ShoppingActivity;
import com.example.tellee.Activity.VendorsList.VendorsList;
import com.example.tellee.Models.CreateAllData;
import com.example.tellee.R;

public class SplashActivity extends BaseAcitivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        CreateAllData.initVendorArray();
        CreateAllData.initUsersArray();
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, LoginAcivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
