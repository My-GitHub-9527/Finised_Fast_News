package com.news.fast_news_app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.news.fast_news_app.fragment.Tabhost2_1_Fragment;
import com.news.fast_news_app.fragment.Tabhost2_2_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/22.
 * 设置第二个底部菜单ViewpagerIndicator标签下的viewpager页面的适配器
 */
public class Indicator_BottomSecond_Adapter extends FragmentPagerAdapter {
    /**
     * 用来装载indicatorViewpager的集合
     */
    private List<Fragment> pagerList;
    /**
     * 定义viewpagerIndicator的标签数组
     */
    private static final String[] TABTITLE = new String[]{
            "推荐阅读", "我的订阅"
    };

    /**
     * @param fm
     * 构造方法
     */
    public Indicator_BottomSecond_Adapter(FragmentManager fm) {
        super(fm);
        initIndicatorViewpager();
    }
    /**
     * 将每个标签下的页面包装成Fragment装进集合中
     */
    public void initIndicatorViewpager(){
        pagerList = new ArrayList<>();
        pagerList.add(new Tabhost2_1_Fragment());
        pagerList.add(new Tabhost2_2_Fragment());

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
