package com.sz.dzh.dviewsummary.module.custom;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.socks.library.KLog;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.utils.ToastUtils;
import com.sz.dzh.dviewsummary.widget.MyView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewActivity extends BaseActivity {

    @BindView(R.id.myView)
    MyView mMyView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_my_view);
        ButterKnife.bind(this);

        mMyView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                KLog.d(TAG,"onTouch");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ToastUtils.showToast("onTouch 的 ACTION_DOWN");
                        KLog.d(TAG, "onTouch 的 ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        ToastUtils.showToast("onTouch 的 ACTION_MOVE" + "  x:" +  event.getX() +
                                "  y:" + event.getY());
                        KLog.d(TAG, "onTouch 的 ACTION_MOVE" + "  x:" +  event.getX() +
                                "  y:" + event.getY());
                        break;
                    case MotionEvent.ACTION_UP:
                        ToastUtils.showToast("onTouch 的 ACTION_UP");
                        KLog.d(TAG, "onTouch 的 ACTION_UP");
                        break;
                }
                return true;
            }
        });
    }

}
