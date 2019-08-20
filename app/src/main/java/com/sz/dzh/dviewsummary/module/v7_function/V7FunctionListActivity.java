package com.sz.dzh.dviewsummary.module.v7_function;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.base.BaseListAdapter;
import com.sz.dzh.dviewsummary.bean.ClazzBean;
import com.sz.dzh.dviewsummary.module.v5_6_function.ElevationActivity;
import com.sz.dzh.dviewsummary.module.v5_6_function.OutLineActivity;
import com.sz.dzh.dviewsummary.module.v5_6_function.PaletteActivity;
import com.sz.dzh.dviewsummary.module.v5_6_function.ThemeActivity;
import com.sz.dzh.dviewsummary.module.v5_6_function.WaterRippleActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Android 7.0 特性
 */
public class V7FunctionListActivity extends BaseActivity {

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

        addClazzBean("分屏模式", ResizeableActivity.class);

    }

    private void initView() {
        tvDesc.setText("Android 7.0 特性");

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
