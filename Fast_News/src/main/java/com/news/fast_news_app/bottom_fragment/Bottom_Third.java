package com.news.fast_news_app.bottom_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.news.fast_news_app.R;
import com.news.fast_news_app.adapter.Indicator_BottomThird_Adapter;
import com.news.fast_news_app.base_fragment.Base_Fragment;
import com.news.fast_news_app.view.Dispatch_ViewPager;

/**
 * Created by Administrator on 2016/2/22.
 */
public class Bottom_Third extends Base_Fragment {

    private View bottom_view3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bottom_view3 = inflater.inflate(R.layout.tabhost_view3,null);
        Tag= "third";
        setRelativedViewpager();
        return bottom_view3;
    }

    /**
     * 设置Viewpager和ViewpagerIndicator关联
     */
    public void setRelativedViewpager() {
        TabLayout mTabLayout = (TabLayout) bottom_view3.findViewById(R.id.tab3_indicator);
        Dispatch_ViewPager mViewPager = (Dispatch_ViewPager) bottom_view3.findViewById(R.id.indicator_viewpager_tab3);
        Indicator_BottomThird_Adapter myPagerAdapter = new Indicator_BottomThird_Adapter(getChildFragmentManager());
        mTabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        //设置预加载的页数 ，这样就不会导致每次切换都会重新加载了
        //mViewPager.setOffscreenPageLimit(10);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
