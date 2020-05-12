package com.example.ontime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_my_orders.*
import java.util.*

class MyOrdersActivity : AppCompatActivity() {
    private var mAdapter: MyOrderAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)
        val myOrderList = ArrayList<MyOrderItem>()
        myOrderList.add(MyOrderItem(R.drawable.bg5, "Aroma", "Пицца Пепперони", "Уже в пути", "3х"))
        myOrderList.add(MyOrderItem(R.drawable.bg5, "CoffeeBOOM", "Гнездо глухаря", "Обрабатывается", "4х"))
        mAdapter = MyOrderAdapter(myOrderList)
        my_orders_recycler.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        my_orders_recycler.setLayoutManager(mLayoutManager)
        my_orders_recycler.setAdapter(mAdapter)
    }
}