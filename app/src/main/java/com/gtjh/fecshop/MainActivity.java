package com.gtjh.fecshop;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.gtjh.classify.ClassifyFragment;
import com.gtjh.common.BaseActivity;
import com.gtjh.common.GTJHApplication;
import com.gtjh.common.util.view.ViewHelp;
import com.gtjh.fecshop.util.FragmentHelp;
import com.gtjh.main.MainFragment;
import com.gtjh.shop_car.ShopCarFragment;
import com.gtjh.user.UserFragment;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.ll_bottom)
    public LinearLayout ll_bottom;
    public String[] texts = {GTJHApplication.getApplication().language.home, GTJHApplication.getApplication().language.commodityCategories, GTJHApplication.getApplication().language.shopCar,GTJHApplication.getApplication().language.my};
    private int[] defaultIds = {R.drawable.main_default, R.drawable.classify_default, R.drawable.car_default, R.drawable.user_default};
    private int[] selectIds = {R.drawable.main_select, R.drawable.classify_select, R.drawable.car_select, R.drawable.user_select};
    private FragmentHelp fh;
    private Fragment[] fragments = new Fragment[4];
    private View currentSelectView;
    private int defaultColor = Color.parseColor("#B5B5B5");
    private int selectColor = Color.parseColor("#353E47");

    @Override
    public void init(Bundle savedInstanceState) {
        initData();
        initBottom();
    }

    private void initData() {
        fh = new FragmentHelp(getSupportFragmentManager());
        fragments[0] = new MainFragment();
        fragments[1] = new ClassifyFragment();
        fragments[2] = new ShopCarFragment();
        fragments[3] = new UserFragment();
    }

    private void initBottom() {
        for (int i = 0; i < texts.length; i++) {
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight = 1;
            textView.setLayoutParams(layoutParams);
            textView.setText(texts[i]);
            textView.setGravity(Gravity.CENTER);

            textView.setTextSize(20);
            if (i > 0) {
                textView.setTextColor(defaultColor);
                ViewHelp.getInstance().setImgForViewTop(textView, getResources().getDrawable(defaultIds[i]));
            } else {
                currentSelectView = textView;
                textView.setTextColor(selectColor);
            }
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 24);
            textView.setCompoundDrawablePadding(10);
            textView.setId(i);
            textView.setOnClickListener(this);
            AutoUtils.auto(textView);
            ll_bottom.addView(textView);
        }
        fh.add(fragments[0], R.id.fl_content, "main");
        ViewHelp.getInstance().setImgForViewTop(currentSelectView, getResources().getDrawable(selectIds[currentSelectView.getId()]));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {
        switchViewById(v.getId());
    }

    public void switchViewById(int id) {
        switch (id) {
            case 0:
                fh.add(fragments[id], R.id.fl_content, "main");
                break;
            case 1:
                fh.add(fragments[id], R.id.fl_content, "classify");

                break;
            case 2:
                fh.add(fragments[id],R.id.fl_content,"shopCar");
                break;
            case 3:
                fh.add(fragments[id], R.id.fl_content, "user");
                break;
        }
        ViewHelp.getInstance().setImgForViewTop(currentSelectView, getResources().getDrawable(defaultIds[currentSelectView.getId()])); //清除上一个view图片
        ViewHelp.getInstance().setImgForViewTop(ll_bottom.getChildAt(id), getResources().getDrawable(selectIds[id]));//选中图片
        ((TextView) currentSelectView).setTextColor(defaultColor);
        ((TextView) ll_bottom.getChildAt(id)).setTextColor(selectColor);
        currentSelectView = ll_bottom.getChildAt(id);
    }

    @Override
    public void showSuccess(Object o, int tag) {

    }

    @Override
    public void showError(Throwable throwable) {

    }
}
