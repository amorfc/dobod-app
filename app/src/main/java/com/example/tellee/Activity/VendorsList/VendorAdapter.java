package com.example.tellee.Activity.VendorsList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tellee.Activity.VendorsDetails.VendorsDetails;
import com.example.tellee.Models.CreateAllData;
import com.example.tellee.R;

import com.example.tellee.Models.Vendor;

import java.util.ArrayList;

public class VendorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private  Context context;
    public  ArrayList vendorList = null;


    public VendorAdapter(Context mContext, ArrayList<Vendor> mDataset){
        this.context = mContext;
        this.vendorList = mDataset;
    }
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public ImageView imgUrl;
        public TextView headerTxt;
        public TextView adress;
        public ConstraintLayout layout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTxt = (TextView) itemView.findViewById(R.id.vendor_name);
            imgUrl = (ImageView) itemView.findViewById(R.id.vendor_logo);
            date = (TextView) itemView.findViewById(R.id.visit_date);
            adress = (TextView) itemView.findViewById(R.id.adress_text_view);
            layout = (ConstraintLayout) itemView.findViewById(R.id.orders_item);
        }
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View listItem = layoutInflater.inflate(R.layout.vendors_item, parent, false);
        RecyclerView.ViewHolder viewHolder = new ItemViewHolder(listItem);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Vendor realvendor =(Vendor) vendorList.get(position);
        ItemViewHolder vendor_holder = (ItemViewHolder) holder;

        vendor_holder.date.setText(realvendor.getVisit_date());
        vendor_holder.adress.setText(realvendor.getAdress());
        vendor_holder.headerTxt.setText(realvendor.getName());
        Glide.with(context)
                .load(realvendor.getImgUrl())
                .into(vendor_holder.imgUrl);

        vendor_holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(v.getContext(), VendorsDetails.class);
                intent.putExtra("Vendor",realvendor );
                v.getContext().startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
         return vendorList.size();
    }


}
