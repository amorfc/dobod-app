package com.example.tellee.Activity.TwoWayActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tellee.Activity.BaseAcitivity;
import com.example.tellee.Activity.LoginActivity.LoginAcivity;
import com.example.tellee.Activity.OrdersHistory.OrdersHistory;
import com.example.tellee.Activity.SplashActivity.SplashActivity;
import com.example.tellee.Activity.VendorsList.VendorsList;
import com.example.tellee.R;

public class TwoWayActivity extends BaseAcitivity {
    Button logoutbtn ;
    ConstraintLayout takeOrder;
    ConstraintLayout ordersH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_way);

        logoutbtn = (Button) findViewById(R.id.OrderLayoutExitBottom);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoWayActivity.this, LoginAcivity.class);
                startActivity(intent);
            }
        });
        takeOrder = (ConstraintLayout) findViewById(R.id.NewOrder_layout);
        takeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoWayActivity.this, VendorsList.class);
                startActivity(intent);
            }
        });
        ordersH = (ConstraintLayout) findViewById(R.id.Orders_layout);
        ordersH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoWayActivity.this, OrdersHistory.class);
                startActivity(intent);
            }
        });
    }
}
