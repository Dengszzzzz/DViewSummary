package com.sz.dzh.dviewsummary.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by  on 2017/11/13.
 * 加载图片工具类
 * Glide
 * 1.
 * load(String string)	string可以为一个文件路径、uri或者url
 * load(Uri uri)	uri类型
 * load(File file)	文件
 * load(Integer resourceId)	资源Id,R.drawable.xxx或者R.mipmap.xxx
 * load(byte[] model)
 */

public class GlideUtils {

    //测试用图
    public static String url = "http://hbimg.b0.upaiyun.com/c1eb009f8bce5955766a87a8890fe6e9e730abf7b1c70-f1Aw6M_fw658";

    /**
     * 加载图片  网络
     *
     * @param context 如果是fragment/activity,则与生命周期绑定,如果是Applicaition 则不绑定
     * @param v
     * @param url     网络url
     */
    public static void loadImg(Context context, ImageView v, String url) {
        try {
            if (!isUiThread()) return;
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL);   //在load()和into()之间，可以串连添加各种功能。
            Glide.with(context)
                    .load(url)
                    .apply(options)
                    .into(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 加载图片 本地资源
     *
     * @param resourceId
     */
    public static void loadImg(Context context, ImageView v, Integer resourceId) {
        try {
            if (!isUiThread()) return;
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL);   //在load()和into()之间，可以串连添加各种功能。
            Glide.with(context)
                    .load(resourceId)
                    .apply(options)
                    .into(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void loadGift(Context context, ImageView v, Integer resId) {
        try {
            if (!isUiThread()) return;
            RequestOptions options = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.NONE);   //在load()和into()之间，可以串连添加各种功能。
            Glide.with(context)
                    .asGif()
                    .load(resId)
                    .apply(options)
                    .into(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 是否是UI线程
     *
     * @return
     */
    public static boolean isUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

}
