package com.sz.dzh.dviewsummary.utils;

import android.content.Context;

/**
 * Created by dengzh on 2020/3/24 0024.
 */
public class DensityUtils {

    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
