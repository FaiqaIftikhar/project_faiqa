package com.example.bazaarapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class productInfo extends Fragment {



    String timings;
    Double address;
    String contact;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;


    public productInfo() {
        // Required empty public constructor
    }


    public productInfo(Double lat,String contact,String time) {
        this.timings=time;
        this.address=lat;
        this.contact=contact;
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


        // recyclerView = (RecyclerView) view.findViewById(R.id.info_recycler_view);
        //info activity = (info) getActivity();
      // String myDataFromActivity = activity.getMyData();
        //String s = ((info) this.getApplication()).getSomeVariable();

        TextView tv=view.findViewById(R.id.content1);
        tv.setText(address.toString());


        TextView tv1=view.findViewById(R.id.content12);
        tv1.setText(contact.toString());
        TextView tv2=view.findViewById(R.id.content13);
        tv2.setText(timings.toString());

        //recyclerView.setHasFixedSize(true);

        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
/*
        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.headingArray.length; i++) {
            data.add(new DataModel(
                    MyData.headingArray[i],
                    MyData.contetArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }*/
        //adapter = new CustomAdapter(data);
        //recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment



        return view;
    }


}
