package com.sz.dzh.dviewsummary.module;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

/**
 * Created by Dengzh
 * on 2019/7/30 0030
 */
public class CardViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_card_view);
        initToolBar("CardView");
    }
}
