package com.example.bazaarapp;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new productInfo();
                break;
            case 1:
                fragment = new reviewProduct();
                break;


        }
        return fragment;
    }
    @Override
    public int getCount(){
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        // position=position+1;
        CharSequence arr=null;
        switch(position) {
            case 0:
                arr = "Info";
                break;

            case 1:
                arr = "Review";
                break;

        }

        return arr;
    }
}
