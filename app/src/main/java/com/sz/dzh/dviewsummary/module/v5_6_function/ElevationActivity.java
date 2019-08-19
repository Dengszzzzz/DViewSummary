package com.sz.dzh.dviewsummary.module.v5_6_function;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dengzh on 2019/8/19 0019.
 * 5.0之后View有了Z属性，Z属性由elevation 和 translationZ 组成。
 *
 * elevation：view的高度，高度越大，阴影越大。
 * transtionZ：view在Z方向移动的距离，一般用于属性动画中。
 */
public class ElevationActivity extends BaseActivity {

    @BindView(R.id.iv_sample)
    ImageView ivSample;
    @BindView(R.id.et_elevation)
    EditText etElevation;
    @BindView(R.id.et_translationZ)
    EditText etTranslationZ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_elevation);
        ButterKnife.bind(this);
        initToolBar("View的阴影");
        init();
    }

    private void init() {

    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        String elevation = etElevation.getText().toString().trim();
        String translationZ = etTranslationZ.getText().toString().trim();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivSample.setElevation(TextUtils.isEmpty(elevation)? 0:Integer.valueOf(elevation));
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivSample.setTranslationZ(TextUtils.isEmpty(translationZ)? 0:Integer.valueOf(translationZ));
        }
    }
}
