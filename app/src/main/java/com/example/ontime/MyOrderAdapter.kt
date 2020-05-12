package com.example.ontime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MyOrderAdapter(myOrderList: ArrayList<MyOrderItem>) : RecyclerView.Adapter<MyOrderAdapter.MyOrderViewHolder>() {
    private val mMyOrderList: ArrayList<MyOrderItem>
    private val mMyOrderListFull: List<MyOrderItem>
    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        mListener = listener
    }

    class MyOrderViewHolder(itemView: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageView
        var mTextView1: TextView
        var mTextView2: TextView
        var mTextView3: TextView
        var mTextView4: TextView

        init {
            mImageView = itemView.findViewById(R.id.my_orders_item_img)
            mTextView1 = itemView.findViewById(R.id.my_orders_rest_name)
            mTextView2 = itemView.findViewById(R.id.my_orders_order)
            mTextView3 = itemView.findViewById(R.id.my_orders_status)
            mTextView4 = itemView.findViewById(R.id.my_orders_quantity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyOrderViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.my_order_item, parent, false)
        return MyOrderViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: MyOrderViewHolder, position: Int) {
        val currentItem: MyOrderItem = mMyOrderList[position]
        holder.mImageView.setImageResource(currentItem.restoranImage)
        holder.mTextView1.setText(currentItem.restoranName)
        holder.mTextView2.setText(currentItem.order)
        holder.mTextView3.setText(currentItem.status)
        holder.mTextView4.setText(currentItem.quantity)
    }

    override fun getItemCount(): Int {
        return mMyOrderList.size
    }

    init {
        mMyOrderList = myOrderList
        mMyOrderListFull = ArrayList<MyOrderItem>(myOrderList)
    }
}