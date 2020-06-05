package com.example.tellee.Activity.ProductDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tellee.Activity.BaseAcitivity;
import com.example.tellee.Activity.LoginActivity.LoginAcivity;
import com.example.tellee.Activity.Shopping.ShoppingActivity;
import com.example.tellee.Activity.TwoWayActivity.TwoWayActivity;
import com.example.tellee.Models.Product;
import com.example.tellee.Models.Vendor;
import com.example.tellee.R;

import java.util.Objects;

public class ProductDetails extends BaseAcitivity  {
    Product product1;
    TextView productName, productDetails, productFiyat;
    ImageView productImg;
    Button geriBotton;
    Vendor vendor1;
    public String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        initProducts();
        setScreen();
        setTitle(title);
        geriBotton=(Button)findViewById(R.id.geriButton);
        geriBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    public void setScreen(){
        Intent intent = getIntent();
        product1=(Product)intent.getSerializableExtra("product");
        vendor1=(Vendor)intent.getSerializableExtra("vendor1");
        title=product1.getP_name();

        productName=(TextView)findViewById(R.id.HeaderTextvİew);
        productName.setText(product1.getP_name());

        productDetails=(TextView)findViewById(R.id.urunAcıklamaView);
        productDetails.setText(product1.getDesc());

        productFiyat=(TextView)findViewById(R.id.FiyatTextView);
        productFiyat.setText(product1.getPrice());

        productImg=(ImageView)findViewById(R.id.imageView14);
        Glide.with(getBaseContext()).load(product1.getImg_Url()).into(productImg);

    }
}


