package com.example.complex;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
               return FirstFragment.newInstance();
            case 1:
                return SecondFragment.newInstance();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String tabName = "";

        switch (position){
            case 0:
                tabName = "Tab - A";
                break;
            case 1:
                tabName = "Tab - B";
                break;
        }
        return tabName;
    }

    /**
     * this method will return number of fragments
     *
     * @return count of fragments
     */
    @Override
    public int getCount() {
        return 2;
    }
}
