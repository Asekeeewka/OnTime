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

import com.example.ontime.data.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestoranAdapter extends RecyclerView.Adapter<RestoranAdapter.RestoranViewHolder> implements Filterable {
    private ArrayList<Restaurant.Data> mRestoranList;
    private List<Restaurant.Data> mRestoranListFull;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class RestoranViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;

        public RestoranViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.restoran_background);
            mTextView1 = itemView.findViewById(R.id.restoran_name);
            mTextView2 = itemView.findViewById(R.id.restoran_price);
            mTextView3 = itemView.findViewById(R.id.restoran_distance_value);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RestoranAdapter(ArrayList<Restaurant.Data> restoranList) {
        mRestoranList = restoranList;
        mRestoranListFull = new ArrayList<>(restoranList);
    }

    @NonNull
    @Override
    public RestoranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restoran_item, parent, false);
        RestoranViewHolder rvh = new RestoranViewHolder(v, mListener);
        return rvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RestoranViewHolder holder, int position) {
        Restaurant.Data currentItem = mRestoranList.get(position);

        holder.mImageView.setImageResource(R.drawable.bg5);
        holder.mTextView1.setText(currentItem.getName());
        holder.mTextView2.setText("400");
        holder.mTextView3.setText("4.5");
    }

    @Override
    public int getItemCount() {
        return mRestoranList.size();
    }

    @Override
    public Filter getFilter() {
        return restoranFilter;
    }

    private Filter restoranFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Restaurant.Data> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(mRestoranListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Restaurant.Data item : mRestoranListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mRestoranList.clear();
            mRestoranList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
