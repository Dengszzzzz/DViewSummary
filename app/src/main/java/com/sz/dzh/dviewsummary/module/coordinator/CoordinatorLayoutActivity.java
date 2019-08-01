package com.sz.dzh.dviewsummary.module.coordinator;

import android.view.View;

import com.sz.dzh.dviewsummary.base.BaseListShowActivity;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 *
 * 1、AppBarLayout是什么？
 * AppBarLayout 继承自LinearLayout，布局方向为垂直方向。所以你可以把它当成垂直布局的LinearLayout来使用。
 * AppBarLayout是在LinearLayou上加了一些材料设计的概念，它可以让你定制当某个可滚动View的滚动手势发生变化时，
 * 其内部的子View实现何种动作。
 *
 *
 */
public class CoordinatorLayoutActivity extends BaseListShowActivity {

    @Override
    protected void initUI() {
        initToolBar("折叠布局");
        mTvDesc.setVisibility(View.VISIBLE);
        mTvDesc.setText("CoordinatorLayout、AppBarLayout、CollapsingToolbarLayout 示例");
    }

    @Override
    protected void initData() {
        addClazzBean("AppBarLayout简单演示，scrollFlags设置为scroll", AppBarLayoutActivity.class);
        addClazzBean("scroll|enterAlways", AppBarLayoutActivity2.class);
        addClazzBean("scroll|exitUntilCollapsed", AppBarLayoutActivity3.class);
        addClazzBean("scroll|enterAlwaysCollapsed", AppBarLayoutActivity4.class);
        addClazzBean("scroll|snap", AppBarLayoutActivity5.class);
        mAdapter.notifyDataSetChanged();
    }
}
