package com.gtjh.fecshop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.view.ViewHelp;

import java.util.ArrayList;

import butterknife.BindView;

import static com.scwang.smartrefresh.layout.util.DensityUtil.dp2px;

/**
 * Created by android on 2018/8/7.
 */

public class GuideActivity extends BaseActivity {
    @BindView(R.id.vp_guide)
    ViewPager vp_guide_bg;
    @BindView(R.id.tv_go)
    TextView tvGo;
    @BindView(R.id.ll_guide_points)
    LinearLayout ll_guide_points;
    @BindView(R.id.iv_red_point)
    ImageView iv_guide_redPoint;
    private ArrayList<ImageView> images;
    int touchCount;
    int currentItem;
    @Override
    public void showSuccess(Object o, int tag) {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        initTopBar();

        // 准备数据
        initData();
        // 设置Adapter
        vp_guide_bg.setAdapter(new MyAdapter());

        // 监听ViewPager的滚动事件
        vp_guide_bg.addOnPageChangeListener(new MyOnPageChangeListener());

        initEvent();
    }

    private void initEvent() {
        vp_guide_bg.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float startY;
            float endX;
            float endY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX=event.getX();
                        startY=event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX=event.getX();
                        endY=event.getY();
                        WindowManager windowManager= (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                        //获取屏幕的宽度
                        Point size = new Point();
                        windowManager.getDefaultDisplay().getSize(size);
                        int width=size.x;
                        //首先要确定的是，是否到了最后一页，然后判断是否向左滑动，并且滑动距离是否符合，我这里的判断距离是屏幕宽度的4分之一（这里可以适当控制）
                        if(currentItem==(images.size()-1)&&startX-endX>0&&startX-endX>=(width/4)){
                            goToMainActivity();
                            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                        }
                        break;
                }
                return false;
            }
        });
    }

    private void goToMainActivity() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        SPUtil.saveIsFirst(this,false);
        finish();
    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {

            // positionOffset 手指在ViewPager上移动的与屏幕宽度的比例
            // 红点移动的距离 = positionOffset * 灰点的间距
            int redPointX = (int) ((positionOffset + position) * dp2px(20));
            // 让红点移动,修改红点的leftMargin
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) iv_guide_redPoint
                    .getLayoutParams();
            layoutParams.leftMargin = redPointX;
            iv_guide_redPoint.setLayoutParams(layoutParams);
        }

        @Override
        public void onPageSelected(int position) {
            // 当选中某一页时回调
           /* if(position==images.size()-1){
                tvGo.setVisibility(View.VISIBLE);
            }else{
                tvGo.setVisibility(View.INVISIBLE);
            }*/
            currentItem = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }


    }

    private void initData() {
        int[] imgIds = new int[] { R.drawable.one,
                R.drawable.two,
                R.drawable.three
                // ,R.drawable.guide_4
        };
        // 给ViewPager准备图片数据
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imgIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            // imageView.setImageResource(imgIds[i]);
            imageView.setImageResource(imgIds[i]);
            images.add(imageView);

            // 添加灰点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.green_mint_point);
            int dp2px = dp2px(3);
            int wdp2px = dp2px(12);
            int left = dp2px(10);
            // 设置宽高
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(wdp2px, dp2px);
            // 设置边距
            if (i != 0) {
                params.leftMargin = left;
            }
            point.setLayoutParams(params);
            ll_guide_points.addView(point);
        }
    }

    public int dp2px(int dp){
        // px = dp * 密度比 0.75 、1、 1.5、 2
        float density = getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5f);
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(images.get(position));
            return images.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
    protected void initTopBar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //ViewHelp.getInstance().setTopPadding(getWindow().getDecorView(),getStatusBarHeight());
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }
}
