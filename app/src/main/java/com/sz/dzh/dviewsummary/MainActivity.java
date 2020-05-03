package com.sz.dzh.dviewsummary;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sz.dzh.dviewsummary.base.BaseListAdapter;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.bean.ClazzBean;
import com.sz.dzh.dviewsummary.module.custom.CustomViewListActivity;
import com.sz.dzh.dviewsummary.module.v5_6_function.V5FunctionListActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.V5ViewListActivity;
import com.sz.dzh.dviewsummary.module.v7_function.V7FunctionListActivity;
import com.sz.dzh.dviewsummary.module.v8_function.V8FunctionListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 *
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    protected List<ClazzBean> mList = new ArrayList<>();
    protected BaseListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initData(){
        addClazzBean("Android 5.0、6.0新增控件", V5ViewListActivity.class);
        addClazzBean("Android 5.0、6.0新增功能（与View相关）", V5FunctionListActivity.class);
        addClazzBean("Android 7.0 特性", V7FunctionListActivity.class);
        addClazzBean("Android 8.0 特性", V8FunctionListActivity.class);
        addClazzBean("自定义View", CustomViewListActivity.class);
    }

    private void initView(){
        mAdapter = new BaseListAdapter(mList);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(mList.get(position).getClazz());
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }



    protected void addClazzBean(String name, Class clazz){
        mList.add(new ClazzBean(name,clazz));
    }

}
