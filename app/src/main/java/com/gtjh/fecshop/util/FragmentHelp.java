package com.gtjh.fecshop.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentHelp {
    private FragmentManager fragmentManager;
    private Fragment currentFragment;

    public FragmentHelp(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void add(Fragment fragment, int id, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //优先检查，fragment是否存在，避免重叠
        Fragment tempFragment = fragmentManager.findFragmentByTag(tag);
        if (null != tempFragment) {
            fragment = tempFragment;
        }
        if (fragment.isAdded()) {
            addOrShowFragment(fragmentTransaction, fragment, id, tag);
        } else {
            if (currentFragment != null && currentFragment.isAdded()) {
                fragmentTransaction.hide(currentFragment).add(id, fragment, tag).commit();
            } else {
                fragmentTransaction.add(id, fragment, tag).commit();
            }
            currentFragment = fragment;
        }
    }

    /**
     * 添加或者显示 fragment
     *
     * @param fragment
     */
    private void addOrShowFragment(FragmentTransaction transaction, Fragment fragment, int id, String tag) {
        if (currentFragment == fragment || currentFragment == null)
            return;
        if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
            transaction.hide(currentFragment).add(id, fragment, tag).commit();
        } else {
            transaction.hide(currentFragment).show(fragment).commit();
        }
        currentFragment.setUserVisibleHint(false);
        currentFragment = fragment;
        currentFragment.setUserVisibleHint(true);
    }
}