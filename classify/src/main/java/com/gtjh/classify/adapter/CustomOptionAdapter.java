package com.gtjh.classify.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.classify.R;
import com.gtjh.classify.bean.CustomOptionBean;
import com.gtjh.classify.bean.CustomOptionListBean;
import com.gtjh.classify.bean.DetailsBean;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.http.POST;

/**
 * Created by android on 2018/7/27.
 */

public class CustomOptionAdapter extends CommonAdapter<List<CustomOptionListBean>> {

    private Context mContext;
    private List<String> keys=new ArrayList<>();
    private List<CustomOptionListBean> listBeans=new ArrayList<>();
    private List<List<CustomOptionListBean>> lists=new ArrayList<>();
    private ItemCustomOptionAdapter adapter;
    private List<String[]> listMap=new ArrayList<>();
    private Map<String,String> values=new HashMap<>();
    public CustomOptionAdapter(Context context,List<String> keys,List<List<CustomOptionListBean>> lists,List<String[]> listMap){
        super(lists,context);
        mContext=context;
        this.keys=keys;
        this.lists=lists;
        this.listMap=listMap;
    }
    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_condition;
    }

    @Override
    protected void showItemContent(ViewHolder holder,final int position, List<CustomOptionListBean> o) {
        TextView title=holder.findViewById(R.id.tv_title);
        RecyclerView rvData=holder.findViewById(R.id.rv_data);
        title.setText(keys.get(position));

        listBeans=lists.get(position);

        adapter=new ItemCustomOptionAdapter(listBeans,context);
        rvData.setLayoutManager(new GridLayoutManager(mContext,4));
        rvData.setAdapter(adapter);

        adapter.setOnItemCustomClickListener(new ItemCustomOptionAdapter.OnItemCustomClickListener() {
            @Override
            public void onItemClick(int p, int pos, String val, Boolean isChecked) {
                //选中时
                if (isChecked) {
                    //在干啥我不知道 接手代码的 请代我对后台说一句 祝他写代码天天电脑自动断电，吃方便面没有调料包，洗头发用到脱毛膏。fuck！ 共14个for
                    //取消这行 所有的选中状态 注意使用传过来的position
                    for (int j = 0; j < lists.get(position).size(); j++) {
                        if (lists.get(position).get(j).getIsChecked() == 0) {
                            lists.get(position).get(j).setIsChecked(1);
                        }
                    }
                    //选中你刚刚选中的
                    lists.get(position).get(pos).setIsChecked(0);
                }else {
                    //反选时 取消已选中的item
                    lists.get(position).get(pos).setIsChecked(1);
                }
                    //拿到所有选中的item
                    List<String> strs=new ArrayList<>();
                    for (int i = 0; i < lists.size(); i++) {
                        for (int j = 0; j < lists.get(i).size(); j++) {
                                if ( lists.get(i).get(j).getIsChecked()==0){
                                    strs.add(lists.get(i).get(j).getKey());
                                }
                        }
                    }
                    //得到所有已选中行数
                    List<Integer> integers=new ArrayList<>();
                    for (int i = 0; i < lists.size(); i++) {
                        for (int j = 0; j < lists.get(i).size(); j++) {
                            if (lists.get(i).get(j).getIsChecked()==0){
                                integers.add(i);
                            }
                        }
                    }

                    //开始筛选出有用数据
                List<String[]> list=new ArrayList<>();
                    //若已选中行数为0 就不执行操作了 主要针对反选
                Boolean is=true;
                if (integers.size()==0){
                    is=false;
                }
                //是否有行被选中 有就执行
                if (is) {
                    for (String[] map:listMap){
                        //判断已选行数 能对齐单个筛选选项的条目数量
                        int num=0;
                        for (int i=0;i<map.length;i++){
                            for (String ss : strs) {
                                if (ss.equalsIgnoreCase(map[i])){
                                    num++;
                                }
                            }
                        }
                        if (num==strs.size()){
                            list.add(map);
                        }
                    }
                }
                //选中就执行 无选中就让所有item为可选状态
                if (is) {
                for (int i = 0; i < lists.size(); i++) {
                    //除了已选中的item 其他都为不可选
                        for (int j = 0; j < lists.get(i).size(); j++) {
                            if (lists.get(i).get(j).getIsChecked()!=0){
                                lists.get(i).get(j).setIsChecked(2);
                            }
                        }
                        // 除了已选中的 对应可选设置为可选状态 不在这里设置不可选是因为for循环太多容易失控
                        for (int j = 0; j < lists.get(i).size(); j++) {
                            for (String[] strss : list) {
                                for (int h = 0; h < strss.length; h++) {
                                    if (strss[h].equalsIgnoreCase(lists.get(i).get(j).getKey())) {
                                        if (lists.get(i).get(j).getIsChecked()!=0){
                                            lists.get(i).get(j).setIsChecked(1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    //没有选中的情况下 设置所有为可选状态
                    for (int i = 0; i < lists.size(); i++) {
                        for (int j = 0; j < lists.get(i).size(); j++) {
                            lists.get(i).get(j).setIsChecked(1);
                        }
                    }
                }
                specialUpdate();
            }
        });

    }

    private void specialUpdate() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                //单个条目更新
                // notifyItemChanged(getItemCount() - 1);
                //刷屏
                notifyDataSetChanged();
            }
        };
        handler.post(r);
    }

    public Map<String, String> getValues() {
        values.clear();
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                if (lists.get(i).get(j).getIsChecked()==0){
                   values.put(keys.get(i),lists.get(i).get(j).getKey());
                    Log.i("TAG","key:"+keys.get(i)+"-val:"+lists.get(i).get(j).getKey());
                }
            }
        }
        return values;
    }
}
