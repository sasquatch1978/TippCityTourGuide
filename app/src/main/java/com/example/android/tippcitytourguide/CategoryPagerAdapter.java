package com.example.android.tippcitytourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    // Create a new CategoryPagerAdapter object.
    CategoryPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    // Return the Fragment that should be displayed for the given page number.
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SightsFragment();
            case 1:
                return new EventsFragment();
            case 2:
                return new FoodFragment();
            default:
                return new HotelsFragment();
        }
    }

    // Return the total number of pages.
    @Override
    public int getCount() {
        return 4;
    }

    // Return the tab title displayed for each page.
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.tabTitleOne);
            case 1:
                return context.getString(R.string.tabTitleTwo);
            case 2:
                return context.getString(R.string.tabTitleThree);
            default:
                return context.getString(R.string.tabTitleFour);
        }
    }
}
