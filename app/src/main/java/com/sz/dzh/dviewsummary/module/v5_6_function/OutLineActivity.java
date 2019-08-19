package com.sz.dzh.dviewsummary.module.v5_6_function;

import android.graphics.Outline;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengzh on 2019/8/19 0019.
 * View的轮廓与裁剪   
 * 1、轮廓
 * 因为阴影效果才出现的，需要了解 Outline 和 ViewOutlineProvider
 *
 * android:outlineProvider的值
 * 值|作用
 * --|--
 * none | 即使设置了Z属性，也不会显示阴影
 * background | 会按照背景来设置阴影形状
 * bounds | 会按照View的大小来描绘阴影
 * paddedBounds | 和bounds类似，不过阴影会稍微向右偏移一点
 *
 * 2、裁剪
 * View.setClipToOutline(true); //进行裁剪
 * 注意：轮廓裁剪目前只支持圆形，矩形，圆角矩形，可以通过outline.canClip()判断是否能裁剪
 */
public class OutLineActivity extends BaseActivity {


    @BindView(R.id.iv_sample1_3)
    ImageView ivSample13;
    @BindView(R.id.iv_sample2_1)
    ImageView ivSample21;
    @BindView(R.id.iv_sample2_2)
    ImageView ivSample22;
    @BindView(R.id.iv_sample2_3)
    ImageView ivSample23;
    @BindView(R.id.iv_sample2_4)
    ImageView ivSample24;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_outline);
        ButterKnife.bind(this);
        initToolBar("View的轮廓与裁剪");
        init();
    }

    private void init() {
        handleCircleBg();
    }

    private void handleCircleBg() {
        //采用图片作为背景，要通过代码中指定轮廓来显示，且设置android:outlineProvider="background"
        ivSample13.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //可以指定圆形，矩形，圆角矩形，path
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
                if(outline.canClip()){  //判断轮廓是否支持裁剪，目前只支持圆形，矩形，圆角矩形
                    ivSample13.setClipToOutline(true); //进行裁剪
                }
            }
        });
    }


}
