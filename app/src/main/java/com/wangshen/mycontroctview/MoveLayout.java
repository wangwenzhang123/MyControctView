package com.wangshen.mycontroctview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @name MyControctView
 * @class describe
 * @anthor 王文章
 * @time 2019/4/26 10:58
 * @change
 */
public class MoveLayout extends RelativeLayout {
    private List<MoveButton> moveButtons=new ArrayList<>();
    public MoveLayout(Context context) {
        super(context);
    }

    public MoveLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public void addButton(){
        MoveButton moveButton=new MoveButton(getContext());
        moveButton.setText("123456");
        moveButton.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        addView(moveButton);
        //invalidate();
    }
}
