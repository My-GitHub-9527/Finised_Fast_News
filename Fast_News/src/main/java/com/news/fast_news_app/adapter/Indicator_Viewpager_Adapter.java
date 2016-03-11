package com.news.fast_news_app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.news.fast_news_app.fragment.Indicator_Viewpager1;
import com.news.fast_news_app.fragment.Indicator_Viewpager10;
import com.news.fast_news_app.fragment.Indicator_Viewpager11;
import com.news.fast_news_app.fragment.Indicator_Viewpager2;
import com.news.fast_news_app.fragment.Indicator_Viewpager3;
import com.news.fast_news_app.fragment.Indicator_Viewpager4;
import com.news.fast_news_app.fragment.Indicator_Viewpager5;
import com.news.fast_news_app.fragment.Indicator_Viewpager6;
import com.news.fast_news_app.fragment.Indicator_Viewpager7;
import com.news.fast_news_app.fragment.Indicator_Viewpager8;
import com.news.fast_news_app.fragment.Indicator_Viewpager9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/22.
 * 设置ViewpagerIndicator标签下的viewpager页面的适配器
 */
public class Indicator_Viewpager_Adapter extends FragmentPagerAdapter {
    /**
     * 用来装载indicatorViewpager的集合
     */
    private List<Fragment> pagerList;
    /**
     * 定义viewpagerIndicator的标签数组
     */
    private static final String[] TABTITLE = new String[]{
            "北京", "中国", "国际", "体育", "生活", "旅游", "科技",
            "军事", "时尚", "财经", "育儿"
    };

    /**
     * @param fm
     * 构造方法
     */
    public Indicator_Viewpager_Adapter(FragmentManager fm) {
        super(fm);
        initIndicatorViewpager();
    }
    /**
     * 将每个标签下的页面包装成Fragment装进集合中
     */
    public void initIndicatorViewpager(){
        pagerList = new ArrayList<>();
        pagerList.add(new Indicator_Viewpager1());
        pagerList.add(new Indicator_Viewpager2());
        pagerList.add(new Indicator_Viewpager3());
        pagerList.add(new Indicator_Viewpager4());
        pagerList.add(new Indicator_Viewpager5());
        pagerList.add(new Indicator_Viewpager6());
        pagerList.add(new Indicator_Viewpager7());
        pagerList.add(new Indicator_Viewpager8());
        pagerList.add(new Indicator_Viewpager9());
        pagerList.add(new Indicator_Viewpager10());
        pagerList.add(new Indicator_Viewpager11());
    }
    @Override
    public Fragment getItem(int position) {
        return pagerList.get(position);
    }

    @Override
    public int getCount() {
        return pagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TABTITLE[position];
    }

}
