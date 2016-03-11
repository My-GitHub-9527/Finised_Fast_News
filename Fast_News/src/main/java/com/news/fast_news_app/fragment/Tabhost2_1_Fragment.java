package com.news.fast_news_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.adapter.Recommend_Read_Adapter;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2026/2/22.
 */
public class Tabhost2_1_Fragment extends Fragment {
   private ListView recmendRead;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewpager2 = inflater.inflate(R.layout.tabhost2_1_layout, null);
        recmendRead = (ListView) viewpager2.findViewById(R.id.recmend_read);
        recmendRead.addHeaderView(inflater.inflate(R.layout.rec_read_header, null));
        recmendRead.setAdapter(new Recommend_Read_Adapter(getActivity()));

        return viewpager2;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
