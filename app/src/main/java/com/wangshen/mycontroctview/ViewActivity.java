package com.wangshen.mycontroctview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @name MyControctView
 * @class describe
 * @anthor 王文章
 * @time 2019/4/25 16:40
 * @change
 */
public class ViewActivity extends Activity {
    private MoveLayout moveLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        moveLayout=findViewById(R.id.move_layout);
        moveLayout.addButton();
    }
    public void onAdd(View view){
        moveLayout.addButton();
    }
}
