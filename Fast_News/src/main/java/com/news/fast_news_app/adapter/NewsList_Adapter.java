package com.news.fast_news_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.bean.NewsItem_bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/23.
 */
public class NewsList_Adapter extends BaseAdapter {

    private int styleCount = 3;
    private ViewHolder holder;
    private Context mcontext;

    public NewsList_Adapter(Context context) {
        mcontext = context;
        initNewsItem_List();
    }

    /**
     * 装载新闻数据的集合
     */
    public List<NewsItem_bean> newsItem_bean_List = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        return newsItem_bean_List != null ? newsItem_bean_List.get(position).style : -1;
    }

    @Override
    public int getViewTypeCount() {
        return styleCount;
    }

    @Override
    public int getCount() {
        return newsItem_bean_List.size();
    }

    @Override
    public NewsItem_bean getItem(int position) {
        return newsItem_bean_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();

            switch (getItem(position).style) {
                case 0:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.newsitem_style_1, null);
                    holder.iv_NewsItem1 = (ImageView) convertView.findViewById(R.id.iv_newsitem1);
                    holder.tv_Tilte = (TextView) convertView.findViewById(R.id.tv_title);
                    holder.tv_SubTilte = (TextView) convertView.findViewById(R.id.tv_subtitle);
                    holder.tv_ComentCount = (TextView) convertView.findViewById(R.id.tv_comentcount);
                    break;
                case 1:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.newsitem_style_2, null);
                    holder.iv_NewsItem1 = (ImageView) convertView.findViewById(R.id.iv_newsitem2);
                    holder.tv_Tilte = (TextView) convertView.findViewById(R.id.tv_title1);
                    holder.tv_SubTilte = (TextView) convertView.findViewById(R.id.tv_subtitle1);
                    holder.tv_ComentCount = (TextView) convertView.findViewById(R.id.tv_comentcount1);
                    break;
                case 2:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.newsitem_style_3, null);
                    holder.tv_Tilte = (TextView) convertView.findViewById(R.id.tv_title2);
                    holder.tv_ComentCount = (TextView) convertView.findViewById(R.id.tv_comentcount2);
                    holder.iv_NewsItem1 = (ImageView) convertView.findViewById(R.id.iv_newsitem3);
                    holder.iv_NewsItem2 = (ImageView) convertView.findViewById(R.id.iv_newsitem4);
                    holder.iv_NewsItem3 = (ImageView) convertView.findViewById(R.id.iv_newsitem5);
                    break;
            }
            convertView.setTag(holder);  //设置标识
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        switch (getItem(position).style){
            case 0:
                holder.iv_NewsItem1.setImageResource(getItem(position).imgRes[0]);
                holder.tv_Tilte.setText(getItem(position).title);
                holder.tv_SubTilte.setText(getItem(position).subTitle);
                holder.tv_ComentCount.setText(getItem(position).comentCount);
                break;
            case 1:
                holder.iv_NewsItem1.setImageResource(getItem(position).imgRes[0]);
                holder.tv_Tilte.setText(getItem(position).title);
                holder.tv_SubTilte.setText(getItem(position).subTitle);
                holder.tv_ComentCount.setText(getItem(position).comentCount);
                break;
            case 2:
                holder.tv_Tilte.setText(getItem(position).title);
                holder.tv_ComentCount.setText(getItem(position).comentCount);
                holder.iv_NewsItem1.setImageResource(getItem(position).imgRes[0]);
                holder.iv_NewsItem2.setImageResource(getItem(position).imgRes[1]);
                holder.iv_NewsItem3.setImageResource(getItem(position).imgRes[2]);
                break;
        }
        return convertView;
    }

    private class ViewHolder {
        //新闻主标题
        private TextView tv_Tilte;
        //新闻副标题
        private TextView tv_SubTilte;
        //新闻跟帖数
        private TextView tv_ComentCount;
        //新闻布局图片1
        private ImageView iv_NewsItem1;
        //新闻布局图片2
        private ImageView iv_NewsItem2;
        //新闻布局图片3
        private ImageView iv_NewsItem3;

    }

    /**
     * 初始化新闻列表的集合
     */
    private void initNewsItem_List() {
        //第一种布局的对象
        NewsItem_bean item1 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item2 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item3 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item4 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item5 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});

        //第二种布局的对象
        NewsItem_bean item6 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 1, new int[]{R.mipmap.head_news1});
        NewsItem_bean item7 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 1, new int[]{R.mipmap.head_news1});

        //第三种布局的对象
        NewsItem_bean item8 = new NewsItem_bean("细数1991年科技界最热门事件", "1370跟帖", 2, new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        NewsItem_bean item9 = new NewsItem_bean("细数1991年科技界最热门事件", "1370跟帖", 2, new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        NewsItem_bean item10 = new NewsItem_bean("细数1991年科技界最热门事件", "1370跟帖", 2, new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});


        //第一种布局的对象
        NewsItem_bean item11 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item12 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item13 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item14 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item15 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});

        //第二种布局的对象
        NewsItem_bean item16 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 1, new int[]{R.mipmap.head_news1});
        NewsItem_bean item17 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 1, new int[]{R.mipmap.head_news1});

        //第三种布局的对象
        NewsItem_bean item18 = new NewsItem_bean("细数1991年科技界最热门事件", "1370跟帖", 2, new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        NewsItem_bean item19 = new NewsItem_bean("细数1991年科技界最热门事件", "1370跟帖", 2, new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        NewsItem_bean item20 = new NewsItem_bean("细数1991年科技界最热门事件", "1370跟帖", 2, new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});

        //第一种布局的对象
        NewsItem_bean item21 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item22 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item23 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item24 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});
        NewsItem_bean item25 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 0, new int[]{R.mipmap.head_news1});

        NewsItem_bean item26 = new NewsItem_bean("湖南一镇人大主席赴宴后死亡", "系新到任，参与宴请的多为官员；当地官方称只喝了一杯。", "1045跟帖", 1, new int[]{R.mipmap.head_news1});
        newsItem_bean_List.add(item1);
        newsItem_bean_List.add(item2);
        newsItem_bean_List.add(item3);
        newsItem_bean_List.add(item4);
        newsItem_bean_List.add(item5);
        newsItem_bean_List.add(item6);
        newsItem_bean_List.add(item7);
        newsItem_bean_List.add(item8);
        newsItem_bean_List.add(item9);
        newsItem_bean_List.add(item10);
        newsItem_bean_List.add(item11);
        newsItem_bean_List.add(item12);
        newsItem_bean_List.add(item13);
        newsItem_bean_List.add(item14);
        newsItem_bean_List.add(item15);
        newsItem_bean_List.add(item16);
        newsItem_bean_List.add(item17);
        newsItem_bean_List.add(item18);
        newsItem_bean_List.add(item19);
        newsItem_bean_List.add(item20);
        newsItem_bean_List.add(item21);
        newsItem_bean_List.add(item22);
        newsItem_bean_List.add(item23);
        newsItem_bean_List.add(item24);
        newsItem_bean_List.add(item25);
        newsItem_bean_List.add(item26);
    }
}
