package com.sz.dzh.dviewsummary.base;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.socks.library.KLog;

/**
 * Created by dengzh on 2018/4/18.
 */

public class App extends Application {

    public static Context ctx;
    public static int screenWidth;
    public static int screenHeight;


    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
        initConfig();
    }

    private void initConfig(){

        //屏幕信息
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

        //Log依赖库
        KLog.init(true);
    }




}
