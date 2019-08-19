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
 * ToolBar 设置了
 * android:minHeight="20dp"
 * app:layout_scrollFlags="scroll|exitUntilCollapsed"
 * exitUntilCollapsed作用：
 * 当这个View要往上逐渐“消逝”时，会一直往上滑动，直到剩下的的高度达到它的最小高度后，再响应ScrollView的内部滑动事件。
 *
 * 发现一个问题：
 * 设置了minHeight后，navigationIcon不居中显示？
 * 原因是minHeight的值决定了居中轴的位置，居中轴的位置始终为minHeight的一半，minHeight有默认的缺省值，而height
 * 设为wrap_content时，高度恰好为minHeight的缺省值，所以居中轴恰好为当前高度的中心，所以达到了居中的效果。
 * 当minHeight的值大于height后，实际的高度为minHeight的高度。当minHeight的值低于height后，实际的高度为height的值。
 * 这个时候就要用到 CollapsingToolbarLayout 了。
 */
public class AppBarLayoutActivity3 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_app_bar_layout3);
        //initToolBar("scroll|exitUntilCollapsed");
    }
}
