package com.gtjh.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.user.R;
import com.gtjh.user.activity.EvaluationActivity;
import com.gtjh.user.bean.OrderDetailsListBean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by android on 2018/7/13.
 */

public class OrderDetailsAdapter extends CommonAdapter<OrderDetailsListBean> {
    private int status=0;
    private Gson gson=new Gson();
    private String symbol="";
    public OrderDetailsAdapter(List<OrderDetailsListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_order_details;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, final OrderDetailsListBean orderDetailsListBean) {
        //图片
        ImageView iv_img=holder.findViewById(R.id.iv_img);
        ImageLoaderPresenter.getInstance().loadRound(context, orderDetailsListBean.imgUrl, iv_img);
        //内容
        TextView title=holder.findViewById(R.id.tv_title);
        TextView unit=holder.findViewById(R.id.tv_unit);
        TextView price=holder.findViewById(R.id.tv_price);
        TextView number=holder.findViewById(R.id.tv_number);
        TextView evaluation=holder.findViewById(R.id.tv_evaluation);

        title.setText(orderDetailsListBean.getName());
        unit.setText(orderDetailsListBean.getSku());
        price.setText(symbol+" "+orderDetailsListBean.getRow_total());
        number.setText(context.getResources().getString(R.string.count)+"："+orderDetailsListBean.getQty());

        if (orderDetailsListBean.getCustom_option_info()!=null){
            String name="";
            Map<String ,Object> stringObjectMap=gson.fromJson(gson.toJson(orderDetailsListBean.getCustom_option_info()),Map.class);
            Iterator<Map.Entry<String,Object>> iterator=stringObjectMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String,Object> entry=iterator.next();
                name+=entry.getKey()+":"+entry.getValue()+" ";
            }
            if (!TextUtils.isEmpty(name)){
                unit.setText(name);
            }
        }
        //评论
        if (status == 0) {
            evaluation.setVisibility(View.VISIBLE);
            evaluation.setEnabled(true);
        }else {
            evaluation.setVisibility(View.GONE);
            evaluation.setEnabled(false);
        }

        evaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, EvaluationActivity.class);
                intent.putExtra("PRODECTID",orderDetailsListBean.getProduct_id());
                context.startActivity(intent);
            }
        });
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setStatus(int status) {
        this.status = status;
        notifyDataSetChanged();
    }
}
