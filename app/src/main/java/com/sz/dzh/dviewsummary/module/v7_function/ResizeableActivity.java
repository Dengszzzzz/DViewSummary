package com.sz.dzh.dviewsummary.module.v7_function;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.socks.library.KLog;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

/**
 * Created by dengzh on 2019/8/20
 * Android 7.0 分屏模式
 * 
 * 进入分屏模式，不销毁重建，需在设置 android:configChanges="orientation|screenLayout|screenSize"
 */
public class ResizeableActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_resize_able);
        initToolBar("分屏模式");
        KLog.e(TAG,"onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        KLog.e(TAG,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        KLog.e(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        KLog.e(TAG,"onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        KLog.e(TAG,"onStop()");
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        KLog.e(TAG,"onMultiWindowModeChanged()-------isInMultiWindowMode=" + isInMultiWindowMode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KLog.e(TAG,"onDestroy()");
    }
}
