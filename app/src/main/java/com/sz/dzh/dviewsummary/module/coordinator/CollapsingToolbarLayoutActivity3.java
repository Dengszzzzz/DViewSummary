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
 * CollapsingToolbarLayout 图片置顶
 * <p>
 * 需求：
 * CollapsingToolbarLayout 图片置顶
 *
 * 步骤：
 * 1、设置当前Activity的theme，状态栏为透明色。
 * 2、将ImageView和所有它上面的父View都添加fitsSystemWindows属性。
 * 3、setStatusBarScrim(Drawable)设置覆盖状态栏纱布为透明色
 * 4、发现Title只显示一半，通过设置setSupportActionBar(toolbar)恢复正常。
 */
public class CollapsingToolbarLayoutActivity3 extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_collapsing_toolbar_layout3);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //initToolBar("CollapsingToolbarLayout 简单演示");
    }
}
