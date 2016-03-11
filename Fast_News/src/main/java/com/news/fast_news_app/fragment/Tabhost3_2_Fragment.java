package com.news.fast_news_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.adapter.Radio_Page_Adapter;

/**
 * Created by Administrator on 2026/2/22.
 */
public class Tabhost3_2_Fragment extends Fragment {


    private ListView radio_listview;
    private View viewpager2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewpager2 = inflater.inflate(R.layout.tabhost3_2_layout, null);
        radio_listview = (ListView) viewpager2.findViewById(R.id.radio_listview);
        radio_listview.setAdapter(new Radio_Page_Adapter(getActivity()));
        //radioListview.addHeaderView(inflater.inflate(R.layout.tab3_radio_header,null));
        return viewpager2;
    }


}
