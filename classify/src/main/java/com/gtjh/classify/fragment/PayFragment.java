package com.gtjh.classify.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gtjh.classify.R;
import com.gtjh.common.BaseFragment;
import com.gtjh.common.view.CustomViewPager;

import butterknife.ButterKnife;

/**
 * Created by android on 2018/7/26.
 */

@SuppressLint("ValidFragment")
public class PayFragment extends Fragment {
    private CustomViewPager vp;
    private View rootView;
    private int fragmentID;
    @SuppressLint("ValidFragment")
    public  PayFragment(CustomViewPager vp, int fragmentID){
        this.vp=vp;
        this.fragmentID=fragmentID;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_pay, container, false);
        ButterKnife.bind(this, rootView);
        vp.setObjectForPosition(rootView,fragmentID);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
