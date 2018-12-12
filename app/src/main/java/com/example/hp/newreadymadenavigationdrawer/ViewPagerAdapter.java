package com.example.hp.newreadymadenavigationdrawer;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0 : return new DriverScore();
            case 1 : return new DemoFragment();
            //case 2 : return new DemoFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "Today's Score";
            case 1 :
                return "Behavior";
            //case 2 :
              //  return "Tab 3";
        }
        return null;
    }
}
