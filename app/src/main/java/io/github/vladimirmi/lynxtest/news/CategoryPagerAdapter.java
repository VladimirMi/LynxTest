package io.github.vladimirmi.lynxtest.news;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import io.github.vladimirmi.lynxtest.data.net.Api;

/**
 * Created by Vladimir Mikhalev 24.05.2018.
 */
public class CategoryPagerAdapter extends FragmentStatePagerAdapter {

    private final String[] tabTitles;

    public CategoryPagerAdapter(FragmentManager fm, String[] tabTitles) {
        super(fm);
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryFragment.newInstance(Api.CATEGORIES[position]);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
