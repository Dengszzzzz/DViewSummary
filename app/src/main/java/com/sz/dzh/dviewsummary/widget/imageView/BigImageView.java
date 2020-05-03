package com.sz.dzh.dviewsummary.widget.imageView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import androidx.annotation.Nullable;

import com.socks.library.KLog;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dengzh on 2020/3/24 0024.
 * 长图
 * 按比例缩放，减小质量，使用BitmapRegionDecoder
 *
 * 使用关键步骤：
 * InputStream is = getAssets().open("big.png");
 * BitmapRegionDecoder decoder = BitmapRegionDecoder.newInstance(is,false);
 * Bitmap  bitmap = decoder.decodeRegion(Rect,null);
 *
 * 在onDraw,调用canvas.drawBitmap();
 *
 * 滑动卡顿，考虑使用subsampling-scale-image-view
 */
public class BigImageView extends View implements GestureDetector.OnGestureListener, View.OnTouchListener {

    Rect mRect;
    BitmapFactory.Options mOptions;
    int mImageWidth;
    int mImageHeight;
    BitmapRegionDecoder mBitmapRegionDecoder;
    private  GestureDetector mGestureDetecotr;
    private Scroller mScroller;
    Matrix matrix;

    public BigImageView(Context context) {
        this(context,null);
    }

    public BigImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BigImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mRect = new Rect();
        mOptions = new BitmapFactory.Options();

        //手势
        mGestureDetecotr = new GestureDetector(context,this);
        //将触摸事件交给手势处理
        setOnTouchListener(this);
        //滑动帮助
        mScroller = new Scroller(context);

        matrix = new Matrix();
    }

    public void setImage(InputStream is){
        mOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(is,null,mOptions);

        mImageWidth = mOptions.outWidth;
        mImageHeight = mOptions.outHeight;

        mOptions.inMutable = true; //是否可复用
        mOptions.inPreferredConfig = Bitmap.Config.RGB_565;

        mOptions.inJustDecodeBounds = false;

        try {
            //false 不共享 图片源（也就是is关闭，BitmapRegionDecoder 也不会受到影响）
            mBitmapRegionDecoder = BitmapRegionDecoder.newInstance(is, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestLayout();
    }


    int mViewHeight;
    int mViewWidth;
    float mScale;
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mViewHeight = getMeasuredHeight();
        mViewWidth = getMeasuredWidth();

        if(mBitmapRegionDecoder == null){
            return;
        }

        mRect.left = 0;
        mRect.top  = 0;
        mRect.right = mViewWidth;

        //缩放因子
        mScale = mViewWidth/(float)mImageWidth;

        //x * mScale = mViewHeight
        mRect.bottom = (int) (mViewHeight/mScale);

        //方式一优化
        mOptions.inSampleSize = calcuteInSampleSize(mImageWidth,mImageHeight,mViewWidth,mViewHeight);
        //方式二优化
//        float temp = 1.0f/mScale;
//        if(temp>1){
//            //2的temp次方
//            mOptions.inSampleSize = (int) Math.pow(2,(int)temp);
//        }else{
//            mOptions.inSampleSize = 1;
//        }

        KLog.e("======缩放后=====");
        KLog.e("inSampleSize:" + mOptions.inSampleSize);
        KLog.e("图片宽:" + mImageWidth + "，图片高：" + mImageHeight);
        KLog.e("View宽:" + mViewWidth + "，View高：" + mViewHeight);
    }

    private static int calcuteInSampleSize(int w,int h,int maxW,int maxH){
        int inSampleSize = 1;
        //计算缩放比例
        if(w > maxW && h > maxH){
            inSampleSize = 2;
            while (w / inSampleSize > maxW && h / inSampleSize > maxH){
                inSampleSize *=2;
            }
        }
        return inSampleSize;
    }

    Bitmap bitmap = null;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mBitmapRegionDecoder == null){
            return;
        }

        mOptions.inBitmap = bitmap;
        bitmap = mBitmapRegionDecoder.decodeRegion(mRect,mOptions);

        KLog.e("图片大小：" + bitmap.getByteCount());


        matrix.setScale(mScale * mOptions.inSampleSize,mScale * mOptions.inSampleSize);

        canvas.drawBitmap(bitmap,matrix,null);
    }


    @Override
    public boolean onDown(MotionEvent e) {
        //如果滑动没有停止，强制停止
        if(!mScroller.isFinished()){
            mScroller.forceFinished(true);
        }
        //继续接收后续事件
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    //慢慢地滑
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //改变加载图片的区域
        mRect.offset(0, (int) distanceY);

        //bottom大于图片高了，或者top小于0了
        if(mRect.bottom > mImageHeight){
            mRect.bottom = mImageHeight;
            mRect.top = mImageHeight - (int) (mViewHeight/mScale);
        }
        if(mRect.top<0){
            mRect.top = 0;
            mRect.bottom = (int) (mViewHeight/mScale);
        }
        //重绘
        invalidate();
        return false;
    }

    //快速地滑
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        /**
         * startX:滑动开始的坐标
         * velocityX:以每秒像素为单位测量的初始速度
         * minX：x方向滚动的最小值
         * maxX:x方向滚动的最大值
         * */
        mScroller.fling(0,mRect.top,0, (int) -velocityY * 2,0,0,
                0,mImageHeight - (int) (mViewHeight/mScale));
        return false;
    }

    /**
     * 获取计算结果并重绘
     */
    @Override
    public void computeScroll() {
        //已经计算结束 return
        if(mScroller.isFinished()){
            return;
        }
        //true 表示当前动画未结束
        if(mScroller.computeScrollOffset()){
            mRect.top = mScroller.getCurrY();
            mRect.bottom = mRect.top + (int)(mViewHeight/mScale);
            invalidate();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //事件交给手势处理
        return mGestureDetecotr.onTouchEvent(event);
    }
}
