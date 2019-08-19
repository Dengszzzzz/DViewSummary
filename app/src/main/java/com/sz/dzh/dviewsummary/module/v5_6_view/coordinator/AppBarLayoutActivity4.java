package com.sz.dzh.dviewsummary.module.v5_6_view.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 * AppBarLayout简单演示
 *
 * ToolBar 设置了 app:layout_scrollFlags="scroll|enterAlways|enterAlwaysCollapsed"
 *
 * enterAlwaysCollapsed 是enterAlways的附加选项，要和enterAlways一起使用，否则没有效果，它是指View在往下
 * “出现”的时候，首先是enterAlways效果，当View的高度达到最小高度时，View就暂时不去往下滚动，直到ScrollView滑动
 * 到顶部不再滑动* 时，View再继续往下滑动，直到滑到View的顶部结束。
 *
 *
 */
public class AppBarLayoutActivity4 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_app_bar_layout4);
        //initToolBar("scroll|enterAlways|enterAlwaysCollapsed");
    }
}
