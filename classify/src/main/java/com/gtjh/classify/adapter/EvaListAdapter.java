package com.gtjh.classify.adapter;

import android.content.Context;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.EvaBean;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.view.StarBar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by android on 2018/8/1.
 */

public class EvaListAdapter extends CommonAdapter<EvaBean.ReviewListBean> {
    public EvaListAdapter(List<EvaBean.ReviewListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_eva;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, EvaBean.ReviewListBean reviewListBean) {
        TextView title=holder.findViewById(R.id.tv_title);
        TextView date=holder.findViewById(R.id.tv_date);
        StarBar star=holder.findViewById(R.id.sb_star);
        TextView content=holder.findViewById(R.id.tv_content);
        title.setText(reviewListBean.getSummary());
        date.setText(getDateToString(reviewListBean.getReview_date()));

        star.setIntegerMark(true);
        star.setStarMark(Integer.valueOf(reviewListBean.getRate_star()));
        star.setClick(false);

        content.setText(reviewListBean.getReview_content());
    }
    public static String getDateToString(long milSecond) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
