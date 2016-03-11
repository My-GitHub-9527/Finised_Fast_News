package com.news.fast_news_app.bottom_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.news.fast_news_app.R;
import com.news.fast_news_app.adapter.Indicator_Viewpager_Adapter;
import com.news.fast_news_app.base_fragment.Base_Fragment;
import com.news.fast_news_app.fragment.Top_Fragment;
import com.news.fast_news_app.view.Dispatch_ViewPager;

/**
 * Created by Administrator on 2016/2/22.
 * 底部菜单的第一个页面
 */
public class Bottom_First extends Base_Fragment {

    private View bottom_view1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bottom_view1 = inflater.inflate(R.layout.tabhost_view1, null);
        Tag = "first";
        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.top,new Top_Fragment());
        ft.commit();
        setRelativedViewpager();
        return bottom_view1;


    }

    /**
     * 设置Viewpager和ViewpagerIndicator关联
     */
    public void setRelativedViewpager(){
        TabLayout mTabLayout = (TabLayout) bottom_view1.findViewById(R.id.tab_indicator);
        Dispatch_ViewPager mViewPager = (Dispatch_ViewPager) bottom_view1.findViewById(R.id.indicator_viewpager);
        Indicator_Viewpager_Adapter myPagerAdapter = new Indicator_Viewpager_Adapter(getChildFragmentManager());
        mTabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.setPageTransformer(true,new FlipHorizontalTransformer());
        //设置预加载的页数 ，这样就不会导致每次切换都会重新加载了
        mViewPager.setOffscreenPageLimit(10);
        mTabLayout.setupWithViewPager(mViewPager);
    }


}
