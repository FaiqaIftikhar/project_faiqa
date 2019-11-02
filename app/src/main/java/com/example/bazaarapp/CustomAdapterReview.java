package com.example.bazaarapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterReview extends RecyclerView.Adapter<CustomAdapterReview.MyViewHolder> {

    //public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>

    private ArrayList<DataModelReview> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.reviewName);
        }
    }

    public CustomAdapterReview(ArrayList<DataModelReview> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_review_product, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    //

    //

    @Override
    public void onBindViewHolder(final CustomAdapterReview.MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;

        textViewName.setText(dataSet.get(listPosition).getName_review());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
