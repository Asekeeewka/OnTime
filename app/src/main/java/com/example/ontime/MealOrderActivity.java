package com.example.ontime;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private RecyclerView.LayoutManager mLayoutManager;
    private View rootView;
    private ImageView test;
    private TextView asd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_order);
        final ArrayList<MealItem> mealList = new ArrayList<>();
        mealList.add(new MealItem(R.drawable.bg5, "Пицца Пепперони", "400,00"));
        mealList.add(new MealItem(R.drawable.bg5, "Бургер Халапеньо", "1300,00"));


        mRecyclerView = findViewById(R.id.fast_food_rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView1 = findViewById(R.id.salats_rv);
        mRecyclerView1.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MealOrderAdapter(mealList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView1.setAdapter(mAdapter);
        asd=findViewById(R.id.meal_quantity);

        mAdapter.setOnItemClickListener(new MealOrderAdapter.OnItemClickListener() {
            @Override
            public void onMinusClick(int position) {
                Toast.makeText(MealOrderActivity.this,"ASDDASDASDAS",Toast.LENGTH_LONG).show();


            }
        });
        test = (ImageView) findViewById(R.id.ic_minus);
        //test.setVisibility(View.GONE);

    }
    @Override
    public void onBackPressed() {
        ViewDialog alert = new ViewDialog();
        alert.showDialog(MealOrderActivity.this);
        Toast.makeText(this, "backpressed", Toast.LENGTH_SHORT).show();

    }
}
