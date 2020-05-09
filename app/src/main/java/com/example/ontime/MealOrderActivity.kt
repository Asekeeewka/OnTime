package com.example.ontime

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ontime.data.RestaurantMenu
import com.example.ontime.network.ApiFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_meal_order.*
import org.json.JSONArray
import java.util.*


class MealOrderActivity : AppCompatActivity() {
    private var mAdapter: MealOrderAdapter? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var toPay = ArrayList<RestaurantMenu.Data.Meal>()
    lateinit var compositeDisposable: CompositeDisposable
    lateinit var id: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_order)
        zakazat?.visibility = View.GONE
        val b = intent.extras
        id = b!!.getString("id")!!

        zakazat?.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            toPay= toPay.distinctBy { Pair(it.createdAt, it.createdAt) } as ArrayList<RestaurantMenu.Data.Meal>
            intent.putExtra("data", toPay)
            startActivity(intent)
        }
        getData()
    }

    @SuppressLint("SetTextI18n")
    fun setButton() {
        if (toPay.size == 0) {
            zakazat!!.visibility = View.GONE
        } else {
            var price = 0
            for (i in toPay.indices) {
                price += toPay[i].price
            }
            zakazat!!.text = "Заказ " + toPay.size + " за KZT " + price.toString()
            zakazat!!.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        val alert = ViewDialog()
        alert.showDialog(this@MealOrderActivity)
    }

    fun getData() {
        compositeDisposable = CompositeDisposable()
        val disposable = ApiFactory.instance.apiService
                .getRestaurantsMenu(id!!)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    when (data.code()) {
                        200, 201 -> {
                            text_name.text = data.body()?.data?.name!!
                            setAdapter(data.body()?.data?.meals!!)
                        }
                        else -> {
                            println("API connection " + data.code())
                        }
                    }
                }, { throwable ->
                    Log.d("Tag", throwable.toString())
                })
        compositeDisposable.add(disposable)
    }

    fun setAdapter(data: List<RestaurantMenu.Data.Meal>) {
        fast_food_rv.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        mAdapter = MealOrderAdapter(data as ArrayList<RestaurantMenu.Data.Meal>)
        fast_food_rv.layoutManager = mLayoutManager
        fast_food_rv.adapter = mAdapter
        mAdapter!!.setOnItemClickListener(object : MealOrderAdapter.OnItemClickListener {
            override fun onPlusClick(mealItem: RestaurantMenu.Data.Meal?) {
                toPay.add(mealItem!!)
                setButton()
            }

            override fun onMinusClick(mealItem: RestaurantMenu.Data.Meal?) {
                toPay.remove(mealItem)
                setButton()
            }
        })
    }

}