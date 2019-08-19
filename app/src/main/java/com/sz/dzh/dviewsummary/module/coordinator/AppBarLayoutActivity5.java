package com.sz.dzh.dviewsummary.module.coordinator;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 * AppBarLayout简单演示
 *
 * ToolBar 设置了 app:layout_scrollFlags="scroll|snap"
 * 设置吸附性效果，当你滚动TabLayout不足一半高度的时候就会回弹，高于一半的时候就会全部隐藏
 *
 *
 */
public class AppBarLayoutActivity5 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_app_bar_layout5);
       // initToolBar("scroll|snap");
    }
}
