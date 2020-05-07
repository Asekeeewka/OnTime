package com.example.ontime;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MealOrderActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView1;
    private MealOrderAdapter mAdapter;
    private MealOrderAdapter mAdapter1;

    private RecyclerView.LayoutManager mLayoutManager;
    private TextView zakazat;
    private ArrayList<MealItem> toPay = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_order);
        final ArrayList<MealItem> mealList = new ArrayList<>();
        mealList.add(new MealItem(R.drawable.bg5, "Пицца Пепперони", 400));
        mealList.add(new MealItem(R.drawable.bg5, "Бургер Халапеньо", 1300));


        mRecyclerView = findViewById(R.id.fast_food_rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView1 = findViewById(R.id.salats_rv);
        mRecyclerView1.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MealOrderAdapter(mealList);
        mAdapter1 = new MealOrderAdapter(mealList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView1.setAdapter(mAdapter1);

        mAdapter.setOnItemClickListener(new MealOrderAdapter.OnItemClickListener() {
            @Override
            public void onPlusClick(MealItem mealItem) {
                toPay.add(mealItem);
                setButton();
            }

            @Override
            public void onMinusClick(MealItem mealItem) {
                toPay.remove(mealItem);
                setButton();
            }
        });
        mAdapter1.setOnItemClickListener(new MealOrderAdapter.OnItemClickListener() {
            @Override
            public void onPlusClick(MealItem mealItem) {
                toPay.add(mealItem);
                setButton();
            }

            @Override
            public void onMinusClick(MealItem mealItem) {
                toPay.remove(mealItem);
                setButton();
            }
        });
        zakazat = findViewById(R.id.zakazat);
        zakazat.setVisibility(View.GONE);
        zakazat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MealOrderActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });

    }

    @SuppressLint("SetTextI18n")
    public void setButton() {
        if (toPay.size() == 0) {
            zakazat.setVisibility(View.GONE);
        } else {
            Integer price = 0;
            for (int i = 0; i < toPay.size(); i++) {
                price += toPay.get(i).getPrice();
            }
            zakazat.setText("Заказ " + toPay.size() + " за KZT " + price.toString());
            zakazat.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        ViewDialog alert = new ViewDialog();
        alert.showDialog(MealOrderActivity.this);
        Toast.makeText(this, "backpressed", Toast.LENGTH_SHORT).show();

    }
}
/*comment*/