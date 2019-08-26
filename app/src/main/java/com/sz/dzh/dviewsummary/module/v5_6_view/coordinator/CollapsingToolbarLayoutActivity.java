package com.sz.dzh.dviewsummary.module.v5_6_view.coordinator;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 * CollapsingToolbarLayout简单演示
 *
 * CollapsingToolbarLayout是用来对Toolbar进行再次包装的ViewGroup，
 * 主要是用于实现折叠（其实就是看起来像伸缩~）的App Bar效果。
 * 它需要放在AppBarLayout布局里面，并且作为AppBarLayout的直接子View。
 *
 *
 * 主要功能：
 * 1.折叠Title（Collapsing title）：
 *   title随着布局内容变小而变小，通过setTitle来设置title，CollapsingToolbarLayout的setTitle比Toolbar的
 *   setTitle优先级高，且设置titleColor不能再toolbar设置了。
 * 2.内容纱布（Content scrim）：
 *   根据滚动的位置是否到达一个阀值，来决定是否对View“盖上纱布”。
 *   通过setContentScrim(Drawable)来设置纱布的图片，默认colorPrimary的色值。
 * 3.状态栏纱布（Status bar scrim)：
 *   根据滚动位置是否到达一个阀值，来决定是否对状态栏“盖上纱布”。
 *   通过setStatusBarScrim(Drawable)来设置纱布图片，默认colorPrimaryDark的色值。
 * 4.视差滚动子View(Parallax scrolling children):
 *   将app:layout_collapseMode设为parallax，让View的滚动的速度比其他正常滚动的View速度稍微慢一点。
 * 5.将子View位置固定(Pinned position children)：
 *   将app:layout_collapseMode设为pin，子View可以选择是否在全局空间上固定位置，这对于Toolbar来说非常有用，
 *   因为当布局在移动时，可以将Toolbar固定位置而不受移动的影响。。
 *
 *
 * 简单示例总结：
 * 1.实际上就是把原来Toolbar的一些属性操作，放到CollapsingToolbarLayout里了。
 * 2.CollapsingToolbarLayout的setTitle比Toolbar的setTitle优先级高。
 * 3.Toolbar设置titleColor无效，在CollapsingToolbarLayout 可以通过theme来设置titleColor。
 * 4.CollapsingToolbarLayout 设置 app:layout_scrollFlags="scroll|exitUntilCollapsed"，
 *   Toolbar的Height就是它的minHeight。
 * 5.常用都是Toolbar 设置 app:layout_collapseMode="pin"。
 *
 */
public class CollapsingToolbarLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_collapsing_toolbar_layout);
        //initToolBar("CollapsingToolbarLayout 简单演示");
    }
}
