package com.example.tellee.Activity.VendorsList;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tellee.Activity.BaseAcitivity;
import com.example.tellee.Models.CreateAllData;
import com.example.tellee.R;

public class VendorsList extends BaseAcitivity {
    RecyclerView vendorRc;
    VendorAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendors_list);
        setTitle("Vendors");
        getVeriables();
    }

    public void getVeriables(){
        final Context context = this;
        vendorRc = (RecyclerView) findViewById(R.id.vendors_list_rcy);
        mAdapter = new VendorAdapter(context, CreateAllData.vendorList);
        mLayoutManager = new LinearLayoutManager(context);
        vendorRc.setAdapter(mAdapter);
        vendorRc.setLayoutManager(mLayoutManager);
    }

}