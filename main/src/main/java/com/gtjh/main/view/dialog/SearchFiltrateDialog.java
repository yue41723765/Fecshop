package com.gtjh.main.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.main.R;
import com.gtjh.main.adapter.SearchFiltrateAdapter;
import com.gtjh.main.adapter.SearchFiltrateItemAdapter;
import com.gtjh.main.bean.FilterInfoBean;
import com.gtjh.main.bean.SearchFiltrateBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by android on 2018/7/18.
 *  筛选 -bug为 清除-不能清除选中状态
 */

public class SearchFiltrateDialog extends Dialog {
    private ImageView ivClose;
    private EditText tvAll;
    private TextView tvClear;
    private RecyclerView lvData;
    private TextView tvSubmit;
    private TextView tvPrice;
    private TagFlowLayout tfPrice;
    private LinearLayout llAll;

    private Gson gson=new Gson();
    private Context mContext;
    private onFiltrateClickListener onFiltrateClickListener;
    private SearchFiltrateBean data;

    private SearchFiltrateAdapter adapter; //类型列表
    private List<FilterInfoBean> listBeans=new ArrayList<>();
    private SearchFiltrateItemAdapter priceAdapter; //价格列表
    private List<SearchFiltrateBean.FilterPriceBean.PriceBean> beanList=new ArrayList<>();

    private String[] strings; //选中的所有文字
    private Map<String,String> stringMap=new HashMap<>(); //要传递的所有类型集合

    private int pricePos=-1; //钱的位置
    private String priceT="";//要传递的价格字段
     public SearchFiltrateDialog(Context context, SearchFiltrateBean data){
        super(context,R.style.dialog);
        this.mContext=context;
        this.data=data;
    }

    public SearchFiltrateDialog(@NonNull Context context) {
        super(context,R.style.dialog);
    }

    @Override
    public void show() {
        super.show();
        /**
         * 设置宽度全屏，要设置在show的后面
         */
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;

        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        getWindow().setAttributes(layoutParams);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_search_filtrate);
        setCanceledOnTouchOutside(false);

        Window window=getWindow();
        window.setWindowAnimations(R.style.DialogOutAndInStyle);

        initData();
        initView();
        initInfo();
        initEvent();
    }

    private void initEvent() {
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确定筛选
                if (onFiltrateClickListener!=null){
                    onFiltrateClickListener.onFiltrate(priceT,stringMap);
                }
                dismiss();
            }
        });
        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清除
                initAll(false);
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭
                dismiss();
            }
        });
        adapter.setOnInfoClickListener(new SearchFiltrateAdapter.onInfoClickListener() {
            @Override
            public void onInfo(FilterInfoBean bean, int pos,int itemPos,Boolean isCheck) {
                if (isCheck){
                    strings[itemPos+1]=bean.getItems().get(pos).get_id();
                    stringMap.put(bean.getLabel(),bean.getItems().get(pos).get_id());
                }else {
                    stringMap.remove(bean.getLabel());
                    strings[itemPos+1]=null;
                }
                initAll(true);
            }
        });
        priceAdapter.setOnCheckedClickListener(new SearchFiltrateItemAdapter.onCheckedClickListener() {
            @Override
            public void onChecked(int pos, Boolean isCheck,View view) {
                if (isCheck){
                    strings[0]=beanList.get(pos).getLabel();
                    pricePos=pos;
                    priceT=beanList.get(pos).getVal();
                }else {
                    priceT="";
                    pricePos=-1;
                    strings[0]=null;
                }
                initAll(true);
            }
        });
    }



    private void initInfo() {
        adapter=new SearchFiltrateAdapter(listBeans,mContext);
        lvData.setLayoutManager(new LinearLayoutManager(mContext));
        lvData.setAdapter(adapter);

        if (beanList!=null&&beanList.size()>0){
            priceAdapter=new SearchFiltrateItemAdapter(mContext,beanList);
            tfPrice.setAdapter(priceAdapter);
        }else {
            tvPrice.setVisibility(View.GONE);
        }

    }

    private void initData() {
        Map<String,Object> arr= gson.fromJson(gson.toJson(data.getFilter_info()), Map.class);
        Iterator<Map.Entry<String,Object>> iterator=arr.entrySet().iterator();
        List<Object> objectList=new ArrayList<>();
        while (iterator.hasNext()){
            objectList.add(iterator.next().getValue());
        }
        for (int i=0;i< objectList.size();i++){
            FilterInfoBean infoBean=gson.fromJson(gson.toJson(objectList.get(i)),FilterInfoBean.class);
            listBeans.add(infoBean);
        }
        strings=new String[listBeans.size()+1];

        beanList=data.getFilter_price().getPrice();
    }

    private void initView() {
          ivClose=findViewById(R.id.iv_close);
          tvAll=findViewById(R.id.tv_all);
          tvClear=findViewById(R.id.tv_clear);
          lvData=findViewById(R.id.rv_data);
          tvSubmit=findViewById(R.id.tv_submit);
         tvPrice=findViewById(R.id.tv_title);
         tfPrice=findViewById(R.id.fl_data);
        llAll=findViewById(R.id.ll_all);

    }
    private void initAll(Boolean isSet) {
         if (isSet){
             tvClear.setEnabled(true);
             tvClear.setVisibility(View.VISIBLE);
             String allT="";
             for (int i=0;i<strings.length;i++){
                 if (strings[i]!=null){
                     if (i==0){
                         allT+=strings[i];
                     }else {
                         if (strings[i-1]!=null){
                             allT+="/"+strings[i];
                         }else {
                             allT+=strings[i];
                         }
                     }
                 }
             }
             if (allT!=null&&!"".equals(allT)){
                 llAll.setVisibility(View.VISIBLE);
             }else {
                 llAll.setVisibility(View.GONE);
             }
             tvAll.setText(allT);
         }else {
             llAll.setVisibility(View.GONE);
             tvClear.setVisibility(View.GONE);
             tvClear.setEnabled(false);
             for (int i=0;i<strings.length;i++){
                 strings[i]=null;
             }
             if (pricePos!=-1){
                 Set<Integer> integers=new HashSet<>();
                 integers.add(-1);
                 /*priceAdapter.setSelectedList(integers);
                 adapter.setSelectorPos(-1);*/
             }
             priceT="";
             stringMap.clear();
             tvAll.setText("");
         }
    }

    public void setOnFiltrateClickListener(SearchFiltrateDialog.onFiltrateClickListener onFiltrateClickListener) {
        this.onFiltrateClickListener = onFiltrateClickListener;
    }

    public interface onFiltrateClickListener{
         void onFiltrate(String price,Map<String ,String> filterAttrs);
    }
}
