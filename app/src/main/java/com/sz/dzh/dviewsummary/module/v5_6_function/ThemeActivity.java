package com.sz.dzh.dviewsummary.module.v5_6_function;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.socks.library.KLog;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengzh on 2019/8/19 0019.
 * 动态改变Theme
 * 步骤：
 * 1、在styles.xml设置多套Theme
 * 2、在 setContentView(R.layout.ac_theme); 之前调用  setTheme(mTheme);
 * 3、重启Activity，让Theme生效
 *
 * 参考：
 * https://blog.csdn.net/tianzhu2725/article/details/52775285
 */
public class ThemeActivity extends BaseActivity {

    public static int mTheme = R.style.ThemeChange_A;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(mTheme);
        setContentView(R.layout.ac_theme);
        ButterKnife.bind(this);
        initToolBar("动态改变Theme");
    }

    @OnClick(R.id.btn_change)
    public void onViewClicked() {
        if(mTheme== R.style.ThemeChange_A){
            mTheme = R.style.ThemeChange_B;
        }else{
            mTheme = R.style.ThemeChange_A;
        }
        //重启当前Activity，让Theme生效
        finish();
        startActivity(ThemeActivity.class);
    }
}
