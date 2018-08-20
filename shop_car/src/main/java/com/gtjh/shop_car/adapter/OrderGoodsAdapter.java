package com.gtjh.shop_car.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.shop_car.R;
import com.gtjh.shop_car.bean.InitOrderBean;
import com.gtjh.shop_car.bean.OrderProductsListBean;

import java.util.List;

/**
 * Created by android on 2018/7/24.
 */

public class OrderGoodsAdapter extends CommonAdapter<OrderProductsListBean> {
    private String symbol="";
    public OrderGoodsAdapter(List<OrderProductsListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_order_goods;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, OrderProductsListBean orderProductsListBean) {
        //图片
        ImageView iv_img=holder.findViewById(R.id.iv_img);
        ImageLoaderPresenter.getInstance().loadRound(context, orderProductsListBean.getImgUrl(), iv_img);
        //内容
        TextView title=holder.findViewById(R.id.tv_title);
        TextView unit=holder.findViewById(R.id.tv_unit);
        TextView price=holder.findViewById(R.id.tv_price);
        TextView number=holder.findViewById(R.id.tv_number);

        title.setText(orderProductsListBean.getName());
        unit.setText(orderProductsListBean.getSku());
        price.setText(symbol+orderProductsListBean.getProduct_price()+"");
        number.setText(context.getResources().getString(R.string.count)+"："+orderProductsListBean.getQty());
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
