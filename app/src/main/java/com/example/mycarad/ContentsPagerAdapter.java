package com.example.mycarad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class ContentsPagerAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;
    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                CaruserTabFragment caruserTab = new CaruserTabFragment();
                return CaruserTabFragment;
            case 2:
                AdvisorTabFragment advisorTab = new AdvisorTabFragment();
                return advisorTabFragment;
            default:
                return null;
        }
    }



    @Override

    public int getCount() {

        return mPageCount;

    }

}