package com.example.ontime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {
    private TextView podtverditZakaz;
    private RecyclerView mRecyclerView;
    private PaymentAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        podtverditZakaz=findViewById(R.id.podtverdit_zakaz);
        podtverditZakaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentActivity.this,SuccessActivity.class);
                startActivity(intent);
                finish();
            }
        });
        final ArrayList<MyOrderItem> myOrderList = new ArrayList<>();
        myOrderList.add(new MyOrderItem(R.drawable.bg5,"Aroma","Пицца Пепперони", "Уже в пути","3х"));

        mRecyclerView = findViewById(R.id.my_orders_recycler);
        mAdapter = new PaymentAdapter(myOrderList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

    }
}
/*comment*/