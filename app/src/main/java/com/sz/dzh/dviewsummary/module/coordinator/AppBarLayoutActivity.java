package com.sz.dzh.dviewsummary.module.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 * AppBarLayout简单演示
 * 需求：
 * 1、随着文本往上滚动, 顶部的toolbar也往上滚动, 直到消失.
 * 2、随着文本往下滚动, 一直滚到文本的第一行露出来, toolbar也逐渐露出来
 *
 * 步骤：
 * 1、CoordinatorLayout 作为根布局，它才支持  app:layout_behavior。
 * 2、可折叠部分：AppBarLayout 包裹 ToolBar，ToolBar 设置了 app:layout_scrollFlags="scroll"
 * 3、滚动部分：NestedScrollView 设置了app:layout_behavior="@string/appbar_scrolling_view_behavior"，
 *    这是一个系统behavior，字面意思是为appbar设置滚动动作的一个behavior。
 *
 *
 * 由此可看，我们要知道这些
 * 1、ToolBar的app:layout_scrollFlags 各个值代表的意思。
 * 2、哪些控件有行为布局，也就是能设置 app:layout_behavior。
 * 3、app:layout_behavior 的值又有哪些。
 */
public class AppBarLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_app_bar_layout);
        //initToolBar("scroll");
    }
}
