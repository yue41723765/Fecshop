package com.gtjh.user.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.gtjh.common.util.DensityUtil;

import java.util.Random;

/**
 * Created by android on 2018/7/5.
 */

public class Code {
    /**
     * 绘制流程
     * 1,先绘制一个矩形
     * 2,在矩形里面绘制验证码
     *
     * @param context
     * @return
     */
    public Bitmap create(Context context) {
        String[] result = getResource();
        int w = DensityUtil.dip2px(context, 400);
        int h = DensityUtil.dip2px(context, 120);
        Bitmap mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);//在这个bitmap上绘制验证码
        Paint mPaint = new Paint();//画笔
        Matrix mMatrix = new Matrix();//3*3矩阵
        mPaint.setTextSize(h / 2);//高度的一半
        mPaint.setAntiAlias(true);//设置抗锯齿
        mPaint.setFakeBoldText(true);//粗体
        mPaint.setColor(0xFFD0CCC7);
        mCanvas.drawRect(0, 0, w, h, mPaint);//绘制矩形

        mPaint.setColor(getRandomColor(255, 255, 255));
        mCanvas.drawText(result[0], w / 10, h / 2, mPaint);//第一个数字
        mMatrix.setRotate(10);
        mCanvas.setMatrix(mMatrix);

        mPaint.setColor(getRandomColor(255, 255, 255));
        mCanvas.drawText(result[1], w * 2 / 5, h / 2, mPaint);//第二个数字
        mMatrix.setRotate(15);

        mPaint.setColor(getRandomColor(255, 255, 255));
        mCanvas.drawText(result[2], w * 3 / 5, h / 2 - 10, mPaint);//第三个数字
        mMatrix.setRotate(15);

        mPaint.setColor(getRandomColor(255, 255, 255));
        mCanvas.drawText(result[3], w * 4 / 5, h / 2 - 15, mPaint);//第四个数字
        mMatrix.setRotate(10);

        //接下来绘制背景障碍,绘制短线条
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;

        for (int i = 0; i < 50; i++) {
            startX = getRandomPosition(w);
            startY = getRandomPosition(h);
            endX = getRandomPosition(15);
            endY = getRandomPosition(15);
            mPaint.setColor(getRandomColor(255, 255, 255));
            mCanvas.drawLine(startX, startY - 20, startX + endX, startY + endY - 20, mPaint);
        }

        mCanvas.save();
        return mBitmap;

    }

    private String result;

    public String getResult() {
        return result;
    }

    private String[] getResource() {
        String[] datas = new String[4];
        for (int i = 0; i < 4; i++) {
            datas[i] = String.valueOf(mRandom.nextInt(10));
        }
        result = arrayToString(datas);
        return datas;
    }

    private String arrayToString(String[] datas) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < datas.length; i++) {
            sb.append(datas[i]);        //append String并不拥有该方法，所以借助StringBuffer
        }
        String sb1 = sb.toString();
        return sb1;
    }

    /**
     * 随机工具类
     */
    private Random mRandom = new Random();

    /**
     * 获取随机点,不超过宽高
     *
     * @param n
     * @return
     */
    private int getRandomPosition(int n) {
        return mRandom.nextInt(n);
    }

    /**
     * 获取随机颜色
     *
     * @param r (0 ~ 255)
     * @param g (0 ~ 255)
     * @param b (0 ~ 255)
     * @return
     */
    private int getRandomColor(int r, int g, int b) {
        if (r > 255)
            r = 255;
        if (g > 255)
            g = 255;
        if (b > 255)
            b = 255;

        int mr = mRandom.nextInt(r);
        int mg = mRandom.nextInt(g);
        int mb = mRandom.nextInt(b);

        return Color.rgb(mr, mg, mb);
    }
}
