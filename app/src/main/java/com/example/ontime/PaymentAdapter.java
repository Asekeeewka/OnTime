package com.example.ontime;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.MyOrderViewHolder> {
    private ArrayList<MyOrderItem> mMyOrderList;
    private List<MyOrderItem> mMyOrderListFull;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class MyOrderViewHolder extends RecyclerView.ViewHolder {

//        public ImageView mImageView;
//        public TextView mTextView1;
//        public TextView mTextView2;
//        public TextView mTextView3;
//        public TextView mTextView4;

        public MyOrderViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
//            mImageView = itemView.findViewById(R.id.my_orders_item_img);
//            mTextView1 = itemView.findViewById(R.id.my_orders_rest_name);
//            mTextView2 = itemView.findViewById(R.id.my_orders_order);
//            mTextView3 = itemView.findViewById(R.id.my_orders_status);
//            mTextView4 = itemView.findViewById(R.id.my_orders_quantity);

        }
    }

    public PaymentAdapter(ArrayList<MyOrderItem> myOrderList) {
        mMyOrderList = myOrderList;
        mMyOrderListFull = new ArrayList<>(myOrderList);
    }

    @NonNull
    @Override
    public MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_item, parent, false);
        MyOrderViewHolder rvh = new MyOrderViewHolder(v, mListener);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderViewHolder holder, int position) {
        MyOrderItem currentItem = mMyOrderList.get(position);

//        holder.mImageView.setImageResource(currentItem.getRestoranImage());
//        holder.mTextView1.setText(currentItem.getRestoranName());
//        holder.mTextView2.setText(currentItem.getOrder());
//        holder.mTextView3.setText(currentItem.getStatus());
//        holder.mTextView4.setText(currentItem.getQuantity());
    }

    @Override
    public int getItemCount() {
        return mMyOrderList.size();
    }


}
