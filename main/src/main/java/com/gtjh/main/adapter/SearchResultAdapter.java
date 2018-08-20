package com.gtjh.main.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.main.R;
import com.gtjh.main.bean.SearchResultListBean;

import java.util.List;

/**
 * Created by android on 2018/7/17.
 */

public class SearchResultAdapter extends CommonAdapter<SearchResultListBean> {
    private onItemClickListener onItemClickListener;
    public SearchResultAdapter(List<SearchResultListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_search_list;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, SearchResultListBean searchResultListBean) {
        ImageView img=holder.findViewById(R.id.iv_img);
        ImageView imgT=holder.findViewById(R.id.iv_img_t);
        RelativeLayout rlOne=holder.findViewById(R.id.rl_one);
        RelativeLayout rlTwo=holder.findViewById(R.id.rl_two);
        TextView title=holder.findViewById(R.id.tv_title);
        TextView titleT=holder.findViewById(R.id.tv_title_t);
        TextView content=holder.findViewById(R.id.tv_content);
        TextView contentT=holder.findViewById(R.id.tv_content_t);
        TextView contentS=holder.findViewById(R.id.tv_content_s);
        TextView contentSP=holder.findViewById(R.id.tv_content_sp);


        final SearchResultListBean.OneBean oneBean=searchResultListBean.getOne();
        final SearchResultListBean.TwoBean twoBean=searchResultListBean.getTwo();
        ImageLoaderPresenter.getInstance().loadRound(context, oneBean.getImage(), img);
        title.setText(oneBean.getName());
        content.setText(oneBean.getPrice().getCode()+"  "+oneBean.getPrice().getSymbol()+" "+oneBean.getPrice().getValue());

        Log.i("TAG",(twoBean==null)+"");//false 写接口的大哥我敬你是个人才

        if (twoBean.getProduct_id()!=null){
            ImageLoaderPresenter.getInstance().loadRound(context, twoBean.getImage(), imgT);
            titleT.setText(twoBean.getName());
            contentT.setText(twoBean.getPrice().getCode()+"  "+twoBean.getPrice().getSymbol()+" "+twoBean.getPrice().getValue());

        }

        //左右的监听
        rlOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItem(oneBean.getProduct_id());
                }
            }
        });
        rlTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItem(twoBean.getProduct_id());
                }
            }
        });
    }

    public void setOnItemClickListener(SearchResultAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItem(String productId);
    }
}
