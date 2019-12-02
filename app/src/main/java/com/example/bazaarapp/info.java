package com.example.bazaarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class info extends AppCompatActivity {

    private String ImageUrl;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private List<Brand> artistList;
    private TextView brandName;
    private TextView brandCategory;
    private TextView brandContact;
    private TextView brandTimings;
    private TextView brandAddress;
    private Brand artist;
    private ImageView logo;


    DatabaseReference dbBrands;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Intent intent = getIntent();
        String g=intent.getStringExtra("brandName");
        brandName=findViewById(R.id.titleProduct);
        logo=findViewById(R.id.imageBack);

        Query query3 = FirebaseDatabase.getInstance().getReference("Registered Brands")
                .orderByChild("brandName")
                .equalTo(g);
        query3.addListenerForSingleValueEvent(valueEventListener);


        //////
        brandCategory=findViewById(R.id.infoProductType);



        /////



    }
    public void onSubscribe(View view){

            Toast.makeText(getApplicationContext(), "You will now recieve its notification! :))!" , Toast.LENGTH_SHORT ).show();


    }

    public String getMyData() {

        return brandName.getText().toString();
    }


    public void backAcivity(View view){
        view.getContext().startActivity(new Intent(view.getContext(), home.class));
    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
          //  artistList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    artist = snapshot.getValue(Brand.class);
                    //artistList.add(artist);
                    Toast.makeText(getBaseContext(), artist.getContact() , Toast.LENGTH_SHORT ).show();
                    brandName.setText(artist.getBrandName());
                    brandCategory.setText(artist.getCategory());
                    Picasso.get().load(artist.getBrandLogo())
                            .error(R.drawable.home).into(logo);

                    //Bundle bundle = new Bundle();
                 //   bundle.putString("edttext", brandName.getText().toString());
// set Fragmentclass Arguments
                   // productInfo fragobj = new productInfo();
                    //fragobj.setArguments(bundle);
                }
                //adapter.notifyDataSetChanged();
                viewPagerfunction();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    private void viewPagerfunction() {

        viewPager=findViewById(R.id.pager);
        adapter=new ViewPagerAdapter(getSupportFragmentManager(),artist.getLatitude(),artist.getContact(),artist.getTimings());




        viewPager.setAdapter(adapter);

        tabLayout=findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);


    }
}
