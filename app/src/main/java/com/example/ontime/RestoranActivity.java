package com.example.ontime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RestoranActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RestoranAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private SearchView searchView;
    private View rootView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoran);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestoranActivity.this, MyOrdersActivity.class);
                startActivity(intent);
            }
        });

        final ArrayList<RestoranItem> restoranList = new ArrayList<>();
        restoranList.add(new RestoranItem(R.drawable.bg5, "Aroma", "400,00", "1.5"));
        restoranList.add(new RestoranItem(R.drawable.bg5, "CoffeeBOOM", "400,00", "1.7"));
        restoranList.add(new RestoranItem(R.drawable.bg5, "Thali", "400,00", "2.5"));
        restoranList.add(new RestoranItem(R.drawable.bg5, "VeganGo", "400,00", "3.0"));

        mRecyclerView = findViewById(R.id.restoran_recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RestoranAdapter(restoranList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RestoranAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(RestoranActivity.this, MealOrderActivity.class);
                startActivity(intent);
            }
        });

        searchView = (SearchView) findViewById(R.id.search_view);
        Log.d("asd","asdasdsadasdsadasdasdasdsa");
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        searchView.setQuery("",false);
        Toast.makeText(this, "backpressed", Toast.LENGTH_SHORT).show();
        ;
    }


}

