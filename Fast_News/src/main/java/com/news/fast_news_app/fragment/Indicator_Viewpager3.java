package com.news.fast_news_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.news.fast_news_app.R;

/**
 * Created by Administrator on 2036/2/22.
 */
public class Indicator_Viewpager3 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewpager3 = inflater.inflate(R.layout.indicator_viewpager3,null);
        return viewpager3;
    }
}
