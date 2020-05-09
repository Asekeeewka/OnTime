package com.example.ontime

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ontime.MealOrderAdapter.MealOrderViewHolder
import com.example.ontime.data.RestaurantMenu.Data.Meal
import java.util.*


class MealOrderAdapter(private val mMealList: ArrayList<Meal>) : RecyclerView.Adapter<MealOrderViewHolder>() {
    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onPlusClick(mealItem: Meal?)
        fun onMinusClick(mealItem: Meal?)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        mListener = listener
    }

    class MealOrderViewHolder(itemView: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
        var mealImage: ImageView
        var mealName: TextView
        var mealPrice: TextView
        var foodQuantity: TextView
        var minusButton: ImageView
        var plusButton: ImageView

        init {
            minusButton = itemView.findViewById(R.id.ic_minus)
            plusButton = itemView.findViewById(R.id.ic_plus)
            foodQuantity = itemView.findViewById(R.id.meal_quantity)
            mealImage = itemView.findViewById(R.id.img)
            mealName = itemView.findViewById(R.id.meal_name)
            mealPrice = itemView.findViewById(R.id.meal_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealOrderViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.meal_order_item, parent, false)
        return MealOrderViewHolder(v, mListener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MealOrderViewHolder, position: Int) {
        val currentItem = mMealList[position]
        holder.mealImage.setImageResource(R.drawable.bg5)
        holder.mealName.text = currentItem.name
        holder.mealPrice.text = currentItem.price.toString()
        if (currentItem.quantity == 0) {
            holder.minusButton.visibility = View.INVISIBLE
            holder.foodQuantity.visibility = View.INVISIBLE
        } else {
            holder.minusButton.visibility = View.VISIBLE
            holder.foodQuantity.visibility = View.VISIBLE
            holder.foodQuantity.text = currentItem.quantity.toString() + "x"
        }
        holder.plusButton.setOnClickListener {
            currentItem.quantity = (currentItem.quantity + 1)
            notifyDataSetChanged()
            mListener!!.onPlusClick(currentItem)
        }
        holder.minusButton.setOnClickListener {
            currentItem.quantity = (currentItem.quantity - 1)
            notifyDataSetChanged()
            mListener!!.onMinusClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return mMealList.size
    }

}