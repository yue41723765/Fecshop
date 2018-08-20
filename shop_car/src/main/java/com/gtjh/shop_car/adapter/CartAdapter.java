package com.gtjh.shop_car.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.shop_car.R;
import com.gtjh.shop_car.bean.ProductsListBean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by android on 2018/7/23.
 */

public class CartAdapter extends CommonAdapter<ProductsListBean> {
    private onLoseClickListener onLoseClickListener;
    private Gson gson=new Gson();
    private String symbol="";
    public CartAdapter(List<ProductsListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_producets;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final ProductsListBean productsListBean) {
        //强制关闭复用
        holder.setIsRecyclable(false);
        CheckBox checkBox=holder.findViewById(R.id.cb_check);
        ImageView ivImg=holder.findViewById(R.id.iv_img);
        TextView title=holder.findViewById(R.id.tv_title);
        TextView desc=holder.findViewById(R.id.tv_desc);
        TextView price=holder.findViewById(R.id.tv_price);
        TextView lose=holder.findViewById(R.id.tv_lose);
        TextView num=holder.findViewById(R.id.tv_num);
        TextView add=holder.findViewById(R.id.tv_add);
        ImageView delete=holder.findViewById(R.id.iv_delete);



        ImageLoaderPresenter.getInstance().loadRound(context, productsListBean.getImg_url(), ivImg);
        title.setText(productsListBean.getName());

        if (TextUtils.isEmpty(productsListBean.getCustom_option_sku())){
            String result=initMap(productsListBean.getSpu_options());
            desc.setText(result);
        }else {
            String dsc=initMap(productsListBean.getCustom_option_info());
            desc.setText(dsc);
        }

        price.setText(symbol+productsListBean.getProduct_price());
        num.setText(((int) productsListBean.getQty())+"");




        if (productsListBean.getActive()==1){
            checkBox.setChecked(true);
        }else {
            checkBox.setChecked(false);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (onLoseClickListener!=null){
                    onLoseClickListener.onCheck(position,productsListBean.getItem_id(),isChecked);
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLoseClickListener!=null){
                    onLoseClickListener.onAdd(position,productsListBean.getItem_id());
                }
            }
        });
        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLoseClickListener!=null){
                    onLoseClickListener.onLose(position,productsListBean.getItem_id());
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLoseClickListener!=null){
                    onLoseClickListener.onDelete(position,productsListBean.getItem_id());
                }
            }
        });
        setLinster(new OnItemClickLinster() {
            @Override
            public void onItemClick(int position, View view) {
                if (onLoseClickListener!=null){
                    onLoseClickListener.onItem(position,productsListBean.getProduct_id());
                }
            }
        });
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    private String initMap(Object spu_options) {
        String result="";
        Map<String,String> stringMap=gson.fromJson(gson.toJson(spu_options),Map.class);
        Set<Map.Entry<String, String>> entry=stringMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator=entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> map=iterator.next();
            String key=map.getKey();
            String value=map.getValue();
            result+=(key+":"+value+"   ");
        }
        return result;
    }

    public void setOnLoseClickListener(CartAdapter.onLoseClickListener onLoseClickListener) {
        this.onLoseClickListener = onLoseClickListener;
    }

    public interface onLoseClickListener{
        void onLose(int pos,double id);
        void onAdd(int pos,double id);
        void onDelete(int pos,double id);
        void onCheck(int pos,double id,Boolean isCheck);
        void onItem(int pos,String id);
    }
}
