package com.gtjh.main.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gtjh.common.BaseActivity;
import com.gtjh.common.ToolBarActivity;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.main.R;
import com.gtjh.main.R2;
import com.gtjh.main.adapter.SearchHistoryAdapter;
import com.gtjh.main.util.ListDataSave;
import com.gtjh.router_annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by android on 2018/7/17.
 */
@Route(path = "/main/SearchActivity")
public class SearchActivity extends BaseActivity implements View.OnClickListener, SearchHistoryAdapter.onItemClickListener {

    @BindView(R2.id.iv_back)
    ImageView ivBack;
    @BindView(R2.id.et_search)
    EditText etSearch;
    @BindView(R2.id.lv_data)
    ListView lvData;
    private SearchHistoryAdapter adapter;
    private List<String> list=new ArrayList<>();
    private ListDataSave listDataSave;
    private View view;
    @Override
    public void showSuccess(Object o, int tag) {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void init(Bundle savedInstanceState) {

        //获取本地
        listDataSave=new ListDataSave(this);
        list=listDataSave.getDataList();

        adapter=new SearchHistoryAdapter(list,this);
        lvData.setAdapter(adapter);
        view= LayoutInflater.from(this).inflate(R.layout.item_search_buttom,null);
        LinearLayout llBottom=view.findViewById(R.id.ll_bottom);
        if (list!=null&&list.size()>0){ lvData.addFooterView(view);}
        llBottom.setOnClickListener(this);

        initEvent();
    }

    private void initEvent() {
        adapter.setOnItemClickListener(this);
        //因为冲突了 所以匿名内部了
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //回车变搜索
                if (actionId ==EditorInfo.IME_ACTION_SEARCH)
                {
                    // 先隐藏键盘
                    ((InputMethodManager) etSearch.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchActivity.this
                                            .getCurrentFocus()
                                            .getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);

                    list=listDataSave.getDataList();
                    String search=etSearch.getText().toString();
                    if (TextUtils.isEmpty(search)){
                        ToastUtils.showToastForText(SearchActivity.this,getResources().getString(R.string.search_hint));
                        return false;
                    }
                    if (list.size()<20){
                        list.add(0,search.trim());
                    }else {
                        for (int i=0;i<list.size()-20;i++){
                            list.remove(i);
                        }
                        list.add(etSearch.getText().toString());
                    }
                    listDataSave.setDataList(list);
                    Intent intent=new Intent(SearchActivity.this,SearchListActivity.class);
                    intent.putExtra("SEARCHTEXT",etSearch.getText().toString());
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }

    @OnClick(R2.id.iv_back)
    public void back(){
        //返回键
        finish();
    }

    @Override
    public void onClick(View v) {
        //底部视图的点击事件
        listDataSave.clear();
        lvData.removeFooterView(view);
        list.clear();
        adapter.setData(list);
        lvData.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(int pos, String value) {
        //条目点击事件
        Intent intent=new Intent(SearchActivity.this,SearchListActivity.class);
        intent.putExtra("SEARCHTEXT",value);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        list=listDataSave.removeDuplicateWithOrder(list);
        adapter.setData(list);
        adapter.notifyDataSetChanged();
        Log.i("list",list.toString());
        lvData.setVisibility(View.VISIBLE);
        if (list!=null&&list.size()>0){
            if ( lvData.getFooterViewsCount()==0){
                lvData.addFooterView(view);
            }
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public BaseActivity getInjectObject() {
        return this;
    }


}
