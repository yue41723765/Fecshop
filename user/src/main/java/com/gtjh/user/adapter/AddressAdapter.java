package com.gtjh.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.entity.AddressListBean;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.user.R;
import com.gtjh.user.activity.AddAddressActivity;

import java.util.List;

/**
 * Created by android on 2018/7/10.
 */

public class AddressAdapter extends CommonAdapter<AddressListBean> {
    private onDeleteClickListener onDeleteClickListener;
    private OnItemChangeClickListener onItemChangeClickListener;
    public AddressAdapter(List<AddressListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_address_list;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, final AddressListBean addressListBean) {
        TextView name=holder.findViewById(R.id.tv_name);
        TextView city=holder.findViewById(R.id.tv_city);
        TextView code=holder.findViewById(R.id.tv_code);
        TextView address=holder.findViewById(R.id.tv_address);
        TextView phone=holder.findViewById(R.id.tv_phone);
        TextView delete=holder.findViewById(R.id.tv_delete);
        TextView edit=holder.findViewById(R.id.tv_edit);
        RelativeLayout relativeLayout=holder.findViewById(R.id.rl_all);

        CheckBox checked=holder.findViewById(R.id.cb_default);
        name.setText(addressListBean.getFirst_name()+"   "+addressListBean.getLast_name());
        city.setText(addressListBean.getCountryName()+addressListBean.getStateName()+addressListBean.getCity());
        code.setText(addressListBean.getZip());
        address.setText(addressListBean.getStreet1());
        phone.setText(addressListBean.getTelephone());

        if (addressListBean.getIs_default().equals("1")){
            checked.setChecked(true);
        }else {
            checked.setChecked(false);
        }
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ADDRESSID
                Intent intent=new Intent(context, AddAddressActivity.class);
                intent.putExtra("ADDRESSID",addressListBean.getAddress_id());
                context.startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDeleteClickListener!=null){
                    onDeleteClickListener.onDelete(addressListBean.getAddress_id());
                }
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemChangeClickListener!=null){
                    onItemChangeClickListener.onChange(addressListBean);
                }
            }
        });
    }

    public void setOnDeleteClickListener(AddressAdapter.onDeleteClickListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public void setOnItemChangeClickListener(OnItemChangeClickListener onItemChangeClickListener) {
        this.onItemChangeClickListener = onItemChangeClickListener;
    }

    public interface onDeleteClickListener{
        void onDelete(String id);
    }

    public interface OnItemChangeClickListener{
        void onChange(AddressListBean bean);
    }
}
