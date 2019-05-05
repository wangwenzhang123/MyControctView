package com.wangshen.mycontroctview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

/**
 * @name MyControctView
 * @class describe
 * @anthor 王文章
 * @time 2019/4/25 16:26
 * @change
 */
@SuppressLint("AppCompatCustomView")
public class MoveButton extends Button {
    private int width, height;
    private int maxWidth,maxHeight;
    public MoveButton(Context context) {
        super(context);
    }

    public MoveButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        ViewGroup viewGroup= (ViewGroup) getParent();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        assert wm != null;
        maxWidth = viewGroup.getWidth();
        maxHeight = viewGroup.getHeight();
        Log.e("MoveButton==","onMeasure");
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
        Log.e("MoveButton==","layout="+l+"   "+t+"   "+b+"   "+r);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("MoveButton==","onDraw");
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float downX = 0;
        float downY = 0;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // 点击动作处理 每次点击时将拖动状态改为 false 并且记录下点击时的坐标 downX downY
                downX = event.getX(); // 点击触屏时的x坐标 用于离开屏幕时的x坐标作计算
                downY = event.getY(); // 点击触屏时的y坐标 用于离开屏幕时的y坐标作计算
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                final float moveX = event.getX() - downX;
                final float moveY = event.getY() - downY;
                int l=0, r=0, t=0, b=0; // 上下左右四点移动后的偏移量
                //计算偏移量 设置偏移量 = 3 时 为判断点击事件和滑动事件的峰值
                if (Math.abs(moveX) > 3 || Math.abs(moveY) > 3) { // 偏移量的绝对值大于 3 为 滑动时间 并根据偏移量计算四点移动后的位置
                    l = (int) (getLeft() + moveX);
                    r = l + width;
                    t = (int) (getTop() + moveY);
                    b = t + height;
                    //不划出边界判断,最大值为边界值
                    // 如果你的需求是可以划出边界 此时你要计算可以划出边界的偏移量 最大不能超过自身宽度或者是高度  如果超过自身的宽度和高度 view 划出边界后 就无法再拖动到界面内了 注意
                    if (l < 0) { // left 小于 0 就是滑出边界 赋值为 0 ; right 右边的坐标就是自身宽度 如果可以划出边界 left right top bottom 最小值的绝对值 不能大于自身的宽高
                        l = 0;
                        r = l + width;
                    } else if (r > maxWidth) { // 判断 right 并赋值
                        r = maxWidth;
                        l = r - width;
                    }
                    if (t < 0) { // top
                        t = 0;
                        b = t + height;
                    } else if (b > maxHeight) { // bottom
                        b = maxHeight;
                        t = b - height;
                    }
                    this.layout(l, t, r, b);
                }

                break;
        }
        return super.onTouchEvent(event);
    }
}


