package com.example.ontime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestoranAdapter extends RecyclerView.Adapter<RestoranAdapter.RestoranViewHolder> {
    private ArrayList<RestoranItem> mRestoranList;

    public static class RestoranViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public RestoranViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.restoran_background);
            mTextView1 = itemView.findViewById(R.id.restoran_name);
            mTextView2 = itemView.findViewById(R.id.restoran_price);
            mTextView3 = itemView.findViewById(R.id.restoran_distance_value);
        }
    }

    public RestoranAdapter(ArrayList<RestoranItem> restoranList) {
        mRestoranList = restoranList;
    }

    @NonNull
    @Override
    public RestoranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restoran_item, parent, false);
        RestoranViewHolder rvh = new RestoranViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RestoranViewHolder holder, int position) {
        RestoranItem currentItem = mRestoranList.get(position);

        holder.mImageView.setImageResource(currentItem.getBackgroundImage());
        holder.mTextView1.setText(currentItem.getRestoranName());
        holder.mTextView2.setText(currentItem.getPrice());
        holder.mTextView3.setText(currentItem.getDistance());
    }

    @Override
    public int getItemCount() {
        return mRestoranList.size();
    }
}
