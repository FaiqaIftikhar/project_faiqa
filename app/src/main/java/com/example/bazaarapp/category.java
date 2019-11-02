package com.example.bazaarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class category extends AppCompatActivity {

    private Toolbar toolbar;
    private static RecyclerView.Adapter adapter;
    private static ArrayList<categoryData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

       //toolbar


        //recycler view
        RecyclerView verticalList=findViewById(R.id.categoryList1);
        //verticalList.setHasFixedSize(true);
        verticalList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        verticalList.setItemAnimator(new DefaultItemAnimator());


        data = new ArrayList<categoryData>();
        for (int i = 0; i < MyDataCategory.headingArray.length; i++) {
            data.add(new categoryData(
                    MyDataCategory.headingArray[i],
                    MyDataCategory.contetArray[i],
                    MyDataCategory.id_[i],
                    MyDataCategory.drawableArray_1[i],
                    MyDataCategory.drawableArray_2[i]
            ));
        }


        adapter = new categoryAdapter(data);
        verticalList.setAdapter(adapter);

    }

    public void backAcivity(View view){
        view.getContext().startActivity(new Intent(view.getContext(), home.class));
    }
    public void addToFavourite(View view){
        Toast.makeText(getApplicationContext(), "Added to favourites!" , Toast.LENGTH_SHORT ).show();
    }
}
