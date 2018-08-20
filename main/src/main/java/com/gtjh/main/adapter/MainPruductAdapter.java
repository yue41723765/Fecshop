package com.gtjh.main.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.entity.Price;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.main.R;
import com.gtjh.main.model.entity.Main;

import java.util.List;

/**
 * Created by android on 2018/7/4.
 */

public class MainPruductAdapter extends CommonAdapter<Main.Product.ProductChild> {
    private OnItemClickListener onItemClickListener;
    public MainPruductAdapter(List<Main.Product.ProductChild> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_product;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final Main.Product.ProductChild productChild) {
        ImageView imageView = holder.findViewById(R.id.iv_img);
        TextView tv_name = holder.findViewById(R.id.tv_name);
        TextView tv_price = holder.findViewById(R.id.tv_price);

        ImageLoaderPresenter.getInstance().displayImage(context, productChild.getImage(), imageView);
        tv_name.setText(productChild.getName());
        Price currentPrice = productChild.getPrice();
        tv_price.setText(currentPrice.getCode() + "  " + currentPrice.getSymbol() + currentPrice.getValue());

        TextView tv_old_price = holder.findViewById(R.id.old_price);
        Price oldPrice = productChild.getSpecial_price();
        if (oldPrice != null) {
            tv_old_price.setText(oldPrice.getCode() + "  " + oldPrice.getSymbol() + oldPrice.getValue());
            tv_old_price.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        }
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItem(position,productChild.getProduct_id());
                }
            }
        });
    }

    public void setOnItemListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onItem(int position,String id);
    }

}
