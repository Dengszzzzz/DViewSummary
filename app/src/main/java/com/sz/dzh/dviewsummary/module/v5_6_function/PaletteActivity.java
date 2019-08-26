package com.sz.dzh.dviewsummary.module.v5_6_function;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseActivity;
import com.sz.dzh.dviewsummary.utils.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dengzh on 2019/8/19 0019.
 * Palette
 * Palette（调色板），可以从Bitmap中提取出关键的颜色，其他控件通过设置这些颜色来优化界面色彩搭配。
 *
 * 参考:
 * https://www.jianshu.com/p/dfa9aac6143d
 */
public class PaletteActivity extends BaseActivity {

    @BindView(R.id.iv_sample)
    ImageView ivSample;
    @BindView(R.id.tv_vibrantColor)
    TextView tvVibrantColor;
    @BindView(R.id.tv_mutedColor)
    TextView tvMutedColor;
    @BindView(R.id.tv_darkVibrantColor)
    TextView tvDarkVibrantColor;
    @BindView(R.id.tv_darkMutedColor)
    TextView tvDarkMutedColor;
    @BindView(R.id.tv_lightVibrantColor)
    TextView tvLightVibrantColor;
    @BindView(R.id.tv_lightMutedColor)
    TextView tvLightMutedColor;

    private Bitmap mBitmap;
    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1566805432&di=3840e1f3624b55a20b0736c70454fd2f&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.pintu8.com%2Fuploads%2F2018%2F06%2F828c58e72e.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_palette);
        ButterKnife.bind(this);
        initToolBar("Palette 调色板");
        init();
    }

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.top_bg, null);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                handlePalette();
            }
        },2000);
    }

    private void handlePalette() {
        Palette.from(mBitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // 通过Palette 可以获取到一些颜色值。

                // 有活力的颜色（也可以说整个图片出现最多的颜色）（可传默认值）
                int vibrantColor = palette.getVibrantColor(Color.WHITE);
                // 柔和暗淡的颜色
                int mutedColor = palette.getMutedColor(Color.WHITE);
                // 有活力的暗色
                int darkVibrantColor = palette.getDarkVibrantColor(Color.WHITE);
                // 柔和的暗色
                int darkMutedColor = palette.getDarkMutedColor(Color.WHITE);
                // 有活力的亮色
                int lightvibrantColor = palette.getLightVibrantColor(Color.WHITE);
                // 柔和的亮色
                int lightMutedColor = palette.getLightMutedColor(Color.WHITE);

                tvVibrantColor.setBackgroundColor(vibrantColor);
                tvMutedColor.setBackgroundColor(mutedColor);
                tvDarkVibrantColor.setBackgroundColor(darkVibrantColor);
                tvDarkMutedColor.setBackgroundColor(darkMutedColor);
                tvLightVibrantColor.setBackgroundColor(lightvibrantColor);
                tvLightMutedColor.setBackgroundColor(lightMutedColor);


//                //获取某种特性颜色的样品
////              Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
//                Palette.Swatch lightVibrantSwatch = palette.getVibrantSwatch();
//                //谷歌推荐的：图片的整体的颜色rgb的混合值---主色调
//                int rgb = lightVibrantSwatch.getRgb();
//                //谷歌推荐：图片中间的文字颜色
//                int bodyTextColor = lightVibrantSwatch.getBodyTextColor();
//                //谷歌推荐：作为标题的颜色（有一定的和图片的对比度的颜色值）
//                int titleTextColor = lightVibrantSwatch.getTitleTextColor();
//                //颜色向量
//                float[] hsl = lightVibrantSwatch.getHsl();
//                //分析该颜色在图片中所占的像素多少值
//                int population = lightVibrantSwatch.getPopulation();


                mToolbar.setBackgroundColor(mutedColor);
            }
        });
    }
}
