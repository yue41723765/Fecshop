package com.gtjh.classify.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.PluralsRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.R2;
import com.gtjh.classify.adapter.DescAdapter;
import com.gtjh.common.BaseFragment;
import com.gtjh.common.view.CustomLinearLayoutManager;
import com.gtjh.common.view.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by android on 2018/7/26.
 */

@SuppressLint("ValidFragment")
public class DescFragment extends Fragment {
    @BindView(R2.id.rv_img)
    RecyclerView rvImg;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    private DescAdapter descAdapter;
    private List<String> list=new ArrayList<>();
    private String title="";
    private CustomViewPager vp;
    private int fragmentID;
    private View rootView;
    private Context mContext;
    @SuppressLint("ValidFragment")
    public DescFragment(CustomViewPager vp, int fragmentID){
        this.vp=vp;
        this.fragmentID=fragmentID;

    }
    public void setData(String title,List<String> list){
        this.title=title;
        this.list=list;
        initData();
    }


    protected void init() {
        descAdapter=new DescAdapter(list,mContext);
        //解决滑动冲突
        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(mContext);
        linearLayoutManager.setScrollEnabled(false);
        rvImg.setLayoutManager(linearLayoutManager);
        rvImg.setAdapter(descAdapter);
        rvImg.setOverScrollMode(View.OVER_SCROLL_NEVER);
        initData();
    }

    private void initData() {
        if (list!=null&&list.size()>0){
            descAdapter.initData(list);
            rvImg.setVisibility(View.VISIBLE);
        }else {
            rvImg.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(title)){
            tvTitle.setText(Html.fromHtml(title));
            tvTitle.setVisibility(View.VISIBLE);
        }else {
            tvTitle.setVisibility(View.GONE);
        }
        //vp.setObjectForPosition(rootView,fragmentID);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_desc, container, false);
        ButterKnife.bind(this, rootView);
        mContext=getContext();
        vp.setObjectForPosition(rootView,fragmentID);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

}
