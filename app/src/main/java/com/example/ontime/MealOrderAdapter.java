package com.example.ontime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MealOrderAdapter extends RecyclerView.Adapter<MealOrderAdapter.MealOrderViewHolder> {
    private ArrayList<MealItem> mMealList;
    private List<MealItem> mMealListFull;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        //void onItemClick(int position);
        void onMinusClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class MealOrderViewHolder extends RecyclerView.ViewHolder {
        public ImageView mealImage;
        public TextView mealName;
        public TextView mealPrice;
        public TextView foodQuantity;
        public ImageView minusButton;
        public ImageView plusButton;

        public MealOrderViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            minusButton = itemView.findViewById(R.id.ic_minus);
            plusButton = itemView.findViewById(R.id.ic_plus);
            foodQuantity = itemView.findViewById(R.id.meal_quantity);

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onMinusClick(position);
                        }
                    }
                }
            });

            mealImage = itemView.findViewById(R.id.img);
            mealName = itemView.findViewById(R.id.meal_name);
            mealPrice = itemView.findViewById(R.id.meal_price);

        }
    }

    public MealOrderAdapter(ArrayList<MealItem> MealList) {
        mMealList = MealList;
        mMealListFull = new ArrayList<>(MealList);
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
          MealItem currentItem = mMealList.get(position);
          holder.mealImage.setImageResource(currentItem.getBackgroundImage());
          holder.mealName.setText(currentItem.getMealName());
          holder.mealPrice.setText(currentItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return mMealList.size();
    }
}
