package com.sz.dzh.dviewsummary.module.v5_6_function;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.base.BaseListAdapter;
import com.sz.dzh.dviewsummary.bean.ClazzBean;
import com.sz.dzh.dviewsummary.module.ConstraintActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.CardViewActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.FABAndSnackBarActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.NavigationViewActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.TabLayoutActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.TextInputLtActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.ToolBarActivity;
import com.sz.dzh.dviewsummary.module.v5_6_view.coordinator.CoordinatorLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Android 5.0 6.0新增功能
 * 1）View的高度和阴影
 * 2）View的轮廓与裁剪   
 * 3）Palette的使用，从一张图片中提取出关键的颜色，可以把该颜色值设置到别的控件上面。
 * 4）水波纹动画，自定义水波纹动画以及状态选择器动画
 * 5）如何动态替换theme？
 */
public class V5FunctionListActivity extends BaseActivity {

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

        addClazzBean("View的阴影，Z属性", ElevationActivity.class);
        addClazzBean("View的轮廓和裁剪，Outline 和 ViewOutlineProvider", OutLineActivity.class);
        addClazzBean("Palette 调色板", PaletteActivity.class);
        addClazzBean("View 的水波纹效果", WaterRippleActivity.class);
        addClazzBean("动态改变Theme", ThemeActivity.class);

    }

    private void initView() {
        tvDesc.setText("Android 5.0 6.0新增功能（与View相关）");

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
