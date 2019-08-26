package com.sz.dzh.dviewsummary.module;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

/**
 * Created by Dengzh
 * on 2019/7/27 0027
 * 复杂的布局再用ConstraintLayout，如果是简单的还是用LinearLayou或RelativeLayout，它们的测量更快。
 * 可以用它做一些有意思的布局，比如用角度定位做圆形菜单，宽高比也可以很方便处理适配布局变形问。
 */
public class ConstraintActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_constraint);
        initToolBar("ConstraintLayout");
    }
}
