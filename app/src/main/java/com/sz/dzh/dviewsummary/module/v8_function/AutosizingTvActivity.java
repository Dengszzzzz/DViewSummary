package com.sz.dzh.dviewsummary.module.v8_function;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengzh on 2019/8/20
 * Autosizing TextView
 * 自动调整文本大小的TextView，当TextView的布局边界尺寸发生变化时，文本大小可以跟着自动缩放调整。文本的自动缩放支持两种模式，粒度型和预置大小型。
 *
 * 属性|作用
 * -|-
 * app:autoSizeTextType |   none（默认，表示不自动缩放）、uniform（横、纵缩放）。
 * app:autoSizeMinTextSize | 自动缩放字体大小最小值
 * app:autoSizeMaxTextSize | 自动缩放字体最大值
 * app:autoSizeStepGranularity |  每次缩放得步长，粒度型
 * app:autoSizePresetSizes | 每次缩放预置得尺寸，预置大小型
 *
 * 代码出自：
 * https://blog.csdn.net/dale999/article/details/70145152?locationNum=9&fps=1
 */
public class AutosizingTvActivity extends BaseActivity {


    @BindView(R.id.cb)
    CheckBox cb;
    @BindView(R.id.tv_auto)
    TextView tvAuto;
    @BindView(R.id.tv_auto_preset)
    TextView tvAutoPreset;

    private TextView mTarget;
    private float mChangeStep;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_autosizing_tv);
        ButterKnife.bind(this);
        initToolBar("自动缩放文本视图");

        mChangeStep = getResources().getDisplayMetrics().density * 2;
        updateTvVisibility(cb.isChecked());
        cb.setOnCheckedChangeListener((buttonView, isChecked) -> updateTvVisibility(isChecked));
    }


    private void updateTvVisibility(boolean isPreset) {
        if (isPreset) {
            tvAutoPreset.setVisibility(View.VISIBLE);
            tvAuto.setVisibility(View.GONE);
            mTarget = tvAutoPreset;
        } else {
            tvAutoPreset.setVisibility(View.GONE);
            tvAuto.setVisibility(View.VISIBLE);
            mTarget = tvAuto;
        }
    }


    @OnClick({R.id.btn_plus, R.id.btn_minus})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                FrameLayout.LayoutParams ll = (FrameLayout.LayoutParams) mTarget.getLayoutParams();
                ll.width += mChangeStep;
                ll.height += mChangeStep;
                mTarget.setLayoutParams(ll);
                break;
            case R.id.btn_minus:
                FrameLayout.LayoutParams ll2 = (FrameLayout.LayoutParams) mTarget.getLayoutParams();
                ll2.width -= mChangeStep;
                ll2.height -= mChangeStep;
                mTarget.setLayoutParams(ll2);
                break;
        }
    }
}
