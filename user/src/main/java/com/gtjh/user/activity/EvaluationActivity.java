package com.gtjh.user.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.bean.EvaluationBean;
import com.gtjh.user.presenter.impl.OrderPresenterImpl;


import java.util.HashMap;

import butterknife.BindView;

/**
 * Created by android on 2018/7/13.
 */

public class EvaluationActivity extends ToolBarActivity implements View.OnClickListener {
    @BindView(R2.id.iv_img)
    ImageView ivImg;
    @BindView(R2.id.iv_code)
    ImageView ivCode;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tv_unit)
    TextView tvUnit;
    @BindView(R2.id.tv_price)
    TextView tvPrice;
    @BindView(R2.id.rb_star)
    RatingBar rbStar;
    @BindView(R2.id.et_profile)
    TextView etProfile;
    @BindView(R2.id.et_eva)
    TextView etEva;
    @BindView(R2.id.et_code)
    TextView etCode;
    @BindView(R2.id.tv_price_old)
    TextView tvPriceOld;
    @BindView(R2.id.ll_code)
    LinearLayout llCode;

    private OrderPresenterImpl presenter;
    private String id="";
    private String name="";
    @Override
    public void showSuccess(Object o, int tag) {

        switch (tag){
            case Contans.Tag.EVALUATION_SUB:
                submitData((ResponseData<Object>) o);
                break;
            case Contans.Tag.EVALUATION_INIT:
                initData((ResponseData<Object>) o);
                break;
            case Contans.Tag.CODE:
                showCode((ResponseData<HashMap<String, String>>) o);
                break;
        }
    }

    private void showCode(ResponseData<HashMap<String, String>> data) {
        String base64 = data.getData().get("image");
        ivCode.setImageBitmap(base64ToBitmap(base64));

    }

    private void submitData(ResponseData<Object> o) {
        ToastUtils.showToastForText(this,o.getMessage());
        if (o.getCode()==200){
            finish();
        }
    }

    private void initData(ResponseData<Object> o) {
        //初始化
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            return;
        }
        EvaluationBean bean=gson.fromJson(gson.toJson(o.getData()),EvaluationBean.class);
        tvTitle.setText(bean.getProduct().getProduct_name());
        tvUnit.setText(bean.getProduct().getSpu());
        ImageLoaderPresenter.getInstance().loadRound(this, bean.getProduct().getImgUrl(), ivImg);
        EvaluationBean.ProductBean.PriceInfoBean priceInfoBean=bean.getProduct().getPrice_info();
        tvPrice.setText(priceInfoBean.getPrice().getSymbol()+priceInfoBean.getPrice().getValue());//特价在前
        //tvPriceOld.setText(priceInfoBean.getPrice().getSymbol()+priceInfoBean.getPrice().getValue());
        //tvPriceOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        name=bean.getCustomer_name();
        if (bean.isReviewCaptchaActive()){
            presenter.loadCode(Contans.Tag.CODE);
            llCode.setVisibility(View.VISIBLE);
        }else {
            llCode.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.appraise));
        Build build=new Build();
        build.setTextSize(30);
        build.setText(getResources().getString(R.string.submit));
        build.setTextColor(Color.BLACK);
        build.setListener(this);
        setRight(build);


        presenter=new OrderPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        //product_id
         id=getIntent().getStringExtra("PRODECTID");
        HashMap<String ,Object> map=new HashMap<>();
        map.put("product_id",id);
        presenter.evaluationInit(map, Contans.Tag.EVALUATION_INIT);
        initStar();
    }

    private void initStar() {
        int starsImgHeight=0;
        //获取图片的高度
        try {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_star_border);
            starsImgHeight = bmp.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将获取的图片高度设置给RatingBar
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)rbStar.getLayoutParams();
        lp.width = LinearLayout.LayoutParams.WRAP_CONTENT;
        lp.height =starsImgHeight+10;
        rbStar.setLayoutParams(lp);
    }

    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_evaluation;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }

    @Override
    public void onClick(View v) {
        //提交
        String title=etProfile.getText().toString();
        String captcha=etCode.getText().toString();
        String content=etEva.getText().toString();
        int starNum=rbStar.getNumStars();
        if (TextUtils.isEmpty(title)||TextUtils.isEmpty(content)){
            ToastUtils.showToastForText(this,getResources().getString(R.string.requiredHint));
            return;
        }
        if (TextUtils.isEmpty(captcha) || captcha.length() != 4) {
            ToastUtils.showToastForText(this, getResources().getString(R.string.codeHint));
            return;
        }
        if (starNum==0){
            ToastUtils.showToastForText(this, getResources().getString(R.string.evaStarHint));
            return;
        }
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("product_id",id);
        hashMap.put("customer_name",name);
        hashMap.put("summary",title);//标题
        hashMap.put("captcha",captcha);//验证码
        hashMap.put("review_content",content);//内容
        hashMap.put("selectStar",starNum);//评分
        presenter.evaluationSub(hashMap,Contans.Tag.EVALUATION_SUB);
    }
}
