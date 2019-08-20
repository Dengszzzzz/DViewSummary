package com.sz.dzh.dviewsummary.module.v8_function;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.base.BaseListAdapter;
import com.sz.dzh.dviewsummary.bean.ClazzBean;
import com.sz.dzh.dviewsummary.module.v5_6_view.FABAndSnackBarActivity;
import com.sz.dzh.dviewsummary.module.v7_function.ResizeableActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Android 8.0 特性
 * 1.画中画（8.0开始支持手机、7.0的时候就支持Tv了）
 * 2.自动填写（Auto-Fill）
 * 3.自定义字体，系统提供了字体下载（AS里就可以下载），也支持以前的xml改变字体。
 * 4.自动缩放文本视图   Autosizing TextView
 */
public class V8FunctionListActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

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

    private void initData() {

        addClazzBean("PIP模式", PipActivity.class);
        addClazzBean("字体新特性", FontActivity.class);
        addClazzBean("自动缩放文本 TextView", AutosizingTvActivity.class);

    }

    private void initView() {
        tvDesc.setText("Android 8.0 特性");

        mAdapter = new BaseListAdapter(mList);
        mAdapter.setOnItemClickListener((adapter, view, position) -> startActivity(mList.get(position).getClazz()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }


    protected void addClazzBean(String name, Class clazz) {
        mList.add(new ClazzBean(name, clazz));
    }

}
