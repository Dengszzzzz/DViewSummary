package com.sz.dzh.dviewsummary.module.v8_function;

import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Rational;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.socks.library.KLog;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by dengzh on 2019/8/20
 * Android 8.0 画中画
 */
public class PipActivity extends BaseActivity {

    @BindView(R.id.btn_play)
    Button btnPlay;
    @BindView(R.id.btn_pip)
    Button btnPip;
    @BindView(R.id.jz_video)
    JzvdStd jzVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_pip_able);
        ButterKnife.bind(this);
        initToolBar("PIP模式");
        KLog.e(TAG, "onCreate()");
        init();
    }

    private void init(){
        jzVideo.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                , "饺子闭眼睛");
        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(jzVideo.thumbImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        KLog.e(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        KLog.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        KLog.e(TAG, "onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        KLog.e(TAG, "onStop()");
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        KLog.e(TAG, "onPictureInPictureModeChanged()");
       /* if(isInPictureInPictureMode){
            btnPip.setVisibility(View.GONE);
        }else{
            btnPip.setVisibility(View.VISIBLE);
        }*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        KLog.e(TAG, "onDestroy()");
    }


    @OnClick({R.id.btn_play, R.id.btn_pip})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                jzVideo.startVideo();
                break;
            case R.id.btn_pip:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    enterPicInPic();
                }
                break;
        }
    }

    /**
     * 进入PIP模式
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void enterPicInPic() {
        PictureInPictureParams.Builder builder = new PictureInPictureParams.Builder();
        // 设置宽高比例值，第一个参数表示分子，第二个参数表示分母
        // 下面的10/5=2，表示画中画窗口的宽度是高度的两倍
        Rational aspectRatio = new Rational(10, 5);
        // 设置画中画窗口的宽高比例
        builder.setAspectRatio(aspectRatio);
        // 进入画中画模式，注意enterPictureInPictureMode是Android8.0之后新增的方法
        enterPictureInPictureMode(builder.build());
    }


    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
