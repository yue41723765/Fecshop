package com.gtjh.classify.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by android on 2018/7/26.
 */

public class DetailsPagerAdapter extends FragmentPagerAdapter {
    //添加fragment的集合
    private List<Fragment> mFragmentList;
    //添加标题的集合
    private String[] mTilteLis;

    public DetailsPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] tilteLis) {
        super(fm);
        mFragmentList = fragmentList;
        mTilteLis = tilteLis;
    }
    public DetailsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    //获取标题
    @Override
    public CharSequence getPageTitle(int position) {

        return mTilteLis[position];
    }
}
