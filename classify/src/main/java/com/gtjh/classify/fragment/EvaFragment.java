package com.gtjh.classify.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.R2;
import com.gtjh.classify.bean.DetailsBean;
import com.gtjh.common.BaseFragment;
import com.gtjh.common.view.CustomViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android on 2018/7/26.
 */

@SuppressLint("ValidFragment")
public class EvaFragment extends Fragment {
    @BindView(R2.id.tv_one)
    TextView tvOne;
    @BindView(R2.id.tv_two)
    TextView tvTwo;
    @BindView(R2.id.tv_three)
    TextView tvThree;
    @BindView(R2.id.tv_four)
    TextView tvFour;
    @BindView(R2.id.tv_five)
    TextView tvFive;
    @BindView(R2.id.tv_amount)
    TextView tvAmount;
    @BindView(R2.id.tv_add)
    TextView tvAdd;
    @BindView(R2.id.tv_see)
    TextView tvSee;
    private String amount;
    private  DetailsBean.ProductBean.ReviwRateStarInfoBean data;
    private  CustomViewPager vp;
    private OnSeeClickListener onSeeClickListener;
    private View rootView;
    private int fragmentID;
    @SuppressLint("ValidFragment")
    public EvaFragment(CustomViewPager vp, int fragmentID){
        this.vp=vp;
        this.fragmentID=fragmentID;

    }
    public void setData(String amount, DetailsBean.ProductBean.ReviwRateStarInfoBean data){
        this.amount=amount;
        this.data=data;
        initData();
    }


    private void initEvent() {
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSeeClickListener!=null){
                    onSeeClickListener.onAdd();
                }
            }
        });
        tvSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onSeeClickListener!=null){
                    onSeeClickListener.onSee();
                }
            }
        });
    }

    private void initData() {
        if (vp!=null){
            tvOne.setText(data.getStar_1()+"");
            tvThree.setText(data.getStar_3()+"");
            tvTwo.setText(data.getStar_2()+"");
            tvFour.setText(data.getStar_4()+"");
            tvFive.setText(data.getStar_5()+"");
            tvAmount.setText(amount);
        }
    }

    public void setOnSeeClickListener(OnSeeClickListener onSeeClickListener) {
        this.onSeeClickListener = onSeeClickListener;
    }

    public interface OnSeeClickListener{
        void onAdd();
        void onSee();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_eva, container, false);
        ButterKnife.bind(this, rootView);
        vp.setObjectForPosition(rootView,fragmentID);
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();
    }

}
