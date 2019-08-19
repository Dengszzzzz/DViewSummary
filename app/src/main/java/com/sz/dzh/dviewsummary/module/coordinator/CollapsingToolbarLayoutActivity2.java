package com.sz.dzh.dviewsummary.module.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 * CollapsingToolbarLayout简单演示2
 * <p>
 * 需求：
 * CollapsingToolbarLayout 放入ImageView，折叠图片，且附上FloatingActionButton，往上滚动会改变标题栏颜色。
 * <p>
 * 步骤：
 * 1、设置CollapsingToolbarLayout 的 app:layout_scrollFlags="scroll|exitUntilCollapsed"
 * 2、设置Toolbar的app:layout_collapseMode="pin"，设置ImageView的app:layout_collapseMode="parallax"
 * 3、设置CollapsingToolbarLayout的setContentScrim(Drawable)，设置收缩标题栏颜色变化。
 * 4、设置FloatingActionButton 的  app:layout_anchor="@id/AppBarLayout"
 */
public class CollapsingToolbarLayoutActivity2 extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_collapsing_toolbar_layout2);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //initToolBar("CollapsingToolbarLayout 简单演示");
    }
}
