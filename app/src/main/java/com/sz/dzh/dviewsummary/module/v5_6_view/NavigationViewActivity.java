package com.sz.dzh.dviewsummary.module.v5_6_view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dengzh
 * on 2019/7/31 0031
 * NavigationView + DrawerLayout
 *
 * NavigationView 其实只是一种布局格式，上面有header，下面有menu，看起来好看一些而已。
 */
public class NavigationViewActivity extends BaseActivity {

    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_navigation_view);
        ButterKnife.bind(this);
        initToolBar("NavigationView");
        initNavigationView();
    }

    private void initNavigationView(){

        //mToolbar联动
        /*mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT); //侧滑出来
            }
        });*/

        //HeaderView
        View headerView = mNavView.getHeaderView(0);
        TextView mTvName = headerView.findViewById(R.id.tv_name);
        mTvName.setText("Dengzsssss");

        //menu点击事件
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_share:
                        ToastUtils.showToast("分享");
                        break;
                    case R.id.action_collect:
                        ToastUtils.showToast("收藏");
                        break;
                    case R.id.action_go_shop:
                        ToastUtils.showToast("商店");
                        break;
                    case R.id.action_go_cart:
                        ToastUtils.showToast("购物车");
                        break;
                    case R.id.action_go_setting:
                        ToastUtils.showToast("设置");
                        break;
                }
                return false;
            }
        });
    }
}
