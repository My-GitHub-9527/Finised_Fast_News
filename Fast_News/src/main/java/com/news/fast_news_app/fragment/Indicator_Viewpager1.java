package com.news.fast_news_app.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.news.fast_news_app.R;
import com.news.fast_news_app.activity.Header_News_Activity;
import com.news.fast_news_app.activity.News_Detail_Pager_Style1;
import com.news.fast_news_app.adapter.NewsList_Adapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingLeftInAnimationAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

/**
 * Created by Administrator on 2016/2/22.
 */
public class Indicator_Viewpager1 extends Fragment {
    @Bind(R.id.wave_swipe)
    WaveSwipeRefreshLayout waveSwipe;
    private SwipeMenuListView newsList;
    private SliderLayout slider;
    private PagerIndicator customIndicator;
    /**
     * TextSliderView代表轮播的图片
     */
    private TextSliderView image_slider_1;
    private TextSliderView image_slider_2;
    private TextSliderView image_slider_3;
    private TextSliderView image_slider_4;
    private View header_news;
    public NewsList_Adapter newsListAdapter;
    private SwingLeftInAnimationAdapter swingLeftInAnimationAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewpager1 = inflater.inflate(R.layout.indicator_viewpager1, null);
        newsList = (SwipeMenuListView) viewpager1.findViewById(R.id.news_list);
        header_news = inflater.inflate(R.layout.news_header_layout, null);
        slider = (SliderLayout) header_news.findViewById(R.id.slider);
        customIndicator = (PagerIndicator) header_news.findViewById(R.id.custom_indicator);
        initImageSlider();
        initNewsList();
        createSwipeMenu();
        ButterKnife.bind(this, viewpager1);
        initWaveSwipeRefresh();
        return viewpager1;
    }

    private void initWaveSwipeRefresh() {
        waveSwipe.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 更新が終了したらインジケータ非表示
                        waveSwipe.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        }


    private void createSwipeMenu() {
        SwipeMenuCreator creator = new SwipeMenuCreator() {


            @Override
            public void create(SwipeMenu menu) {

                SwipeMenuItem openItem = new SwipeMenuItem(
                        getActivity());
                openItem.setBackground(new ColorDrawable(Color.GREEN));
                openItem.setWidth(240);
                openItem.setTitle("标为已读");
                openItem.setTitleSize(18);
                openItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(openItem);


                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getActivity());
                deleteItem.setBackground(new ColorDrawable(Color.RED));
                deleteItem.setWidth(190);
                deleteItem.setTitle("删除");
                deleteItem.setTitleSize(18);
                deleteItem.setTitleColor(Color.WHITE);
                menu.addMenuItem(deleteItem);

            }
        };
        newsList.setMenuCreator(creator);
        newsList.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                if (index == 0) {

                } else if (index == 1) {
                    newsListAdapter.newsItem_bean_List.remove(position);
                    newsListAdapter.notifyDataSetChanged();
                }

                return true;
            }
        });
    }


    /**
     * 初始化新闻列表
     */
    private void initNewsList() {
        newsList.addHeaderView(header_news);
        newsListAdapter = new NewsList_Adapter(getActivity());
        swingLeftInAnimationAdapter = new SwingLeftInAnimationAdapter(newsListAdapter);
        swingLeftInAnimationAdapter.setAbsListView(newsList);
        newsList.setAdapter(swingLeftInAnimationAdapter);
        newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), News_Detail_Pager_Style1.class));
            }
        });

    }

    /**
     * 初始化图片轮播库
     */
    private void initImageSlider() {

        //TextSliderView 代表轮播的图片
        image_slider_1 = new TextSliderView(this.getActivity());
        image_slider_1.description("大妈组团花千元买鱼 大明湖集体放生");//图片数量根据这几行代码重复添加
        //网络图片
        image_slider_1.image(R.mipmap.head_news1);
       /* //设置图片的转变动画，提供了 16 种
        slider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        //设置持续时间
        slider.setDuration(5000);
        slider.setCustomIndicator(customIndicator);
        //设置动画,(实现了描述文字的动画)
        slider.setCustomAnimation(new DescriptionAnimation());*/
        image_slider_1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Intent intent = new Intent(getActivity(), Header_News_Activity.class);
                startActivity(intent);
                //Toast.makeText(getContext(), "大妈组团花千元买鱼 大明湖集体放生", Toast.LENGTH_SHORT).show();
            }
        });


        image_slider_2 = new TextSliderView(this.getActivity());
        image_slider_2.description("南京数十万人观秦淮灯会 场面壮观");
        image_slider_2.image(R.mipmap.head_news2);
        /*slider.addSlider(image_slider_2);
        image_slider_2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                //startActivity(new Intent(getActivity(), Header_News_Activity.class));
                Toast.makeText(getContext(), "南京数十万人观秦淮灯会 场面壮观", Toast.LENGTH_SHORT).show();
            }
        });*/
        image_slider_2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                //startActivity(new Intent(getActivity(), Header_News_Activity.class));
                Toast.makeText(getContext(), "南京数十万人观秦淮灯会 场面壮观", Toast.LENGTH_SHORT).show();
            }
        });


        image_slider_3 = new TextSliderView(this.getActivity());
        image_slider_3.description("陕西戒毒所内女警与学员共庆元宵节");
        image_slider_3.image(R.mipmap.head_news3);
      /*  slider.addSlider(image_slider_3);
        image_slider_3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                //startActivity(new Intent(getActivity(), Header_News_Activity.class));
                Toast.makeText(getContext(), "陕西戒毒所内女警与学员共庆元宵节", Toast.LENGTH_SHORT).show();
            }
        });*/
        image_slider_3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                //startActivity(new Intent(getActivity(), Header_News_Activity.class));
                Toast.makeText(getContext(), "陕西戒毒所内女警与学员共庆元宵节", Toast.LENGTH_SHORT).show();
            }
        });

        image_slider_4 = new TextSliderView(this.getActivity());
        image_slider_4.description("2016春运落幕：哪些魂萦梦牵离家人");
        image_slider_4.image(R.mipmap.head_news4);
       /* slider.addSlider(image_slider_4);
        image_slider_4.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                //startActivity(new Intent(getActivity(), Header_News_Activity.class));
                Toast.makeText(getContext(), "2016春运落幕：哪些魂萦梦牵离家人", Toast.LENGTH_SHORT).show();
            }
        });*/
        image_slider_4.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                //startActivity(new Intent(getActivity(), Header_News_Activity.class));
                Toast.makeText(getContext(), "2016春运落幕：哪些魂萦梦牵离家人", Toast.LENGTH_SHORT).show();
            }
        });


        slider.addSlider(image_slider_1);
        slider.addSlider(image_slider_2);
        slider.addSlider(image_slider_3);
        slider.addSlider(image_slider_4);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }



}
