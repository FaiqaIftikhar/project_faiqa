package com.example.bazaarapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class reviewProduct extends Fragment {


    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModelReview> data;

    public reviewProduct() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public static reviewProduct newInstance() {
        reviewProduct fragment = new reviewProduct();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.review_product, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.review_recycler_view);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //

      //
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.addRev);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RatingBar ratingBar = new RatingBar(view.getContext());
                ratingBar.setStepSize((float) 0.5);

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        data = new ArrayList<DataModelReview>();
        for (int i = 0; i < MyDataReview.nameReviewArray.length; i++) {
            data.add(new DataModelReview(
                    MyDataReview.nameReviewArray[i],
                    MyDataReview.id_review[i]
            ));
        }
        adapter = new CustomAdapterReview(data);
        recyclerView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return view;
    }


}
