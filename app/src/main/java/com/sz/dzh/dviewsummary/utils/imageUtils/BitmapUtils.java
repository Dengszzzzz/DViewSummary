package com.sz.dzh.dviewsummary.utils.imageUtils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;

import com.socks.library.KLog;
import com.sz.dzh.dviewsummary.base.App;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Dengzh
 * on 2019/7/10 0010
 * 图片压缩、图片保存、通知图库更新
 */
public class BitmapUtils {

    private static String TAG = "BitmapUtils";

    /**
     * Bitmap及其相关类解释
     * 1.Bitmap：
     * Bitmap 在 Android 中指的是一张图片，可以是 png，也可以是 jpg等其他图片格式。
     * 作用是可以获取图像文件信息，对图像进行剪切、旋转、缩放、压缩等操作，并可以指定格式保存图像文件。
     *
     * 通过 Bitmap.createBitmap() 和 BitmapFactory的 decode 系列静态方法创建 Bitmap 对象。
     *
     * 2.Bitmap.Config
     *     ALPHA_8,     //每个像素占用1byte内存
     *     RGB_565,     //每个像素占用2byte内存（5+6+5)/8 = 2
     *     ARGB_4444,   //每个像素占用2byte内存
     *     ARGB_8888;   //每个像素占用4byte内存；默认模式 (8+8+8+8)/8 =4
     *
     * 3.BitmapFactory.Options
     * 用于解码Bitmap时的各种参数控制，下面介绍压缩中用到的那些
     *
     * inSampleSize：表示 Bitmap 的压缩比例，值必须 > 1 & 是2的幂次方。为2是指压缩宽高各1/2；
     * inJustDecodeBounds：为true时,执行decodeXXX方法时，仅会解析图片的原始宽高等信息，并不真正加载图片；
     * inPreferredConfig：用于配置图片解码方式，默认值为Bitmap.Config.ARGB_888；
     * outputWidth：返回的 Bitmap的宽；
     * outputHeight：返回的 Bitmap的高；
     * inDensity：表示这个Bitmap的像素密度，根据drawable目录
     *     inDensity赋值
     *           drawable-ldpi  	120
     * 	         drawable-mdpi  	160
     * 	         drawable-hdpi  	240
     * 	         drawable-xhdpi 	320
     * 	         drawable-xxhdpi 480
     * inTargetDensity：表示要被画出来时的目标（屏幕）的像素密度，代码中获取
     *      getResources().getDisplayMetrics().densityDpi
     * */

    /**
     * 常用压缩方法
     * 1.质量压缩
     * 质量压缩不会减少图片的像素，它是在保持像素的前提下改变图片的位深及透明度，来达到压缩图片的目的，图片的长，
     * 宽，像素都不会改变，那么bitmap所占内存大小是不会变的。
     * 注意：质量压缩对png格式图片没效，因为png是无损压缩。
     *
     * 2.宽高压缩
     * 一般用的是调节inSampleSize。
     * 1）采样率压缩，通过调节inSampleSize，缩放Bitmap的尺寸
     * 2）缩放法压缩（Matrix），通过矩阵对图片进行缩放。
     * 3）Bitmap.createScaledBitmap。
     *
     * 3.RGB_565压缩
     * 改用内存占用更小的编码格式来达到压缩的效果。Android默认的颜色模式为ARGB_8888，如果对透明度没有要求，可以把
     * 编码格式改为RGB_565，相比ARGB_8888将节省一半的内存开销。
     *
     * 注意点：
     * 1、质量压缩，不改变bitmap所占内存大小。
     * 2、一张图片所占内存大小计算方式：图片类型 * 宽 * 高
     *    bitmap.getByteCount() = bitmap.getConfig() * getWidth() * getHeight()。
     *    同一张图放到xhdpi 和 xxhdpi，内存计算出来是不一样的，因为如果放到xhdpi，而手机屏幕是xxhdpi，那么
     *    这张图的宽高会放大。
     * */

    /*********************************    图片压缩    *********************************************/

    /**
     * 压缩图片
     * 压缩要求，宽1080，高1920，文件大小不超过1M。
     * @param path  图片路径
     * */
    public static Bitmap getCompressBitmap(String path){
        Bitmap bitmap = getResizeBitmap(path,1080,1920,false) ;
        return getQualityBitmap(bitmap,1024);
    }

    /**
     * 宽高压缩
     * @param filePath  文件路径
     * @param maxW     目标宽度
     * @param maxH    目标高度
     * @param hasAlpha  是否需要透明度
     * @return
     */
    public static Bitmap getResizeBitmap(String filePath, int maxW, int maxH,boolean hasAlpha) {
        Bitmap bitmap = null;
        File f = new File(filePath);
        if (f.exists() && f.length() > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();

                //设置为true，再去解析，只解析out参数
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(filePath, options);
                int w = options.outWidth;
                int h = options.outHeight;
                KLog.e(TAG, "宽高压缩前图片宽度="+ w + "，高度=" + h);

                int inSampleSize = 1;
                //计算缩放比例
                if(w > maxW && h > maxH){
                    inSampleSize = 2;
                    while (w / inSampleSize > maxW && h / inSampleSize > maxH){
                        inSampleSize *=2;
                    }
                }
                options.inSampleSize = inSampleSize;

                //如果原图，宽比高大，则 宽/height，高/width比。否则，宽/width，高/height比。
//                if(picWidth>picHeight && (picWidth > height || picHeight > width)){
//                    options.inSampleSize = Math.max(options.outWidth / height, options.outHeight / width);
//                }else if(picWidth > width || picHeight > height){
//                    options.inSampleSize = Math.max(options.outWidth / width, options.outHeight / height);
//                }else{
//                    options.inSampleSize = 1;
//                }

                if(!hasAlpha){
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                //解析图片
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeFile(filePath, options);
                KLog.e(TAG, "宽高压缩后图片宽度="+ bitmap.getWidth() + "，高度=" + bitmap.getHeight()
                        + ",所占内存大小=" + bitmap.getByteCount()/ 1024 +"KB");
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return bitmap;
    }

    /**
     * 质量压缩
     * 这个方法只会改变图片的存储大小,不会改变bitmap的大小
     * @param bitmap  bitmap
     * @param maxFileSize 最大大小
     * @return Bitmap 压缩后bitmap
     */
    public static Bitmap getQualityBitmap(Bitmap bitmap, int maxFileSize) {
        if(bitmap == null){
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int quality = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG,quality,baos);
        int baosLength = baos.toByteArray().length;
        KLog.e(TAG, "质量压缩前所占内存大小=" + (bitmap.getByteCount() / 1024 +"KB")
                + "，文件大小（bytes.length）=" + (baosLength/ 1024) + "KB"
                + "，quality=" + quality);
        while (baosLength/1024 > maxFileSize){
            //清空baos
            baos.reset();
            quality = quality <= 10 ? quality - 1 : quality - 10;
            if (quality == 0) {
                break;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG,quality,baos);
            //将压缩后的图片保存到baos中
            baosLength = baos.toByteArray().length;
        }
        KLog.e(TAG, "质量压缩后所占内存大小=" + (bitmap.getByteCount() / 1024 +"KB")
                + "，文件大小（bytes.length）=" + (baosLength/ 1024) + "KB"
                + "，quality=" + quality);
        bitmap.recycle();
        bitmap = null;

        //最终目标Bitmap是经过压缩后，再decodeByteArray出来的，而decodeByteArray默认的是ARGB_8888，为了减少内存占用，
        //要用RGB_565编码解析。
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap targetBitmap = BitmapFactory.decodeByteArray(baos.toByteArray(),0,baosLength,options);
        KLog.e("BitmapUtils", "最终解析后所占内存大小" + (targetBitmap.getByteCount() / 1024 + "KB"));
        return targetBitmap;
    }





    /************************************   图片保存    ********************************************/
    /**
     * 时间戳作为文件名
     * @return
     */
    public static String getFileName(){
        return "DAS_" + System.currentTimeMillis();
    }

    /**
     * 文件目录
     * @return .../<application package>/files/
     */
    private static File getFilesDir(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            return App.ctx.getExternalFilesDir(null); //传null，访问的是files文件夹
        }
        return App.ctx.getFilesDir();
    }

    /**
     * 保存图片到  .../<application package>/files/image/ 下
     * @param bitmap
     * @param fileName
     * @return  是否保存成功
     */
    public static boolean saveImageInFileDirs(Context context,Bitmap bitmap, String fileName){
        boolean isSuccess = false;
        String path = getFilesDir() + "/image/";
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File file = new File(path, fileName + ".jpg");
        try {
            FileOutputStream out = new FileOutputStream(file);
            //format：JPEG, PNG 和 WEBP，保存JPEG比PNG格式的文件小。
            isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        KLog.e(TAG,"Bitmap已保存至" + file.getAbsolutePath());
        return isSuccess;
    }

    /**
     * 保存图片到 /storage/emulated/0/<application package>/DASImage/ 下
     * 且更新到图库
     * @param bitmap
     * @param fileName
     * @return 是否保存成功
     */
    public static boolean saveImageInSdCard(Bitmap bitmap, String fileName){
        boolean isSuccess = false;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            String path = Environment.getExternalStorageDirectory().getAbsolutePath() +
                    File.separator + App.ctx.getPackageName() +  File.separator + "DASImage";
            File dirFile = new File(path);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            File file = new File(path, fileName + ".jpg");
            try {
                FileOutputStream out = new FileOutputStream(file);
                //format：JPEG, PNG 和 WEBP，保存JPEG比PNG格式的文件小。
                isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();

                //通知图库更新
                Uri uri = Uri.fromFile(file);
                App.ctx.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            }catch (IOException e) {
                e.printStackTrace();
            }
            KLog.e(TAG,"Bitmap已保存至" + file.getAbsolutePath());
        }
        return isSuccess;
    }



}
