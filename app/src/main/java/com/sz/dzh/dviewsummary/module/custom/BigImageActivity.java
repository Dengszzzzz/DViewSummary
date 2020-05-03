package com.sz.dzh.dviewsummary.module.custom;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.widget.imageView.BigImageView;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengzh on 2020/3/24 0024.
 */
public class BigImageActivity extends BaseActivity {

    @BindView(R.id.iv_big)
    BigImageView ivBig;
    @BindView(R.id.iv_sciv)
    SubsamplingScaleImageView ivSciv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_big_image);
        ButterKnife.bind(this);
        test2();
    }

    private void test1(){
        InputStream is = null;
        try {
            is = getAssets().open("big.jpg");
            ivBig.setImage(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void test2(){
        ivSciv.setImage(ImageSource.asset("big.jpg"));
    }
}
