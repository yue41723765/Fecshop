package com.gtjh.classify.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.classify.R;
import com.gtjh.classify.adapter.CategoryAdapter;
import com.gtjh.classify.adapter.FiltrateAdapter;
import com.gtjh.classify.adapter.FiltrateItemAdapter;
import com.gtjh.classify.bean.CategoryMapBean;
import com.gtjh.classify.bean.ClassifyBean;
import com.gtjh.classify.bean.ClassifyPageBean;
import com.gtjh.classify.bean.FilterInfoListBean;
import com.gtjh.classify.bean.FilterItemsBean;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by android on 2018/7/19.
 */

public class ClassifyFilterDialog extends Dialog {
    private NestedScrollView scroll;
    private LinearLayout llAll;
    private ImageView ivClose;
    private EditText tvAll;
    private TextView tvClear;
    private RecyclerView lvData;
    private TextView tvSubmit;
    private TextView tvPrice;
    private TagFlowLayout tfPrice;
    private RelativeLayout rlPrice;
    private TextView tvSort;
    private TagFlowLayout tfSort;
    private RelativeLayout rlSort;
    private TextView tvCategory;
    private TagFlowLayout tfCategory;
    private RelativeLayout rlCategory;

    private Gson gson=new Gson();
    private Context mContext;
    private onFiltrateClickListener onFiltrateClickListener;
    private ClassifyBean data;

    private FiltrateAdapter adapter; //类型列表
    private List<FilterInfoListBean> listBeans=new ArrayList<>();

    private FiltrateItemAdapter priceAdapter; //价格列表
    private List<FilterItemsBean> beanList=new ArrayList<>(); // string[0]

    private FiltrateItemAdapter sortAdapter; //价格列表
    private List<FilterItemsBean> sortBeanList=new ArrayList<>(); // string[1]

    private CategoryAdapter categoryAdapter;
    private List<CategoryMapBean>  categoryBean=new ArrayList<>();
    private String[] strings; //选中的所有文字
    private Map<String,String> stringMap=new HashMap<>(); //要传递的所有类型集合

    private String priceT="";//要传递的价格字段
    private String categoryT="";//要传递的分类
    private String sortT="";//要传递的排序

    private int itemNum=3;
    public ClassifyFilterDialog(Context context, ClassifyBean data){
        super(context,R.style.dialog);
        this.mContext=context;
        this.data=data;
    }

    public ClassifyFilterDialog(@NonNull Context context) {
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
        setContentView(R.layout.dialog_filtrate);
        setCanceledOnTouchOutside(false);

        Window window=getWindow();
        window.setWindowAnimations(R.style.DialogOutAndInStyle);

        initData();
        initView();
        initInfo();
        initEvent();
        scroll.smoothScrollTo(0,0);
    }

    private void initEvent() {
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //确定筛选
                if (onFiltrateClickListener!=null){
                    onFiltrateClickListener.onFiltrate(priceT,sortT,categoryT,stringMap);
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
        adapter.setOnInfoClickListener(new FiltrateAdapter.onInfoClickListener() {
            @Override
            public void onInfo(FilterInfoListBean bean, int pos, int itemPos, Boolean isCheck) {
                if (isCheck){
                    strings[itemPos+itemNum]=bean.getItems().get(pos).get_id();
                    stringMap.put(bean.getVal(),bean.getItems().get(pos).get_id());
                }else {
                    stringMap.remove(bean.getVal());
                    strings[itemPos+itemNum]=null;
                }
                initAll(true);
            }
        });
        priceAdapter.setOnCheckedClickListener(new FiltrateItemAdapter.onCheckedClickListener() {
            @Override
            public void onChecked(int pos, Boolean isCheck,View view) {
                if (isCheck){
                    strings[0]=beanList.get(pos).getLabel();
                    priceT=beanList.get(pos).getVal();
                }else {
                    priceT="";
                    strings[0]=null;
                }
                initAll(true);
            }
        });
        sortAdapter.setOnCheckedClickListener(new FiltrateItemAdapter.onCheckedClickListener() {
            @Override
            public void onChecked(int pos, Boolean isCheck,View view) {
                if (isCheck){
                    strings[1]=sortBeanList.get(pos).getLabel();
                    sortT=sortBeanList.get(pos).getValue();
                }else {
                    sortT="";
                    strings[1]=null;
                }
                initAll(true);
            }
        });
        categoryAdapter.setOnInfoClickListener(new CategoryAdapter.onInfoClickListener() {
            @Override
            public void onFInfo(int pos, Boolean isCheck) {
                if (isCheck){
                    strings[2]=categoryBean.get(pos).getName();
                    categoryT=categoryBean.get(pos).getParent_id();
                }else {
                    categoryT="";
                    strings[2]=null;
                }
                initAll(true);
            }
        });
    }



    private void initInfo() {
        adapter=new FiltrateAdapter(listBeans,mContext);
        lvData.setLayoutManager(new LinearLayoutManager(mContext));
        lvData.setAdapter(adapter);

        //价格 为了防止监听空指针
        priceAdapter=new FiltrateItemAdapter(beanList,mContext);
        if (beanList!=null&&beanList.size()>0){
            tfPrice.setAdapter(priceAdapter);
            rlPrice.setVisibility(View.VISIBLE);
        }else {
            rlPrice.setVisibility(View.GONE);
        }

        //排序
        sortAdapter=new FiltrateItemAdapter(sortBeanList,mContext);
        if (sortBeanList!=null&&sortBeanList.size()>0){
            tfSort.setAdapter(sortAdapter);
            rlSort.setVisibility(View.VISIBLE);
        }else {
            rlSort.setVisibility(View.GONE);
        }
        //分类
        categoryAdapter=new CategoryAdapter(categoryBean,mContext);
        if (categoryBean!=null&&categoryBean.size()>0){
            tfCategory.setAdapter(categoryAdapter);
            rlCategory.setVisibility(View.VISIBLE);
        }else {
            rlCategory.setVisibility(View.GONE);
        }

    }

    private void initData() {
        //商品细节
        Map<String,Object> arr= gson.fromJson(gson.toJson(data.getFilter_info()), Map.class);
        Iterator<Map.Entry<String,Object>> iterator=arr.entrySet().iterator();
        List<Object> objectList=new ArrayList<>();
        List<String> nameList=new ArrayList<>();
        while (iterator.hasNext()){
            Map.Entry<String,Object> entry=iterator.next();
            objectList.add(entry.getValue());
            nameList.add(entry.getKey());
        }
        for (int i=0;i< objectList.size();i++){
            FilterInfoListBean infoBean=gson.fromJson(gson.toJson(objectList.get(i)),FilterInfoListBean.class);
            infoBean.setVal(nameList.get(i));
            listBeans.add(infoBean);
        }
        //all
        strings=new String[listBeans.size()+itemNum];

        //价格
        beanList=data.getFilter_price().getPrice();
        //排序
        sortBeanList=data.getQuery_item().getFrontSort();
        //产品分类
        Map<String,Object> objectMap=gson.fromJson(gson.toJson(data.getFilter_category()),Map.class);
        Iterator<Map.Entry<String,Object>> iteratorMap=objectMap.entrySet().iterator();
        List<Object> objects=new ArrayList<>();
        while (iterator.hasNext()){
            objects.add(iteratorMap.next().getValue());
        }
        for (int i=0;i< objects.size();i++){
            CategoryMapBean infoBean=gson.fromJson(gson.toJson(objects.get(i)),CategoryMapBean.class);
            categoryBean.add(infoBean);
        }
    }

    private void initView() {
        ivClose=findViewById(R.id.iv_close);
        tvAll=findViewById(R.id.tv_all);
        tvClear=findViewById(R.id.tv_clear);
        lvData=findViewById(R.id.rv_data);
        tvSubmit=findViewById(R.id.tv_submit);
        tvPrice=findViewById(R.id.tv_title);
        tfPrice=findViewById(R.id.fl_data);
        rlPrice=findViewById(R.id.rl_price);
        tvSort=findViewById(R.id.tv_title_sort);
        tfSort=findViewById(R.id.fl_data_sort);
        rlSort=findViewById(R.id.rl_sort);
        tvCategory=findViewById(R.id.tv_title_category);
        tfCategory=findViewById(R.id.fl_data_category);
        rlCategory=findViewById(R.id.rl_category);
        scroll=findViewById(R.id.scroll);
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
                        if (allT!=null&&!"".equals(allT)){
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
            if (sortAdapter!=null) {
                sortAdapter.unSelected(0, tfSort);
                sortAdapter.notifyDataChanged();
            }
            if (priceAdapter!=null) {
                priceAdapter.unSelected(0, tfPrice);
                priceAdapter.notifyDataChanged();
            }
            if (categoryAdapter!=null){
                categoryAdapter.unSelected(0,tfCategory);
                categoryAdapter.notifyDataChanged();
            }
            adapter.notifyDataSetChanged();
            tvAll.setText("");
            priceT="";//要传递的价格字段
            categoryT="";//要传递的分类
            sortT="";//要传递的排序
            stringMap.clear();

        }
    }

    public void setOnFiltrateClickListener(onFiltrateClickListener onFiltrateClickListener) {
        this.onFiltrateClickListener = onFiltrateClickListener;
    }

    public interface onFiltrateClickListener{
        void onFiltrate(String price,String sort,String category,Map<String ,String> filterAttrs);
    }
}
