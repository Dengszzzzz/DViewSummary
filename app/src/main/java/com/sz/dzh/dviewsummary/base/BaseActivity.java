package com.sz.dzh.dviewsummary.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.socks.library.KLog;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.utils.AppManager;

import java.lang.reflect.ParameterizedType;

/**
 * base
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG = getClass().getSimpleName();
    protected Toolbar mToolbar;
    protected TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置只能竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //加入activity管理器
        AppManager.getAppManager().addActivity(this);
        //打印
        printRunningActivity(this, true);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        printRunningActivity(this, false);
        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 标题栏
     * @param title  标题
     */
    protected void initToolBar(String title){
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationOnClickListener(view -> finish());
        mTvTitle = findViewById(R.id.tv_title);
        mTvTitle.setText(title);
    }



    /**
     * 跳转 减少重复代码
     * @param tarActivity 目标activity
     */
    public void startActivity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        startActivity(intent);
    }


    /**
     * 打印activity信息
     *
     * @param ac
     * @param isRunning
     */
    protected void printRunningActivity(Activity ac, boolean isRunning) {
        String contextString = ac.toString();
        String s = contextString.substring(contextString.lastIndexOf(".") + 1, contextString.indexOf("@"));
        if (isRunning) {
            KLog.e("Activity", "app:当前正在加入的界面是:" + s);
        } else {
            KLog.e("Activity", "app:当前销毁的界面是:" + s);
        }
    }

}
