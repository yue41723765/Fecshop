package com.gtjh.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;

import com.gtjh.common.R;

import static com.gtjh.common.util.DensityUtil.dip2px;

/**
 * Created by android on 2018/8/1.
 */

public class DeleteLineCheckView extends AppCompatCheckBox {

    private boolean flag=true;

    public DeleteLineCheckView(Context context) {
        super(context);
        //初始化Paint
        initPaint();
    }

    public DeleteLineCheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化Paint
        initPaint();
    }

    private void initPaint() {
        //删除线的颜色和样式
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(3);
    }

    private Paint paint;
    @Override
    protected void onDraw(Canvas canvas) {
        //TextView布局的高度和宽度
        float x = this.getWidth();
        float y = this.getHeight();
        //根据Textview的高度和宽度设置删除线的位置
        //四个参数的意思：起始x的位置，起始y的位置，终点x的位置，终点y的位置
        canvas.drawLine(0f, y/2f, x, y/2f, paint);
        //super最后调用表示删除线在位于文字的上边
        //super方法先调用删除线不显示
        super.onDraw(canvas);
    }


}
