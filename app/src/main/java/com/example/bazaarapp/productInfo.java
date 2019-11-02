package com.example.bazaarapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class productInfo extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;


    public productInfo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public static productInfo newInstance() {
        productInfo fragment = new productInfo();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.product_info, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.info_recycler_view);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.headingArray.length; i++) {
            data.add(new DataModel(
                    MyData.headingArray[i],
                    MyData.contetArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }
        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment


        return view;
    }


}
