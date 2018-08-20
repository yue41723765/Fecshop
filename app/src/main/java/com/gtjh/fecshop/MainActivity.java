package com.gtjh.fecshop;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;


import com.gtjh.classify.ClassifyFragment;
import com.gtjh.common.BaseActivity;
import com.gtjh.common.GTJHApplication;
import com.gtjh.common.event.AddressEvent;
import com.gtjh.common.event.IsClassifyEvent;
import com.gtjh.common.net.Rx.databus.RegisterRxBus;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.util.view.ViewHelp;
import com.gtjh.fecshop.util.FragmentHelp;
import com.gtjh.main.MainFragment;
import com.gtjh.router_annotation.Extra;
import com.gtjh.router_annotation.Route;
import com.gtjh.shop_car.ShopCarFragment;
import com.gtjh.user.LoginActivity;
import com.gtjh.user.RegisterActivity;
import com.gtjh.user.UserFragment;
import com.zhy.autolayout.utils.AutoUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

@Route(path = "/fecshop/MainActivity")
public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.ll_bottom)
    public LinearLayout ll_bottom;
    @BindView(R.id.rg_bottom_nav)
    RadioGroup rgBottomNav;

    @BindView(R.id.rb_shoppingcar)
    RadioButton rbShoppingCar;
    @BindView(R.id.rb_home)
    RadioButton rbhome;
    @BindView(R.id.rb_classify)
    RadioButton rbClassify;
    @BindView(R.id.rb_me)
    RadioButton rbMe;
    @Extra(name = "CHECKED")
    public String check;


    private FragmentManager fragmentManager;
    private Fragment f1, f2, f3, f4;
    private long exitTime = 0;


    public String[] texts = {GTJHApplication.getApplication().language.home, GTJHApplication.getApplication().language.commodityCategories, GTJHApplication.getApplication().language.shopCar,GTJHApplication.getApplication().language.my};    private int[] defaultIds = {R.drawable.main_default, R.drawable.classify_default, R.drawable.car_default, R.drawable.user_default};
    private int[] selectIds = {R.drawable.main_select, R.drawable.classify_select, R.drawable.car_select, R.drawable.user_select};
    private FragmentHelp fh;
    private Fragment[] fragments = new Fragment[4];
    private View currentSelectView;
    private View classifyView;
    private int defaultColor = Color.parseColor("#B5B5B5");
    private int selectColor = Color.parseColor("#353E47");

    @Override
    public void init(Bundle savedInstanceState) {
        RxBus.getInstance().register(this);
        changeImageSize();
        initView();
        //initData();
        //initBottom();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            fragmentManager = getSupportFragmentManager();
            f1 = (MainFragment) fragmentManager.findFragmentByTag("home");
            f2 = (ClassifyFragment) fragmentManager.findFragmentByTag("category");
            f3 = (ShopCarFragment) fragmentManager.findFragmentByTag("Shop");
            f4 = (UserFragment) fragmentManager.findFragmentByTag("mine");
        }
        super.onCreate(savedInstanceState);
    }

    private void changeImageSize() {
        //定义底部标签图片大小
        Drawable drawableFirst = getResources().getDrawable(R.drawable.selector_tab_home);
        drawableFirst.setBounds(0, 0, 48, 44);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        rbhome.setCompoundDrawables(null, drawableFirst, null, null);//只放上面

        Drawable drawableSearch = getResources().getDrawable(R.drawable.selector_tab_shop);
        drawableSearch.setBounds(0, 0, 48, 44);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        rbClassify.setCompoundDrawables(null, drawableSearch, null, null);//只放上面

        Drawable drawableMe = getResources().getDrawable(R.drawable.selector_tab_me);
        drawableMe.setBounds(0, 0, 44, 44);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        rbMe.setCompoundDrawables(null, drawableMe, null, null);//只放上面

        Drawable drawableCart = getResources().getDrawable(R.drawable.selector_tab_houses);
        drawableCart.setBounds(0, 0, 48, 44);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        rbShoppingCar.setCompoundDrawables(null, drawableCart, null, null);//只放上面

    }
    private void initView() {
        rgBottomNav.setOnCheckedChangeListener(this);
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        if (f1 == null) {
            f1 = new MainFragment();//首页
            fragmentManager.beginTransaction().add(R.id.fl_content, f1, "home").commit();
        } else {
            hideAllFragment(fragmentManager.beginTransaction());
            fragmentManager.beginTransaction().show(f1);
        }
        if ("2".equals(check)){
            rgBottomNav.check(R.id.rb_shoppingcar);
        }else if ("3".equals(check)){
            rgBottomNav.check(R.id.rb_classify);
        }
    }
    /**
     * 隐藏所有Fragment
     *
     * @param transaction
     */
    public void hideAllFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
        }
        if (f2 != null) {
            transaction.hide(f2);
        }
        if (f3 != null) {
            transaction.hide(f3);
        }
        if (f4 != null) {
            transaction.hide(f4);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (checkedId) {
            //首页
            case R.id.rb_home:
                fragmentTransaction.show(f1);
                break;
            //分类
            case R.id.rb_classify:
                if (f2 == null) {
                    f2 = new ClassifyFragment();
                    fragmentTransaction.add(R.id.fl_content, f2, "category");
                } else {
                    fragmentTransaction.show(f2);
                }

                break;
            //购物车
            case R.id.rb_shoppingcar:
                if (f3 == null) {
                    f3 = new ShopCarFragment();
                    fragmentTransaction.add(R.id.fl_content, f3, "Shop");
                } else {
                    fragmentTransaction.show(f3);
                }

                break;
            //我的
            case R.id.rb_me:
                if (f4 == null) {
                    f4 = new UserFragment();
                    fragmentTransaction.add(R.id.fl_content, f4, "mine");
                } else {
                    fragmentTransaction.show(f4);
                }

                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (f1 == null && fragment instanceof MainFragment)
            f1 = fragment;
        if (f2 == null && fragment instanceof ClassifyFragment)
            f2 = fragment;
        if (f3 == null && fragment instanceof ShopCarFragment)
            f3 = fragment;
        if (f4 == null && fragment instanceof UserFragment)
            f4 = fragment;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if ("2" .equals( intent.getStringExtra("CHECKED")) ){
            rgBottomNav.check(R.id.rb_shoppingcar);
        }else
        if ("3".equals( intent.getStringExtra("CHECKED")) ){
            rgBottomNav.check(R.id.rb_classify);
        }
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
                ViewHelp.getInstance().setImgForViewTop(textView, getResources().getDrawable(defaultIds[i]),44,40);
                if (i==1){
                    classifyView= textView;
                }
            } else {
                currentSelectView = textView;
                textView.setTextColor(selectColor);
            }
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 20);
            textView.setCompoundDrawablePadding(9);
            textView.setId(i);
            textView.setOnClickListener(this);
            AutoUtils.auto(textView);
            ll_bottom.addView(textView);
        }
        fh.add(fragments[0], R.id.fl_content, "main");
        ViewHelp.getInstance().setImgForViewTop(currentSelectView, getResources().getDrawable(selectIds[currentSelectView.getId()]),44,40);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
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
        ViewHelp.getInstance().setImgForViewTop(currentSelectView, getResources().getDrawable(defaultIds[currentSelectView.getId()]),44,40); //清除上一个view图片
        ViewHelp.getInstance().setImgForViewTop(ll_bottom.getChildAt(id), getResources().getDrawable(selectIds[id]),44,40);//选中图片
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                ToastUtils.showToastForText(getApplicationContext(), getResources().getString(R.string.againClick));
                exitTime = System.currentTimeMillis();
            } else {
                // finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }


}
