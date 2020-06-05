package com.example.tellee.Activity.Shopping;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.tellee.Activity.BaseAcitivity;
import com.example.tellee.Activity.ProductDetails.ProductDetails;
import com.example.tellee.Activity.TwoWayActivity.TwoWayActivity;
import com.example.tellee.Models.CreateAllData;
import com.example.tellee.Models.Order;
import com.example.tellee.Models.Product;
import com.example.tellee.Models.Vendor;
import com.example.tellee.R;

import java.util.Calendar;

public class ShoppingActivity extends BaseAcitivity implements View.OnClickListener {

    Button cubaButton,turkishButton,RomeojButton,macanudoButton,monteButton;
    EditText cubaET,turkishET,romeoJET,monteCristoET,macadunoET;
    TextView totalCheck, discountCheck;
    Integer Total, TotalIndirim,vendorCredit,toplamCuba,
            toplamturkish,
            toplamRomeo,
            toplamMonte,
            toplamMaca;
    public Integer indirim;
    Button calcbtn,button;
    Vendor vendor1;
    AlertDialog.Builder builder;
    String id_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        setTitle("Take Order");
        variables();
        initListeners();
    }
    public void variables(){

        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        id_user =(String) sharedPreferences.getString("user_id","def");

        Intent intent=getIntent();
        vendor1 = (Vendor) intent.getSerializableExtra("Vendor1");
        assert vendor1 != null;
        indirim=(Integer) vendor1.getDicount();
        vendorCredit= vendor1.getCredit();


        builder =new AlertDialog.Builder(this);
        cubaButton=(Button)findViewById(R.id.cubas_details_btn);
        turkishButton=(Button)findViewById(R.id.turkish_details_btn);
        monteButton=(Button)findViewById(R.id.monte_details_btn);
        RomeojButton=(Button)findViewById(R.id.rome_details_btn);
        macanudoButton=(Button)findViewById(R.id.maca_details_btn);
        cubaET=(EditText)findViewById(R.id.ShopingLayCubaEditText);
        turkishET=(EditText)findViewById(R.id.ShopingLayTurkishEditText);
        romeoJET=(EditText)findViewById(R.id.ShopingLayRomeoEditText);
        monteCristoET = (EditText) findViewById(R.id.ShopingLaymMonteEditText);
        macadunoET = (EditText) findViewById(R.id.ShopingLayMacanudoBirim);
        totalCheck=(TextView)findViewById(R.id.toplamtutar_text_view6);
        discountCheck =(TextView)findViewById(R.id.toplamtutar_text_view7);
        calcbtn = (Button) findViewById(R.id.calculatebutton);
        button=(Button)findViewById(R.id.takeorder);


    }
    public Integer CalculateTotal(){

        toplamCuba= Integer.parseInt(cubaET.getText().toString());
        toplamturkish=Integer.parseInt(turkishET.getText().toString());
        toplamRomeo=Integer.parseInt(romeoJET.getText().toString());
        toplamMonte=Integer.parseInt(monteCristoET.getText().toString());
        toplamMaca=Integer.parseInt(macadunoET.getText().toString()) ;

        return toplamCuba*100+toplamturkish*200+toplamRomeo*125+toplamMonte*275+toplamMaca*75;
    }
    public void initListeners(){

        calcbtn.setOnClickListener(this);
        button.setOnClickListener(this);
        cubaButton.setOnClickListener(this);
        turkishButton.setOnClickListener(this);
        RomeojButton.setOnClickListener(this);
        monteButton.setOnClickListener(this);
        macanudoButton.setOnClickListener(this);
    }



    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.calculatebutton:
                Total = CalculateTotal();
                TotalIndirim = Total-((Total/100)*indirim);
                totalCheck.setText(Total.toString());
                discountCheck.setText(TotalIndirim.toString());
                if(Total >0){button.setEnabled(true);}else{button.setEnabled(false);}
                break;
            case R.id.takeorder:
                if(Total <= vendorCredit){
                    acceptAlert();
                }else{
                    deniedAlert(TotalIndirim);
                }
                break;
            case R.id.cubas_details_btn:
                sendToIntent(cuba);
                break;
            case R.id.turkish_details_btn:
                sendToIntent(turkish);
                break;
            case R.id.rome_details_btn:
                sendToIntent(romeo);
                break;
            case R.id.monte_details_btn:
                sendToIntent(monte);
                break;
            case R.id.maca_details_btn:
                sendToIntent(maca);
                break;

        }
    }

    public void acceptAlert(){


        builder.setMessage("Credit is well enough.Press Okey to take Order")
                .setCancelable(false)
                .setPositiveButton("Okey", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //burda Intent gönderme yapılacak
                        Calendar currentCalender = Calendar.getInstance();
                        Order order = new Order(currentCalender.getTime().toString(),TotalIndirim,toplamCuba,toplamMaca,vendor1.getLattitude(),
                                vendor1.getLongitude(),toplamturkish,
                                vendor1.getName(),toplamRomeo,toplamMonte);
                        writeOrders(id_user,order);
                        Intent intent = new Intent(ShoppingActivity.this, TwoWayActivity.class);
                        startActivity(intent);
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Approved!!!");
        alert.show();

    }
    public void deniedAlert(Integer total){


        builder.setMessage("Credit is not enough")
                .setCancelable(true)
                .setNegativeButton("Try Again!!!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Denied!!!");
        alert.show();

    }
    public  void sendToIntent(Product product){
        Intent intent = new Intent(ShoppingActivity.this, ProductDetails.class);
        intent.putExtra("product",product);
        intent.putExtra("vendor1",vendor1);
        startActivity(intent);
    }
}

