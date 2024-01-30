package com.example.resmodulatorserver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import Common.Common;
import ViewHolder.OrderDetailAdapter;

public class OrderDetail extends AppCompatActivity {
    TextView order_id,order_TableNo,order_phone,order_total,order_comment;
    String order_id_value="";
    RecyclerView lstFoods;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        order_id = (TextView)findViewById(R.id.order_id);
        order_TableNo = (TextView)findViewById(R.id.order_TableNo);
        order_phone = (TextView)findViewById(R.id.order_phone_number);
        order_total = (TextView)findViewById(R.id.order_total);
        order_comment = (TextView)findViewById(R.id.order_comment);

        lstFoods = (RecyclerView)findViewById(R.id.lstFoods);
        lstFoods.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstFoods.setLayoutManager(layoutManager);

        if(getIntent() != null)
            order_id_value = getIntent().getStringExtra("OrderId");

        //set value
        order_id.setText(order_id_value);
        order_TableNo.setText(Common.currentRequest.getTableNo());
        order_total.setText(Common.currentRequest.getTotal());
        order_phone.setText(Common.currentRequest.getPhone_number());
        order_comment.setText(Common.currentRequest.getComment());

        OrderDetailAdapter adapter = new OrderDetailAdapter(Common.currentRequest.getFoods());
        adapter.notifyDataSetChanged();
        lstFoods.setAdapter(adapter);



    }
}