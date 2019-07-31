package com.sz.dzh.dviewsummary.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Dengzh
 * on 2019/7/31 0031
 *
 * SnackBar
 * https://blog.csdn.net/lhy349/article/details/81096093
 */
public class FABAndSnackBarActivity extends BaseActivity {

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_fab_and_snackbar);
        ButterKnife.bind(this);
        initToolBar("FloatingActionButton");
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        //.make(...)  View一般是一个CoordinatorLayout对象，如果不是，弹出的Snackbar将覆盖FloatingActionButton控件。
        //.setAction() Snackbar中可以有一个按钮,显示在Snackbar的右边,用这个设置
        //.addCallback()  监听它的显示隐藏状态
        Snackbar.make(mFab, "这是一个snackbar", Snackbar.LENGTH_SHORT)
                .setAction("action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(mFab, "Action 被点击", Snackbar.LENGTH_SHORT).show();
                    }
                })
                .addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        ToastUtils.showToast("Snackbar隐藏");
                    }

                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        ToastUtils.showToast("Snackbar显示");
                    }
                })
                .show();
    }
}
