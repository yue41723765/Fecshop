package com.gtjh.user.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.entity.ResponseData;
import com.gtjh.common.net.Rx.databus.RxBus;
import com.gtjh.common.util.Contans;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.user.bean.AddressCountyBean;
import com.gtjh.user.bean.AddressInitializeBean;
import com.gtjh.user.R;
import com.gtjh.user.R2;
import com.gtjh.user.presenter.impl.AddressListPresenterImpl;
import com.gtjh.user.util.JsonMap;
import com.gtjh.user.util.dialog.PickerDialog;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by android on 2018/7/10.
 * 新建货运地址
 */

public class AddAddressActivity extends ToolBarActivity {


    @BindView(R2.id.rl_city)
    RelativeLayout rlProvince;

    @BindView(R2.id.iv_city)
    ImageView ivCity;
    @BindView(R2.id.iv_name)
    ImageView ivName;
    @BindView(R2.id.iv_surname)
    ImageView ivSurname;
    @BindView(R2.id.iv_address)
    ImageView ivAddress;
    @BindView(R2.id.iv_phone)
    ImageView ivPhone;
    @BindView(R2.id.iv_thecity)
    ImageView ivTheCity;
    @BindView(R2.id.iv_mail)
    ImageView ivMail;
    @BindView(R2.id.iv_address_t)
    ImageView ivAddressT;
    @BindView(R2.id.iv_postal)
    ImageView ivPostal;

    @BindView(R2.id.et_name)
    EditText etName;
    @BindView(R2.id.et_surname)
    EditText etSurname;
    @BindView(R2.id.et_address)
    EditText etAddress;
    @BindView(R2.id.et_phone)
    EditText etPhone;
    @BindView(R2.id.et_address_t)
    EditText etAddressT;
    @BindView(R2.id.et_mail)
    EditText etMail;
    @BindView(R2.id.et_postal)
    EditText etPostal;
    @BindView(R2.id.et_thecity)
    EditText etTheCity;
    @BindView(R2.id.et_city_edit)
    EditText etCity;

    @BindView(R2.id.tv_county_edit)
    TextView tvCounty;
    @BindView(R2.id.tv_city_edit)
    TextView tvCity;
    @BindView(R2.id.cb_default)
    CheckBox cbDefault;
    private String addressId="";
    private AddressListPresenterImpl presenter;
    private int isDefaultActive=0;
    private   HashMap<String,Object> map=new HashMap<>();
    private Map<String,Object> countyArr=new HashMap<>();
    private Map<String,Object> province=new HashMap<>();
    private String countyKey="";
    private String provinceKey="";

    private PickerDialog countyDialog;
    private PickerDialog provinceDialog;
    private int isSelector=1;

    @Override
    public void showSuccess(Object o, int tag) {
        switch (tag){
            case Contans.Tag.ADDRESS_INITIALIZE:

                ResponseData<Object> responseData = (ResponseData<Object>) o;

                initData((ResponseData<Object>) o);
                break;
            case Contans.Tag.ADDRESS_SUBMIT:
                initSuccess((ResponseData<Object>) o);
                break;
            case Contans.Tag.ADDRESS_COUNTY:
                initCounty((ResponseData<Object>) o);
                break;
        }
    }

    private void initCounty(ResponseData<Object> o) {
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            return;
        }
        AddressCountyBean data=gson.fromJson(gson.toJson(o.getData()),AddressCountyBean.class);
        isSelector=data.getStateIsSelect();
        if (isSelector==1){
            province=gson.fromJson(gson.toJson(data.getStateArr()), Map.class);
            provinceKey=province.keySet().iterator().next();
            tvCity.setText(String.valueOf(province.get(provinceKey)));
            tvCity.setVisibility(View.VISIBLE);
            etCity.setVisibility(View.GONE);
            ivCity.setVisibility(View.VISIBLE);
        }else {
            ivCity.setVisibility(View.GONE);
            etCity.setVisibility(View.VISIBLE);
            tvCity.setVisibility(View.GONE);
        }

    }

    private void initSuccess(ResponseData<Object> o) {
        if (o.getCode()==200){
            finish();
        }
        ToastUtils.showToastForText(this,o.getMessage());
    }

    private void initData(ResponseData<Object> o) {
        if (o.getCode()!=200){
            ToastUtils.showToastForText(this,o.getMessage());
            return;
        }
        AddressInitializeBean data= gson.fromJson(gson.toJson(o.getData()), AddressInitializeBean.class);
        countyArr= gson.fromJson(gson.toJson(data.getAddress().getCountryArr()), Map.class);
        province= gson.fromJson(gson.toJson(data.getAddress().getStateArr()), Map.class);

        countyKey=JsonMap.getKeyOrNull(countyArr);
        provinceKey=JsonMap.getKeyOrNull(province);

        tvCounty.setText(String.valueOf(countyArr.get(countyKey)));
        isSelector=data.getAddress().getStateIsSelect();
        if (isSelector==1){
            tvCity.setText(String.valueOf(province.get(provinceKey)));
            tvCity.setVisibility(View.VISIBLE);
            etCity.setVisibility(View.GONE);
            ivCity.setVisibility(View.VISIBLE);
        }else {
            ivCity.setVisibility(View.GONE);
            etCity.setText(data.getAddress().getState());
            etCity.setVisibility(View.VISIBLE);
            tvCity.setVisibility(View.GONE);
        }

        AddressInitializeBean.AddressBean addressBean=data.getAddress();
        if (!TextUtils.isEmpty(addressId)){
            etName.setText(addressBean.getFirst_name());
            etAddress.setText(addressBean.getStreet1());
            etAddressT.setText(addressBean.getStreet2());
            etMail.setText(addressBean.getEmail());
            etPhone.setText(addressBean.getTelephone());
            etPostal.setText(addressBean.getZip());
            etSurname.setText(addressBean.getLast_name());
            etTheCity.setText(addressBean.getCity());

            etName.setVisibility(View.VISIBLE);
            etAddress.setVisibility(View.VISIBLE);
            etAddressT.setVisibility(View.VISIBLE);
            etMail.setVisibility(View.VISIBLE);
            etPhone.setVisibility(View.VISIBLE);
            etPostal.setVisibility(View.VISIBLE);
            etSurname.setVisibility(View.VISIBLE);
            etTheCity.setVisibility(View.VISIBLE);

            if (addressBean.getIs_default()==1){
                cbDefault.setChecked(true);
            }else {
                cbDefault.setChecked(false);
            }
            countyKey=addressBean.getCountry();
            provinceKey=addressBean.getState();
            //tvCounty.setText(countyKey);
            if (province.get(provinceKey)!=null) {
                tvCity.setText(String.valueOf(province.get(provinceKey)));
                etCity.setText(String.valueOf(province.get(provinceKey)));
            }else {
                tvCity.setText(provinceKey);
                etCity.setText(provinceKey);
            }
        }

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(getResources().getString(R.string.shipping_address));

        Build build=new Build();
        build.setText(getResources().getString(R.string.save));
        build.setListener(onRightClickListener);
        build.setTextColor(Color.BLACK);
        build.setTextSize(30);
        setRight(build);

        presenter=new AddressListPresenterImpl(this);
        RxBus.getInstance().register(presenter);
        addressId=getIntent().getStringExtra("ADDRESSID");
        if (!TextUtils.isEmpty(addressId)) {
            map.put("address_id", addressId);
        }
        presenter.addressInitialize(map,Contans.Tag.ADDRESS_INITIALIZE);

        countyDialog=new PickerDialog(this);
        initEvent();
    }

    private void initEvent() {
        etName.addTextChangedListener(new editWatcher(R.id.et_name));
        etTheCity.addTextChangedListener(new editWatcher(R.id.et_thecity));
        etSurname.addTextChangedListener(new editWatcher(R.id.et_surname));
        etPostal.addTextChangedListener(new editWatcher(R.id.et_postal));
        etPhone.addTextChangedListener(new editWatcher(R.id.et_phone));
        etMail.addTextChangedListener(new editWatcher(R.id.et_mail));
        etAddressT.addTextChangedListener(new editWatcher(R.id.et_address_t));
        etAddress.addTextChangedListener(new editWatcher(R.id.et_address));
    }

    //输入框的监听  监听是否输入文字
    private class editWatcher implements TextWatcher {
        private  int id;

        public editWatcher(int id){
            this.id=id;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (id == R.id.et_name) {
                if (!TextUtils.isEmpty(s)&&s.length()>0){
                    ivName.setVisibility(View.VISIBLE);
                }else {
                    ivName.setVisibility(View.GONE);
                }
            } else if (id == R.id.et_thecity) {
                if (!TextUtils.isEmpty(s)&&s.length()>0){
                    ivTheCity.setVisibility(View.VISIBLE);
                }else {
                    ivTheCity.setVisibility(View.GONE);
                }
            } else if (id == R.id.et_surname) {
                if (!TextUtils.isEmpty(s)&&s.length()>0){
                    ivSurname.setVisibility(View.VISIBLE);
                }else {
                    ivSurname.setVisibility(View.GONE);
                }
            } else if (id == R.id.et_postal) {
                if (!TextUtils.isEmpty(s)&&s.length()>0){
                    ivPostal.setVisibility(View.VISIBLE);
                }else {
                    ivPostal.setVisibility(View.GONE);
                }
            } else if (id == R.id.et_phone) {
                if (!TextUtils.isEmpty(s)&&s.length()>0){
                    ivPhone.setVisibility(View.VISIBLE);
                }else {
                    ivPhone.setVisibility(View.GONE);
                }
            } else if (id == R.id.et_mail) {
                if (isEmail(s.toString())){
                    ivMail.setVisibility(View.VISIBLE);
                }else {
                    ivMail.setVisibility(View.GONE);
                }
            } else if (id == R.id.et_address) {
                if (!TextUtils.isEmpty(s)&&s.length()>0){
                    ivAddress.setVisibility(View.VISIBLE);
                }else {
                    ivAddress.setVisibility(View.GONE);
                }
            } else if (id == R.id.et_address_t) {
                if (!TextUtils.isEmpty(s)&&s.length()>0){
                    ivAddressT.setVisibility(View.VISIBLE);
                }else {
                    ivAddressT.setVisibility(View.GONE);
                }
            }
        }
    }
    //点击行 的监听
    @OnClick({R2.id.rl_county,R2.id.rl_name,R2.id.rl_surname,R2.id.rl_city,R2.id.rl_address,R2.id.rl_phone,R2.id.rl_address_t,R2.id.rl_postal,R2.id.rl_mail,R2.id.rl_thecity})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.rl_county) {
            if (countyArr==null||countyArr.size()<=0){
                ToastUtils.showToastForText(AddAddressActivity.this,"load...");
                return;
            }
            countyDialog.setData(countyArr);
            countyDialog.setOnChangeClickListener(new PickerDialog.onChangeClickListener() {
                @Override
                public void onChange(String key,String value) {
                    countyKey=key;
                    tvCounty.setText(value);
                    map.clear();
                    map.put("country",key);
                    presenter.addressCounty(map,Contans.Tag.ADDRESS_COUNTY);
                }
            });
            countyDialog.show();
            //选择城市
        } else if (i == R.id.rl_name) {
            getFocusable(etName);
        } else if (i == R.id.rl_surname) {
            getFocusable(etSurname);
        } else if (i == R.id.rl_city) {
            //选择省
            if (isSelector==0){
                //没有省的时候屏蔽点击
                return;
            }
            if (province==null||province.size()<=0){
                ToastUtils.showToastForText(AddAddressActivity.this,"load...");
                return;
            }
            provinceDialog=new PickerDialog(this);
            provinceDialog.setData(province);
            provinceDialog.setOnChangeClickListener(new PickerDialog.onChangeClickListener() {
                @Override
                public void onChange(String key,String value) {
                    provinceKey=key;
                    tvCity.setText(value);
                }
            });
            provinceDialog.show();
        } else if (i == R.id.rl_address) {
            getFocusable(etAddress);
        } else if (i == R.id.rl_phone) {
            getFocusable(etPhone);
        }else if (i == R.id.rl_address_t) {
            getFocusable(etAddressT);
        }else if (i == R.id.rl_postal) {
            getFocusable(etPostal);
        }else if (i == R.id.rl_mail) {
            getFocusable(etMail);
        }else if (i == R.id.rl_thecity) {
            getFocusable(etTheCity);
        }
    }

    //弹出菜单
    private void getFocusable(View view){
        if (view.getVisibility()!=View.VISIBLE){
            view.setVisibility(View.VISIBLE);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,0);
        }
    }
        //保存键的监听
    private View.OnClickListener onRightClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String mail=etMail.getText().toString();
            String name=etName.getText().toString();
            String surname=etSurname.getText().toString();
            String phone=etPhone.getText().toString();
            String thCity=etTheCity.getText().toString();
            String street=etAddress.getText().toString();
            String streetT=etAddressT.getText().toString();
            String postal=etPostal.getText().toString();
            String county=countyKey;
            String city=provinceKey;
            String eCity=etCity.getText().toString();
            Boolean defaultC=cbDefault.isChecked();
            if (TextUtils.isEmpty(mail)||TextUtils.isEmpty(name)||TextUtils.isEmpty(surname)||TextUtils.isEmpty(phone)||TextUtils.isEmpty(thCity)||TextUtils.isEmpty(street)||TextUtils.isEmpty(streetT)
                    ||TextUtils.isEmpty(postal)){
                ToastUtils.showToastForText(AddAddressActivity.this,getResources().getString(R.string.requiredHint));
                return;
            }
            if (!isEmail(mail)){
                ToastUtils.showToastForText(AddAddressActivity.this,getResources().getString(R.string.mailHint));
                return;
            }
            if (isSelector==1&&TextUtils.isEmpty(city)){
                ToastUtils.showToastForText(AddAddressActivity.this,getResources().getString(R.string.requiredHint));
                return;
            }else if (isSelector==0&&TextUtils.isEmpty(eCity)){
                ToastUtils.showToastForText(AddAddressActivity.this,getResources().getString(R.string.requiredHint));
                return;
            }
            isDefaultActive=defaultC?1:0;
            map.clear();
            if (!TextUtils.isEmpty(addressId)){
                map.put("address_id",addressId);
            }
            map.put("first_name",name);
            map.put("last_name",surname);
            map.put("email",mail);
            map.put("telephone",phone);
            map.put("addressCountry",county);
            if (isSelector==1){
                map.put("addressState",city);
            }else {
                map.put("addressState",eCity);
            }
            map.put("city",thCity);
            map.put("street1",street);
            map.put("street2",streetT);
            map.put("isDefaultActive",isDefaultActive);
            map.put("zip",postal);
            presenter.addressSubmit(map, Contans.Tag.ADDRESS_SUBMIT);
        }
    };


    private boolean isEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);

    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_add_address;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }
}
