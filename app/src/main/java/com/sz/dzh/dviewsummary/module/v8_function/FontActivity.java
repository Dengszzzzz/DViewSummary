package com.sz.dzh.dviewsummary.module.v8_function;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengzh on 2019/8/20
 * 自定义字体，可下载字体
 */
public class FontActivity extends BaseActivity {

    @BindView(R.id.tv_old)
    TextView tvOld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_font);
        ButterKnife.bind(this);
        initToolBar("自定义字体");


        ////根据路径得到Typeface
        Typeface tf =Typeface.createFromAsset(getAssets(), "fonts/sxslst.ttf");
        //设置字体
        tvOld.setTypeface(tf);
    }
}
