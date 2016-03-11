package com.news.fast_news_app.bottom_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.adapter.Tab4_Adapter;
import com.news.fast_news_app.base_fragment.Base_Fragment;

/**
 * Created by Administrator on 2016/2/22.
 */
public class Bottom_Fourth extends Base_Fragment {

    private ListView tab4_listview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View bottom_view4 = inflater.inflate(R.layout.tabhost_view4,null);
       Tag = "fouth";
        tab4_listview = (ListView) bottom_view4.findViewById(R.id.tab4_listview);
        tab4_listview.setAdapter(new Tab4_Adapter(getActivity()));
        return bottom_view4;
    }
}
