package com.gtjh.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.user.bean.OrderListBean;
import com.gtjh.user.R;

import java.util.List;

/**
 * Created by android on 2018/7/13.
 */

public class OrderAdapter extends CommonAdapter<OrderListBean> {
    private Context mContext;
    private onAgainClickListener onAgainClickListener;
    private onAllClickListener onAllClickListener;
    public OrderAdapter(List<OrderListBean> datas, Context context) {
        super(datas, context);
        this.mContext=context;
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_order;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, final OrderListBean orderListBean) {
        TextView id=holder.findViewById(R.id.tv_order_id);
        TextView state=holder.findViewById(R.id.tv_order_state);
        TextView date=holder.findViewById(R.id.tv_date);
        TextView again=holder.findViewById(R.id.tv_order_again);

        LinearLayout all=holder.findViewById(R.id.ll_all);
        id.setText(orderListBean.getIncrement_id());
        state.setText(orderListBean.getOrder_status());
        date.setText(orderListBean.getCreated_at());

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onAgainClickListener!=null){
                    onAgainClickListener.onAgain(orderListBean.getOrder_id());
                }
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onAllClickListener!=null){
                    onAllClickListener.onAll(orderListBean.getOrder_id());
                }
            }
        });



    }

    public void setOnAgainClickListener(OrderAdapter.onAgainClickListener onAgainClickListener) {
        this.onAgainClickListener = onAgainClickListener;
    }

    public void setOnAllClickListener(OrderAdapter.onAllClickListener onAllClickListener) {
        this.onAllClickListener = onAllClickListener;
    }

    public interface onAgainClickListener{
        void onAgain(String order_id);
    }
    public interface onAllClickListener{
        void onAll(String orderId);
    }
}
