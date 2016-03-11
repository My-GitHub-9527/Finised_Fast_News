package com.news.fast_news_app.bottom_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.news.fast_news_app.R;
import com.news.fast_news_app.adapter.Indicator_BottomSecond_Adapter;
import com.news.fast_news_app.base_fragment.Base_Fragment;
import com.news.fast_news_app.view.Dispatch_ViewPager;

/**
 * Created by Administrator on 2016/2/22.
 */
public class Bottom_Second extends Base_Fragment {


    private View bottom_view2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bottom_view2 = inflater.inflate(R.layout.tabhost_view2, null);
        Tag = "second";
        setRelativedViewpager();
        return bottom_view2;
    }

    /**
     * 设置Viewpager和ViewpagerIndicator关联
     */
    public void setRelativedViewpager() {
        TabLayout mTabLayout = (TabLayout) bottom_view2.findViewById(R.id.tab2_indicator);
        Dispatch_ViewPager mViewPager = (Dispatch_ViewPager) bottom_view2.findViewById(R.id.indicator_viewpager_tab2);
        Indicator_BottomSecond_Adapter myPagerAdapter = new Indicator_BottomSecond_Adapter(getChildFragmentManager());
        mTabLayout.setTabsFromPagerAdapter(myPagerAdapter);
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.setPageTransformer(true,new AccordionTransformer());
        //设置预加载的页数 ，这样就不会导致每次切换都会重新加载了
        //mViewPager.setOffscreenPageLimit(10);
        mTabLayout.setupWithViewPager(mViewPager);
    }


}
