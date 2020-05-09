package com.example.ontime

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ontime.data.Restaurant
import com.example.ontime.network.ApiFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_meal_order.*
import kotlinx.android.synthetic.main.activity_restoran.*
import java.util.ArrayList


class RestoranActivity : AppCompatActivity() {
    private var mAdapter: RestoranAdapter? = null
    private var searchView: SearchView? = null
    lateinit var compositeDisposable: CompositeDisposable

    private var fab: FloatingActionButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restoran)
        fab?.setOnClickListener {
            val intent = Intent(this@RestoranActivity, MyOrdersActivity::class.java)
            startActivity(intent)
        }
        searchView = findViewById<View>(R.id.search_view) as SearchView
        searchView!!.imeOptions = EditorInfo.IME_ACTION_DONE
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                mAdapter!!.filter.filter(newText)
                return false
            }
        })
        getData()
    }

    override fun onBackPressed() {
        searchView!!.setQuery("", false)
    }

    fun getData() {
        compositeDisposable = CompositeDisposable()
        val disposable = ApiFactory.instance.apiService
                .getRestaurants()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    when (data.code()) {
                        200, 201 -> {
                            setAdapter(data.body()?.data!!)
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

    fun setAdapter(data: List<Restaurant.Data>) {
        restoran_recycler?.setHasFixedSize(true)
        mAdapter = RestoranAdapter(data as ArrayList<Restaurant.Data>?)
        restoran_recycler?.layoutManager = LinearLayoutManager(this)
        restoran_recycler?.adapter = mAdapter
        mAdapter!!.setOnItemClickListener {
            val intent = Intent(this@RestoranActivity, MealOrderActivity::class.java)
            intent.putExtra("id", data[it].id.toString())
            startActivity(intent)
        }
    }

}