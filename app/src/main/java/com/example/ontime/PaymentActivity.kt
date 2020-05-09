package com.example.ontime

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ontime.data.RestaurantMenu
import kotlinx.android.synthetic.main.activity_payment.*
import java.util.*

class PaymentActivity : AppCompatActivity() {
    lateinit var mAdapter: MealOrderAdapter
    var toPay = ArrayList<RestaurantMenu.Data.Meal>()
    var productsPrice = 0
    var deliveryPrice = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        podtverdit_zakaz.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@PaymentActivity, SuccessActivity::class.java)
            startActivity(intent)
            finish()
        })
        val b = intent.extras
        val data = b!!.get("data")!!
        toPay = data as ArrayList<RestaurantMenu.Data.Meal>
        for (item in toPay) {
            productsPrice += item.price * item.quantity
        }
        deliveryPrice = 400
        my_orders_recycler.setHasFixedSize(true)
        my_orders_recycler.layoutManager = LinearLayoutManager(this)
        mAdapter = MealOrderAdapter(toPay)
        my_orders_recycler.adapter = mAdapter
        mAdapter!!.setOnItemClickListener(object : MealOrderAdapter.OnItemClickListener {
            override fun onPlusClick(mealItem: RestaurantMenu.Data.Meal?) {
                productsPrice += mealItem?.price!!
                setPrice()

            }

            override fun onMinusClick(mealItem: RestaurantMenu.Data.Meal?) {
                productsPrice -= mealItem?.price!!
                        if (mealItem?.quantity == 0)
                            toPay.remove(mealItem)
                setPrice()

            }
        })


    }

    fun setPrice() {
        produkti_summa.text = productsPrice.toString()
        dostavka_summa.text = deliveryPrice.toString()
        obshaya_summa.text = (deliveryPrice + productsPrice).toString()

    }
}