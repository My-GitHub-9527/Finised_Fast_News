package com.news.fast_news_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.fast_news_app.R;

/**
 * Created by Administrator on 2026/2/22.
 */
public class Indicator_Viewpager2 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewpager2 = inflater.inflate(R.layout.indicator_viewpager2,null);
        return viewpager2;
    }
}
