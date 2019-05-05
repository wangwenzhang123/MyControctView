package com.wangshen.mycontroctview;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.wangshen.mycontroctview.file.FileLogUtils;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout=findViewById(R.id.contan);
        btn=findViewById(R.id.btn5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LogFileUtils.getInstance().writeTxtToFile("45566822\n4556");
                startActivity(new Intent(MainActivity.this,AmapActivity.class));
                //getViewSize(constraintLayout);
             /*   FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");
                FileLogUtils.getInstance().write("123456");
                FileLogUtils.getInstance().write("abc");
                FileLogUtils.getInstance().write("ABC");
                FileLogUtils.getInstance().write("45sadasdas");*/

            }
        });
        //initScreen();
    }
    /**
     * 获取屏幕的宽高
     */
    private void initScreen() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;
        Log.e("MainActivity",""+width+"*"+height);// 屏幕高度（像素）
    }
    protected void getViewSize(View view) {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(w, h);
        int height = view.getMeasuredHeight();
        int width = view.getMeasuredWidth();
        Log.e("MainActivity",""+width+"*"+height);// 屏幕高度（像素）
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
