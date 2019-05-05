package com.wangshen.mycontroctview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity implements OnBannerListener {
    private Banner banner;
    private List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        banner=findViewById(R.id.banner);
        banner.setImageLoader(new MyLoader());
        initData();
        banner.setImages(list);
        banner.setBannerAnimation(Transformer.Accordion);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.RIGHT)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();

    }
    private void initData(){
        list.add("http://a0.att.hudong.com/51/15/01300000165488121534157931952.jpg");
        list.add("http://pic29.nipic.com/20130601/12122227_123051482000_2.jpg");
        list.add("http://pic40.nipic.com/20140413/12524762_163417225134_2.jpg");
    }

    @Override
    public void OnBannerClick(int position) {

    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
