package com.example.tellee.Activity.OrdersHistory;



import android.content.Context;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tellee.Activity.BaseAcitivity;
import com.example.tellee.Activity.LoginActivity.LoginAcivity;
import com.example.tellee.Models.Order;
import com.example.tellee.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrdersHistory extends BaseAcitivity {

    RecyclerView orderRc;
    OrderAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    String userid;
    ArrayList<Order> orderslistLocal = new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_history);
        setTitle("Orders History");
        initVeriables();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

        getHistory();
            }
        },1000);




    }

    public void getHistory(){
        final Context context = this;
        orderRc = findViewById(R.id.orders_history_rcy);
        mAdapter = new OrderAdapter(context, orderslistLocal);
        mLayoutManager = new LinearLayoutManager(context);
        orderRc.setAdapter(mAdapter);
        orderRc.setLayoutManager(mLayoutManager);
    }
    public void initVeriables(){
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                    userid =sharedPreferences.getString("user_id","def");

                    CollectionReference mStatsDocRef = FirebaseFirestore.getInstance().collection(LoginAcivity.user_id);

                    mStatsDocRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {

                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            List<DocumentSnapshot> orderlistDocuments = queryDocumentSnapshots.getDocuments();
                            ArrayList<Order> tempArr = new ArrayList<Order>();
                            for (int i = 0; i < orderlistDocuments.size(); i++) {
                                DocumentSnapshot currentSnap = orderlistDocuments.get(i);
                                Map<String, Object> currentObject = (Map<String, Object>) currentSnap.get("order");
                                Order baba = convertHashmapToOrder(currentObject);
                                tempArr.add(baba);
                    /*if (((Order) currentSnap.get("order")) != null){
                        Order currentOrder = (Order) currentSnap.get("order");
                        ordersList.add(currentOrder);
                    }*/
                }
                orderslistLocal = tempArr;

            }
        });

    }
    private void doTheThingAfterTheListInit(){
        Toast.makeText(this, "" + orderslistLocal.size(), Toast.LENGTH_LONG).show();
    }
    private Order convertHashmapToOrder(Map<String, Object> hashMap){
        String date = (String) hashMap.get("date");

        int totalCheck = ((Long) hashMap.get("totalCheck")).intValue();
        int cuba_count = ((Long) hashMap.get("cuba_count")).intValue();
        int maca_count = ((Long) hashMap.get("maca_count")).intValue();
        double latitude = (double) hashMap.get("latitude");
        //;
        double longtitude = (double) hashMap.get("longtitude");
        //;
        int turkish_count = ((Long) hashMap.get("turkish_count")).intValue();
        String  c_name = (String) hashMap.get("c_name");
        int romeo_count = ((Long) hashMap.get("romeo_count")).intValue();
        int monte_count = ((Long) hashMap.get("monte_count")).intValue();


        return new Order(date, totalCheck, cuba_count, maca_count, latitude,
                longtitude,turkish_count, c_name,romeo_count,monte_count);

    }

}
