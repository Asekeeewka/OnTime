package com.example.ontime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ontime.RestoranAdapter.RestoranViewHolder
import com.example.ontime.data.Restaurant
import java.util.*

class RestoranAdapter(private val mRestoranList: ArrayList<Restaurant.Data>) : RecyclerView.Adapter<RestoranViewHolder>(), Filterable {
    var mRestoranListFull: List<Restaurant.Data> = ArrayList(mRestoranList)

    class RestoranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImageView: ImageView
        var mTextView1: TextView
        var mTextView2: TextView
        var mTextView3: TextView

        init {
            mImageView = itemView.findViewById(R.id.restoran_background)
            mTextView1 = itemView.findViewById(R.id.restoran_name)
            mTextView2 = itemView.findViewById(R.id.restoran_price)
            mTextView3 = itemView.findViewById(R.id.restoran_distance_value)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoranViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.restoran_item, parent, false)
        return RestoranViewHolder(v)
    }

    override fun onBindViewHolder(holder: RestoranViewHolder, position: Int) {
        val (_, name) = mRestoranList[position]
        holder.mImageView.setImageResource(R.drawable.bg5)
        holder.mTextView1.text = name
        holder.mTextView2.text = "400"
        holder.mTextView3.text = "4.5"
    }

    override fun getItemCount(): Int {
        return mRestoranList.size
    }

    override fun getFilter(): Filter {
        return restoranFilter
    }

    private val restoranFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filteredList: MutableList<Restaurant.Data> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(mRestoranListFull)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
                for (item in mRestoranListFull) {
                    if (item.name.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            mRestoranList.clear()
            mRestoranList.addAll(results.values as Collection<Restaurant.Data>)
            notifyDataSetChanged()
        }
    }

}