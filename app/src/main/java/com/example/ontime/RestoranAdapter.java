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

public class RestoranAdapter extends RecyclerView.Adapter<RestoranAdapter.RestoranViewHolder> implements Filterable {
    private ArrayList<RestoranItem> mRestoranList;
    private List<RestoranItem> mRestoranListFull;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        }


    public void setOnItemClickListener(OnItemClickListener listener){
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
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RestoranAdapter(ArrayList<RestoranItem> restoranList) {
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

    @Override
    public Filter getFilter() {
        return restoranFilter;
    }

    private Filter restoranFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<RestoranItem> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(mRestoranListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (RestoranItem item : mRestoranListFull) {
                    if (item.getRestoranName().toLowerCase().contains(filterPattern)){
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
