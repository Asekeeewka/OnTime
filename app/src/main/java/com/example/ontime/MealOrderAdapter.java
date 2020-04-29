package com.example.ontime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MealOrderAdapter extends RecyclerView.Adapter<MealOrderAdapter.MealOrderViewHolder> {
    private ArrayList<RestoranItem> mRestoranList;
    private List<RestoranItem> mRestoranListFull;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class MealOrderViewHolder extends RecyclerView.ViewHolder {

//        public ImageView mImageView;
//        public TextView mTextView1;
//        public TextView mTextView2;
//        public TextView mTextView3;

        public MealOrderViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
//            mImageView = itemView.findViewById(R.id.restoran_background);
//            mTextView1 = itemView.findViewById(R.id.restoran_name);
//            mTextView2 = itemView.findViewById(R.id.restoran_price);
//            mTextView3 = itemView.findViewById(R.id.restoran_distance_value);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (listener != null){
//                        int position = getAdapterPosition();
//                        if(position != RecyclerView.NO_POSITION){
//                            listener.onItemClick(position);
//                        }
//                    }
//                }
//            });
        }
    }

    public MealOrderAdapter(ArrayList<RestoranItem> restoranList) {
        mRestoranList = restoranList;
        mRestoranListFull = new ArrayList<>(restoranList);
    }

    @NonNull
    @Override
    public MealOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_order_item, parent, false);
        MealOrderViewHolder rvh = new MealOrderViewHolder(v, mListener);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealOrderViewHolder holder, int position) {
//        RestoranItem currentItem = mRestoranList.get(position);
//
//        holder.mImageView.setImageResource(currentItem.getBackgroundImage());
//        holder.mTextView1.setText(currentItem.getRestoranName());
//        holder.mTextView2.setText(currentItem.getPrice());
//        holder.mTextView3.setText(currentItem.getDistance());
    }

    @Override
    public int getItemCount() {
        return mRestoranList.size();
    }
}
