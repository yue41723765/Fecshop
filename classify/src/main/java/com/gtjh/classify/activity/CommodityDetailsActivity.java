package com.gtjh.classify.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.gtjh.classify.R;
import com.gtjh.classify.R2;
import com.gtjh.classify.adapter.CustomOptionAdapter;
import com.gtjh.classify.adapter.DescAdapter;
import com.gtjh.classify.adapter.DetailsPagerAdapter;
import com.gtjh.classify.adapter.ItemOptionAdapter;
import com.gtjh.classify.adapter.OptionAdapter;
import com.gtjh.classify.bean.CustomOptionBean;
import com.gtjh.classify.bean.CustomOptionListBean;
import com.gtjh.classify.bean.CustomOptionsItemBean;
import com.gtjh.classify.bean.DetailsBean;
import com.gtjh.classify.dialog.BannerImageLoader;
import com.gtjh.classify.fragment.DescFragment;
import com.gtjh.classify.fragment.EvaFragment;
import com.gtjh.classify.fragment.PayFragment;
import com.gtjh.classify.presenter.impl.ClassifyPresenterImpl;
import com.gtjh.common.BaseActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.event.IsClassifyEvent;
import com.gtjh.common.image.glide.GlideImageLoader;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.common.util.view.ViewHelp;
import com.gtjh.common.view.CustomLinearLayoutManager;
import com.gtjh.common.view.CustomViewPager;
import com.gtjh.common.view.FiniDialog;
import com.gtjh.common.view.MyScrollView;
import com.gtjh.common.view.StarBar;
import com.gtjh.router_annotation.Extra;
import com.gtjh.router_annotation.Route;
import com.gtjh.router_core.GTJHRouter;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by android on 2018/7/20.
 * viewpager的问题导致的一个未知问题 所以只能先规避
 */
@Route(path = "/classify/CommodityDetailsActivity")
public class CommodityDetailsActivity  extends BaseActivity {
    @BindView(R2.id.banner)
    Banner banner;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tv_code)
    TextView tvCode;
    @BindView(R2.id.rb_star)
    StarBar rbStar;
    @BindView(R2.id.tv_eva)
    TextView tvEva;
    @BindView(R2.id.tv_price)
    TextView tvPrice;
    @BindView(R2.id.tv_price_message)
    TextView tvPriceMsg;
    @BindView(R2.id.rv_data)
    RecyclerView rvData;
    @BindView(R2.id.tv_lose)
    TextView tvLess;
    @BindView(R2.id.rv_num)
    TextView tvNum;
    @BindView(R2.id.tv_add)
    TextView tvAdd;
    @BindView(R2.id.tl_title)
    TabLayout tlTitle;
    @BindView(R2.id.fragment)
    CustomViewPager viewPager;
    @BindView(R2.id.cb_collect)
    RelativeLayout cbCollect;
    @BindView(R2.id.tv_car)
    TextView tvCar;
    @BindView(R2.id.nsv_scroll)
    NestedScrollView scroll;
    @BindView(R2.id.ll_top)
    RelativeLayout ll_top;
    @BindView(R2.id.iv_back)
    ImageView ivBack;
    @BindView(R2.id.iv_collect)
    ImageView ivCollect;
    @BindView(R2.id.iv_bag)
    ImageView ivBag;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @Extra(name = "PRODUCETID")
    public String id;




    private String[] mTitles=new String[]{"产品描述","评论","货运&支付"};
    private List<Fragment> fragmentList=new ArrayList<>();
    private ClassifyPresenterImpl presenter;
    private HashMap<String,Object> hashMap=new HashMap<>();
    private Gson gson=new Gson();
    private boolean isCollect=false;

    private PayFragment payFragment;
    private DescFragment descFragment;
    private EvaFragment evaFragment;
    private DetailsPagerAdapter adapter;

    private OptionAdapter optionAdapter;
    private CustomOptionAdapter customOptionAdapter;
    private Boolean isOptions=true;
    private int customSize=0;
    private FiniDialog dialog;
    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.DETAILS:
                  initData((ResponseData<Object>) o);
                  break;
            case Contans.Tag.ADD_FAVORITE:
                initAddFavorite((ResponseData<Object>) o);
                break;
            case Contans.Tag.ADD_CART:
                initAddCart((ResponseData<Object>) o);
                break;
        }
    }

    private void initAddCart(ResponseData<Object> o) {
        if (o.getCode()==200){
           dialog.show();
        }else {
            ToastUtils.showToastForText(this,o.getMessage());
        }
    }

    private void initAddFavorite(ResponseData<Object> o) {
        if (o.getCode()==200){
            ivCollect.setImageDrawable(getResources().getDrawable(R.drawable.collect_true));
        }else {
            ToastUtils.showToastForText(this,o.getMessage());
        }
    }

    private void initData(ResponseData<Object> object) {
        hideDialog();
        if (object.getCode()!=200){
            ToastUtils.showToastForText(CommodityDetailsActivity.this,object.getMessage());
            return;
        }
        DetailsBean detailsBean=gson.fromJson(gson.toJson(object.getData()),DetailsBean.class);
        DetailsBean.ProductBean productBean=detailsBean.getProduct();

        //第一层数据
        tvTitle.setText(productBean.getName());
        tvCode.setText(getResources().getString(R.string.product_code)+productBean.getSpu());
        rbStar.setIntegerMark(true);
        rbStar.setStarMark(Float.valueOf(productBean.getReviw_rate_star_average()));
        rbStar.setClick(false);
        tvEva.setText("("+productBean.getReview_count()+getResources().getString(R.string.eva)+")");
        DetailsBean.ProductBean.PriceInfoBean.PriceBean priceBean=productBean.getPrice_info().getPrice();

        //因为返回时 没有的时候 直接整个Special_price{}都没有了 所以需要判断
        if (productBean.getPrice_info().getSpecial_price()!=null){
            tvPriceMsg.setText(priceBean.getSymbol()+"  "+priceBean.getValue());
            tvPriceMsg.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            DetailsBean.ProductBean.PriceInfoBean.PriceBean sp=gson.fromJson(gson.toJson(productBean.getPrice_info().getSpecial_price()),DetailsBean.ProductBean.PriceInfoBean.PriceBean.class);
            tvPrice.setText(priceBean.getCode()+"\t"+priceBean.getSymbol()+"\t"+sp.getValue());
        }else {
            tvPrice.setText(priceBean.getCode()+"\t"+priceBean.getSymbol()+"\t"+priceBean.getValue());

        }
        //三个标题数据 第三个目前为空
        descFragment.setData(productBean.getDescription(),productBean.getImage_detail());
        evaFragment.setData(productBean.getReviw_rate_star_average()+"",productBean.getReviw_rate_star_info());
        if (productBean.getIs_favorite()==0){
            ivCollect.setImageDrawable(getResources().getDrawable(R.drawable.collect_false));
        }else {
            ivCollect.setImageDrawable(getResources().getDrawable(R.drawable.collect_true));
        }
        //属性
        List<DetailsBean.ProductBean.OptionsBean> list=new ArrayList<>();
        list=productBean.getOptions();
        if (list!=null&&list.size()!=0){
            //两种展示方式 第一种
            isOptions=true;
            if (optionAdapter==null){
                optionAdapter=new OptionAdapter(list,this);
                rvData.setAdapter(optionAdapter);
            }else {
                optionAdapter.initData(list);
            }

            optionAdapter.setOnSelectorClickListener(new OptionAdapter.OnSelectorClickListener() {
                @Override
                public void onSelector(int parentPos, int cPos, String oid) {
                    hashMap.clear();
                    id=oid;
                    hashMap.put("product_id",id);
                    presenter.getDetails(hashMap, Contans.Tag.DETAILS);
                }
            });
        }else {
            //两种展示方式 第二种
            isOptions=false;
            //显示的数据
            Map<String,Object> objectMap=gson.fromJson(gson.toJson(productBean.getCustom_items()),Map.class);
            Iterator<Map.Entry<String, Object>> iterator=objectMap.entrySet().iterator();
            List<String> keys=new ArrayList<>();
            List<Object> values=new ArrayList<>();
            List<List<CustomOptionListBean>> lists=new ArrayList<>();
            int i=0;
            while (iterator.hasNext()){
                Map.Entry<String,Object> entry=  iterator.next();
                keys.add(entry.getKey());
                values.add(entry.getValue());
                CustomOptionBean bean=gson.fromJson(gson.toJson(entry.getValue()),CustomOptionBean.class);
                List<CustomOptionListBean> listBeans=new ArrayList<>();
                for (CustomOptionListBean listBean: bean.getInfo()){
                    listBean.setValue(entry.getKey());
                    listBean.setIsChecked(1);
                    listBean.setPos(i);
                    listBeans.add(listBean);
                    i++;
                }
                lists.add(listBeans);
            }

            //条件数据
            List<String[]> mapList=new ArrayList<>();
            Map<String,Object> map=gson.fromJson(gson.toJson(productBean.getCustom_option()),Map.class);
            Iterator<Map.Entry<String,Object>> mapIterator=map.entrySet().iterator();
            while (mapIterator.hasNext()){
                Map.Entry<String,Object> entry=  mapIterator.next();
                CustomOptionsItemBean stringMap=gson.fromJson(gson.toJson(entry.getValue()),CustomOptionsItemBean.class);
                String[] strings=stringMap.getSku().split("-");
                for (int j=0;j<strings.length;j++){
                    strings[j]=strings[j].replace("*"," ");
                }
                mapList.add(strings);
            }

            customSize=lists.size();
            customOptionAdapter=new CustomOptionAdapter(this,keys,lists,mapList);
            rvData.setAdapter(customOptionAdapter);
        }
        initBanner(detailsBean.getProduct().getThumbnail_img());
    }

    private void initBanner(List<String> images) {
        List<String> strings=new ArrayList<>();
        for (String list:images){
            strings.add("");
        }
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.FlipHorizontal);
        //设置标题集合（当banner样式有显示title时）
       // banner.setBannerTitles(strings);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {

        initTopBar();
        presenter=new ClassifyPresenterImpl(this);
        RxBus.getInstance().register(presenter);

        hashMap.put("product_id",id);
        presenter.getDetails(hashMap, Contans.Tag.DETAILS);
        Log.i("TAGID",id+"");

        showDialog();
        initToolBar();
        initView();
        initEvent();
        initRefreshLayout();
    }

    //下拉刷新设置配置
    private void initRefreshLayout() {
        refreshLayout.setRefreshHeader(new FalsifyHeader(CommodityDetailsActivity.this));
        //设置 Footer 为 球脉冲 样式
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {


                presenter.getDetails(hashMap, Contans.Tag.DETAILS);
            }
        });
    }
    protected void initTopBar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //ViewHelp.getInstance().setTopPadding(getWindow().getDecorView(),getStatusBarHeight());
    }
    private void initEvent() {
        ivBack.setOnClickListener(onClickListener);
        cbCollect.setOnClickListener(onClickListener);
        tvCar.setOnClickListener(onClickListener);
        tvLess.setOnClickListener(onClickListener);
        tvAdd.setOnClickListener(onClickListener);
        ivBag.setOnClickListener(onClickListener);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPager.resetHeight(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.resetHeight(0);

        evaFragment.setOnSeeClickListener(new EvaFragment.OnSeeClickListener() {
            @Override
            public void onAdd() {
                //添加評論 已经隐藏
            }

            @Override
            public void onSee() {
                //查看评论
                Intent intent=new Intent(CommodityDetailsActivity.this,EvaListActivity.class);
                intent.putExtra("PRODUCETID",id);
                startActivity(intent);
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initToolBar() {
        //关于透明栏的 取巧操作
        int height=getStatusBarHeight();
        RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height+83);
        ll_top.setLayoutParams(lp);
        ll_top.setPadding(0,height,0,0);

        ll_top.getBackground().mutate().setAlpha(0);
        scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY<255){
                    ll_top.getBackground().mutate().setAlpha(scrollY);
                }else {
                    ll_top.getBackground().mutate().setAlpha(255);
                }
            }
        });

    }

    private void initView() {
        dialog=new FiniDialog(this);
        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(this);
        linearLayoutManager.setScrollEnabled(false);
        rvData.setLayoutManager(linearLayoutManager);
        rvData.setNestedScrollingEnabled(false);
        evaFragment=new EvaFragment(viewPager,1);
        descFragment=new DescFragment(viewPager,0);
        payFragment=new PayFragment(viewPager,2);
        fragmentList.add(0,descFragment);
        fragmentList.add(1,evaFragment);
        fragmentList.add(2,payFragment);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tlTitle));
        adapter=new DetailsPagerAdapter(getSupportFragmentManager(),fragmentList,mTitles);
        viewPager.setAdapter(adapter);
        tlTitle.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);

        //禁止第一个item点击事件 因为viewpager的问题导致的 所以只能先规避
       /* LinearLayout tabStrip = (LinearLayout) tlTitle.getChildAt(0);
        View tabView = tabStrip.getChildAt(0);
        if (tabView != null) {
            tabView.setClickable(false);
            tabView.setEnabled(false);
        }*/

    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int i = v.getId();
            if (i == R.id.iv_back) {
                //返回键
                finish();
            }else if (i==R.id.tv_car){
                //加入购物车
                hashMap.clear();
                hashMap.put("product_id",id);
                hashMap.put("qty",tvNum.getText().toString());
                Map<String,String> map=new HashMap<>();
                if (customOptionAdapter!=null){
                    map=customOptionAdapter.getValues();
                }
                if (isOptions){
                    presenter.addCart(hashMap,Contans.Tag.ADD_CART);
                }else if (customOptionAdapter!=null&&map.size()==customSize){
                    hashMap.put("custom_option",mapToJson(map));
                    presenter.addCart(hashMap,Contans.Tag.ADD_CART);
                    Log.i("TAG","size:"+mapToJson(map));
                }else {
                  ToastUtils.showToastForText(CommodityDetailsActivity.this,getResources().getString(R.string.changeHint));
                }
            }else if (i==R.id.tv_lose){
                //数量减少
                int num=Integer.valueOf(tvNum.getText().toString());
                if (num==1){return;}else {num--;}
                tvNum.setText(num+"");
            }else if (i==R.id.tv_add){
                //数量增加
                int num=Integer.valueOf(tvNum.getText().toString());
                num++;
                tvNum.setText(num+"");
            }else if (i==R.id.cb_collect){
                if (isCollect){
                    return;
                }else {
                    hashMap.clear();
                    hashMap.put("product_id",id);
                    presenter.addFavorite(hashMap,Contans.Tag.ADD_FAVORITE);
                }
            }else if (i==R.id.iv_bag){
                //购物车
                GTJHRouter.getInstance().build("/fecshop/MainActivity").withString("CHECKED","2").navigation(CommodityDetailsActivity.this);
                finish();
            }
        }
    };


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private String mapToJson(Map<String, String> map) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        return jsonStr;
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

}
