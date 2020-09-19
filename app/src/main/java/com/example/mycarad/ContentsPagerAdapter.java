package com.example.mycarad;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {

    private int pageCount;
    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.pageCount = pageCount;
    }
    @Override
    public Fragment getItem(int position) {
     /*   switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
             //   CaruserTabFragment caruserTab = new CaruserTabFragment();
             //   return CaruserTabFragment;
            case 2:
             //   AdvisorTabFragment advisorTab = new AdvisorTabFragment();
             //   return advisorTabFragment;
            default:
             //   return null;*/
     return new HomeFragment();
        }




    @Override

    public int getCount() {

        return pageCount;

    }

}