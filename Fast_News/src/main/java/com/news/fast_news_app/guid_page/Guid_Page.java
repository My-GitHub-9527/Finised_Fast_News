package com.news.fast_news_app.guid_page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.activity.MainActivity;
import com.news.fast_news_app.adapter.Guid_Viewpager_Adapter;
import com.tandong.swichlayout.SwitchLayout;

import java.util.ArrayList;
import java.util.List;

public class Guid_Page extends Activity {

    com.ryanharter.viewpager.ViewPager vp;//初始化控件
    Guid_Viewpager_Adapter vpa;//实例化适配器，进行传参数
    List<View> views;//存放viewpager的每个页面
    ImageView[] dots;//存放圆点图片数组
    int ids[] = {R.id.iv11,R.id.iv12,R.id.iv13,R.id.iv14};//存放圆点图片的ID数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        setContentView(R.layout.guid_page);//Viewpager控件和圆点图片的XML
        SwitchLayout.animDuration = 1000;
        SwitchLayout.ScaleToBigVerticalIn(this, false, null);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        initviews();//向list添加View和实例化适配器
        initdots();//初始化Imageview控件

    }
    public void enter(View v){

        //设置最后一张图片进入主界面的监听事件
        startActivity(new Intent(this, MainActivity.class));
        finish();//进入主界面后把当前的Viewpager给Finish掉

    }

    private void initdots() {
        dots = new ImageView[views.size()];
        for(int i=0;i<views.size();i++){
            dots[i] = (ImageView) findViewById(ids[i]);
        }
    }

    private void initviews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<>();
        views.add(inflater.inflate(R.layout.guid_1, null));
        views.add(inflater.inflate(R.layout.guid_2, null));
        views.add(inflater.inflate(R.layout.guid_3, null));
        views.add(inflater.inflate(R.layout.guid_4, null));
        vpa = new Guid_Viewpager_Adapter(views, this);
        vp = (com.ryanharter.viewpager.ViewPager) findViewById(R.id.pager);//找到Viewpager控件
        vp.setAdapter(vpa);//设置适配器
        //设置viewpager的动画效果
        vp.setPageTransformer(true,new com.ryanharter.viewpager.transforms.DepthPageTransformer());
        vp.setOnPageChangeListener(new com.ryanharter.viewpager.ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //当前新的页面被选中的时候调用
                for (int i = 0; i < views.size(); i++) {
                    if (position == i) {
                        dots[i].setImageResource(R.mipmap.notselected_dot);
                    } else {
                        dots[i].setImageResource(R.mipmap.selected_dot);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
