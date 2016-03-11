package com.news.fast_news_app.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/2/29.
 */
public class Guid_Viewpager_Adapter extends com.ryanharter.viewpager.PagerAdapter {
    private List<View> views;
    private Context context;

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    public Guid_Viewpager_Adapter(List<View> views, Context context) {
        this.views = views;
        this.context = context;
    }

}
