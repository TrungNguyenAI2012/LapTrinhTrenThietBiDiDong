package com.nguyenthanhphong.aquariumshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nguyenthanhphong.aquariumshop.Adapters.OrdersAdapter;
import com.nguyenthanhphong.aquariumshop.Models.OrdersModel;
import com.nguyenthanhphong.aquariumshop.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btn_login = findViewById(R.id.back_login);
        final DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list = helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.ordersRecycleView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecycleView.setLayoutManager(layoutManager);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}