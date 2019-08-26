package com.sz.dzh.dviewsummary.module.v5_6_function;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengzh on 2019/8/19 0019.
 * 1、水波纹动画就是Android5.0以上，点击效果默认自带水波纹效果，并且有2种选择
 * 1）矩形边框水波纹
 * android:background="?android:attr/selectableItemBackground"
 * 20无边框限制水波纹
 * android:background="?android:attr/selectableItemBackgroundBorderless"
 *
 * 2、自定义水波纹动画
 * 1）使用ViewAnimationUtils创建圆形水波纹动画
 * 2）创建ripple的xml文件
 *
 * 3、视图状态选择器
 * 1）定义带有属性动画的状态选择器，在状态选择器中加入objectAnimator标签，然后
 * 通过stateListAnimator属性指定状态选择器的动画。
 * 2）定义带有帧动画的状态选择器设置给background属性。
 *
 * 参考：
 * https://www.jianshu.com/p/64a825915da9
 * https://blog.csdn.net/z_x_Qiang/article/details/75303069
 */
public class WaterRippleActivity extends BaseActivity {

    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_water_ripple);
        ButterKnife.bind(this);
        initToolBar("View的水波纹，状态选择器动画");
    }


    @OnClick({R.id.btn5, R.id.btn6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn5:
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(btn5, 0, btn5.getHeight(), 1f, btn5.getWidth() * 2);
                circularReveal.setDuration(1000);
                circularReveal.start();
                break;
            case R.id.btn6:
                break;
        }
    }
}
