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
 * ToolBar 设置了 app:layout_scrollFlags="scroll|enterAlways"
 * 作用：
 * 当任何时候ScrollView往下滚动时，该View会直接往下滚动，全部拉出后，再滚动ScrollView，
 * 而不用考虑ScrollView是否滚动到最顶部。
 */
public class AppBarLayoutActivity2 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_app_bar_layout2);
        //initToolBar("scroll|enterAlways");
    }
}
