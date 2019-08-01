package com.sz.dzh.dviewsummary.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dengzh
 * on 2019/8/1 0001
 * TextInputLayout 继承 LinearLayout，主要是作为EditText的父容器，它只能有一个EditText，
 * 且它的属性也只对EditText生效，如果在它里面添加其他View，则只是addView()进去而已。
 * 常见的功能有Hint字符串自动移到左上角，设置最大字符数及错误提示，设置错误提示文字，设置密码是否可见等。
 * 其实TextInputLayout 是应该搭配TextInputEditText 使用的，用EditText虽然不至于报错，但会打印info建议我们替换。
 *
 * 常用属性:
 * 属性名|作用
 * --|--
 * app:hint | 设置浮动提示语，在EditText或 til中选一个设置即可
 * app:hintEnabled | 设置是否开启浮动功能，默认为true
 * app:hintAnimationEnabled | 设置是否开启浮动提示动画，默认为true
 * app:errorEnabled | 设置是否开启错误提示
 * app:counterEnabled | 设置是否开启计数器
 * app:counterMaxLength | 设置计数器的最大长度，超过并不影响输入，但是计数字符串会变色
 * app:counterOverflowTextAppearance | 设置超出字符数后提示文字的颜色，默认为@color/colorAccent
 * app:passwordToggleEnabled | 设置是否开启密码可见开关(EditText必须为password类型才起作用)
 * app:passwordToggleDrawable | 设置密码可见/不可见开关的图标
 * app:boxBackgroundColor | til的背景色，如果用android:background设置背景色，那么boxCornerRadiusXXX等效果就失效了
 * app:boxBackgroundMode | 3种，filled、outline、none。其实Til和Et之间是有一个间距的，用来显示上移的hint，filled的时候，这个间距也在Box范围内；outline则是把间距取消了，hint会覆盖在Box上。
 * app:boxCornerRadiusTopStart | 背景的圆角，左上角
 * app:boxCornerRadiusTopEnd  | 右上角
 * app:boxCornerRadiusBottomStart | 左下角
 * app:boxCornerRadiusBottomEnd  | 右下角
 *
 */
public class TextInputLtActivity extends BaseActivity {

    @BindView(R.id.et_3)
    EditText mEt3;
    @BindView(R.id.til_3)
    TextInputLayout mTil3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_text_input_layout);
        ButterKnife.bind(this);
        initToolBar("TextInputLayout、TextInputEt");

        setErrorEnabled();
    }

    private void setErrorEnabled(){
        mEt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().contains("@")){
                    mTil3.setError("用户名不允许有@符号");
                    mTil3.setErrorEnabled(true);
                }else{
                    mTil3.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
