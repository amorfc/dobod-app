package com.example.tellee.Activity.OrdersHistory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.tellee.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tellee.Models.Order;

import java.util.ArrayList;
import java.util.Calendar;

public class OrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public ArrayList orders=null;
    private Context mcontext;
    public  OrderAdapter(Context context, ArrayList<Order> mList){
            this.mcontext=context;
            this.orders = mList;
    }
    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView  name,totalcheck,date,cuba_count,turkish_count,romeo_count,monte_count,maca_count;
        ImageButton share_btn;
        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.vendor_name);
            totalcheck=(TextView)itemView.findViewById(R.id.totalcheck_count);
            date=(TextView)itemView.findViewById(R.id.visit_date);
            cuba_count=(TextView)itemView.findViewById(R.id.cubas_count);
            turkish_count=(TextView)itemView.findViewById(R.id.turkish_count);
            romeo_count=(TextView)itemView.findViewById(R.id.romeo_count);
            monte_count=(TextView)itemView.findViewById(R.id.monte_count);
            maca_count=(TextView)itemView.findViewById(R.id.maca_count);
            share_btn=(ImageButton)itemView.findViewById(R.id.imageButton);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemView = layoutInflater.inflate(R.layout.orders_history_item,parent,false);
        RecyclerView.ViewHolder viewHolder= new OrderViewHolder(itemView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
        Order current_order = (Order) orders.get(position);

        OrderViewHolder order_holder = (OrderViewHolder) holder;
        Calendar currentCalender = Calendar.getInstance();

        order_holder.date.setText(current_order.getDate());
        order_holder.name.setText(current_order.getC_name());
        order_holder.totalcheck.setText(current_order.getTotalCheck().toString()+" tl");
        order_holder.cuba_count.setText(current_order.getCuba_count().toString()+"x100 = "+current_order.getCuba_count()*100+" tl");
        order_holder.turkish_count.setText(current_order.getTurkish_count().toString()+"x200 = "+current_order.getTurkish_count()*200+" tl");
        order_holder.romeo_count.setText(current_order.getRomeo_count().toString()+"x125 = "+current_order.getRomeo_count()*125+" tl");
        order_holder.monte_count.setText(current_order.getMonte_count().toString()+"x275 = "+current_order.getMonte_count()*275+" tl");
        order_holder.maca_count.setText(current_order.getMaca_count().toString()+"x75 = "+current_order.getMaca_count()*75+" tl");
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
