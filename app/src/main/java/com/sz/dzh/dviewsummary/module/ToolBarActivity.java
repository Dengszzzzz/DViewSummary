package com.sz.dzh.dviewsummary.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toolbar;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dengzh
 * on 2019/7/30 0030
 * 工具栏（标题栏），代替ActionBar，功能强大，提供了logo，标题，子标题等属性。
 * 一般开发中都会要标题居中，可以在ToolBar中放置一个TextView来实现。
 * 如果需要在工具栏右边放置一些按钮，如常见的又分享按钮、购物车跳转按钮等，可以用结合menu文件来实现。
 * <p>
 * 此外可以结合AppBarLayout、CoordinatorLayout、CollapsingToolbarLayout 来实现一些炫酷的效果
 */
public class ToolBarActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar2)
    Toolbar mToolbar2;
    @BindView(R.id.toolbar3)
    Toolbar mToolbar3;
    @BindView(R.id.toolbar4)
    android.support.v7.widget.Toolbar mToolbar4;
    @BindView(R.id.toolbar5)
    android.support.v7.widget.Toolbar mToolbar5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_toolbar);
        ButterKnife.bind(this);
        initToolbar();
        initToolbar2();
        initToolbar3();
        initToolbar4();
        initToolbar5();
    }

    /**
     * Toolbar 基础演示
     * 可以设置导航按钮、logo、标题和子标题、多个视图、动作菜单(action menu)
     */
    private void initToolbar() {
        mToolbar.setNavigationOnClickListener(view -> finish());
    }

    /**
     * Toolbar2
     * 常见的标题栏———— 标题居中,左边返回键。
     */
    private void initToolbar2() {
        mToolbar2.setNavigationOnClickListener(view -> finish());
    }

    /**
     * Toolbar3
     * 常见的标题栏———— 标题居中,左边返回键，且右边带有特定按键。
     * 由于没用v7库的toolbar，menu设置的app:showAsAction="ifRoom" 不生效。
     */
    private void initToolbar3() {
        mToolbar3.inflateMenu(R.menu.toolbar_menu);
        mToolbar3.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
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
        });
        mToolbar3.setNavigationOnClickListener(view -> finish());
    }

    /**
     * Toolbar4
     * v7库的toolbar，menu设置的app:showAsAction="ifRoom" 生效。
     */
    private void initToolbar4() {
        mToolbar4.inflateMenu(R.menu.toolbar_menu);
        mToolbar4.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
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
        });
        mToolbar4.setNavigationOnClickListener(view -> finish());
    }


    /**
     * Toolbar4
     * 自定义menu的样式，调整toolbar上两个menu之间的间距，弹出菜单的位置，还有菜单的背景和文字颜色
     *
     * app:theme       设置ToolBar的样式
     * app:popupTheme  设置弹出菜单的样式
     */
    private void initToolbar5() {
        mToolbar5.inflateMenu(R.menu.toolbar_menu);
        mToolbar5.setOnMenuItemClickListener(menuItem -> {
            switch (menuItem.getItemId()) {
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
            return true;
        });
        mToolbar5.setNavigationOnClickListener(view -> finish());
    }
}
