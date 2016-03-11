package com.news.fast_news_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.adapter.Video_Play_Adapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2026/2/22.
 */
public class Tabhost3_1_Fragment extends Fragment {
    @Bind(R.id.video_listview)
    ListView videoListview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewpager2 = inflater.inflate(R.layout.tabhost3_1_layout, null);
        ButterKnife.bind(this, viewpager2);
        videoListview.setAdapter(new Video_Play_Adapter(getActivity()));
        videoListview.addHeaderView(inflater.inflate(R.layout.tab3_video_header,null));
        return viewpager2;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
