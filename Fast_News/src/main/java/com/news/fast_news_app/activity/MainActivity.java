package com.news.fast_news_app.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.base_fragment.Base_Fragment;
import com.news.fast_news_app.bottom_fragment.Bottom_Fifth;
import com.news.fast_news_app.bottom_fragment.Bottom_First;
import com.news.fast_news_app.bottom_fragment.Bottom_Fourth;
import com.news.fast_news_app.bottom_fragment.Bottom_Second;
import com.news.fast_news_app.bottom_fragment.Bottom_Third;
import com.news.fast_news_app.view.My_FragmentTabHost;
import com.tandong.swichlayout.BaseEffects;
import com.tandong.swichlayout.SwitchLayout;

/**
 *
 */
public class MainActivity extends FragmentActivity {


    //定义FragmentTabHost对象
    private My_FragmentTabHost mTabHost;

    //定义一个布局
    private LayoutInflater layoutInflater;

    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {Bottom_First.class, Bottom_Second.class, Bottom_Third.class, Bottom_Fourth.class, Bottom_Fifth.class};

    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.bottom_first, R.drawable.bottom_second, R.drawable.bottom_third,
            R.drawable.bottom_fourth, R.drawable.bottom_fifth};

    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页", "消息", "好友", "广场", "更多"};
    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_main);
        SwitchLayout.animDuration = 3000;
        SwitchLayout.ScaleBig(this, false, BaseEffects.getQuickReScrollEffect());

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        initFragmentTabHost();

    }

    /**
     * 初始化FragmentTabHost
     */

    public void initFragmentTabHost() {
        fm = getSupportFragmentManager();
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);

        //实例化TabHost对象，得到TabHost
        mTabHost = (My_FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, fm, R.id.realtabcontent);

        //得到fragment的个数
        int count = fragmentArray.length;

        for (int i = 0; i < count; i++) {
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);

            //设置Tab按钮的背景
            //mTabHost.getTabWidget().getChildAt(i).setAlpha(0.8f);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.color.bottom_bg);
            mTabHost.getTabWidget().setMinimumHeight(100);
            mTabHost.getTabWidget().setDividerDrawable(null);
            mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    if (tabId.equals("更多")) {

                    } else if (tabId.equals("消息")) {

                    } else {

                    }
                }
            });
        }
    }

    /**
     * 给底部TabHost按钮设置图标和文字
     */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tabhost_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            for (Fragment item : fm.getFragments()) {

                Base_Fragment base_fragment = (Base_Fragment) item;

                if (base_fragment.Tag.equals("login")) {
                    Bottom_Fifth login =   (Bottom_Fifth) base_fragment;

                    Log.d("My", data.getStringExtra("nickname"));
                    login.updateLoginState(data.getStringExtra("nickname"), data.getStringExtra("imgUrl"));
                }
            }

        }else if(resultCode==110){
            Bitmap cameraBitmap = (Bitmap) data.getExtras().get("cameraBitmap");
            for (Fragment item : fm.getFragments()) {

                Base_Fragment base_fragment = (Base_Fragment) item;

                if (base_fragment.Tag.equals("login")) {
                    Bottom_Fifth Mylogin = (Bottom_Fifth) base_fragment;
                    Mylogin.updateIcon(cameraBitmap);
                }
            }
        }else if(resultCode==120){

            for (Fragment item : fm.getFragments()) {

                Base_Fragment base_fragment = (Base_Fragment) item;

                if (base_fragment.Tag.equals("login")) {
                    Bottom_Fifth Mylogin = (Bottom_Fifth) base_fragment;
                    Mylogin.cleanAcount();
                }
            }
        }else if(resultCode==130){

            String updateNickName = data.getStringExtra("updateNickName");
            for (Fragment item : fm.getFragments()) {

                Base_Fragment base_fragment = (Base_Fragment) item;

                if (base_fragment.Tag.equals("login")) {
                    Bottom_Fifth Mylogin = (Bottom_Fifth) base_fragment;
                    Mylogin.updateNickName(updateNickName);
                }
            }
        }

    }
}


