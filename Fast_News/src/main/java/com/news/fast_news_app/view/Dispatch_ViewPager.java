package com.news.fast_news_app.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/1/28.
 */
public class Dispatch_ViewPager extends ViewPager {
    public Dispatch_ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentItem() != 0) {
            getParent().requestDisallowInterceptTouchEvent(true);// 用getParent去请求,
            // 不拦截
        } else {// 如果是第一个页面,需要显示侧边栏, 请求父控件拦截
            getParent().requestDisallowInterceptTouchEvent(false);// 拦截
        }
        return super.dispatchTouchEvent(ev);
    }
}
