package com.news.fast_news_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.bean.Tab3_Radio_Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/27.
 */
public class Radio_Page_Adapter extends BaseAdapter {

    private ViewHolder holder;
    private Context mcontext;

    public Radio_Page_Adapter(Context context) {
        mcontext = context;
        initRadio_Play_List();
    }

    /**
     * 装载新闻数据的集合
     */
    private List<Tab3_Radio_Bean> radio_play_list = new ArrayList<>();

    @Override
    public int getCount() {
        return radio_play_list.size();
    }

    @Override
    public Tab3_Radio_Bean getItem(int position) {
        return radio_play_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.radio_style_1, null);
            holder.round_icon = (ImageView) convertView.findViewById(R.id.round_icon);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.radio_img1 = (ImageView) convertView.findViewById(R.id.radio_img1);
            holder.radio_img2 = (ImageView) convertView.findViewById(R.id.radio_img2);
            holder.radio_img3 = (ImageView) convertView.findViewById(R.id.radio_img3);
            holder.arrow = (ImageView) convertView.findViewById(R.id.arrow);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.round_icon.setImageResource(getItem(position).round_icon);
        holder.title.setText(getItem(position).title);
        holder.radio_img1.setImageResource(getItem(position).radio_imgRes[0]);
        holder.radio_img2.setImageResource(getItem(position).radio_imgRes[1]);
        holder.radio_img3.setImageResource(getItem(position).radio_imgRes[2]);
        holder.arrow.setImageResource(R.mipmap.personel_arrow_right);

        return convertView;
    }

    private class ViewHolder {

        /**
         * 圆形图片
         */
        public ImageView round_icon;
        /**
         * 圆图片旁边的标题
         */
        public TextView title;
        /**
         * 电台推荐推片一
         */
        public ImageView radio_img1;
        /**
         * 电台推荐推片二
         */
        public ImageView radio_img2;
        /**
         * 电台推荐推片三
         */
        public ImageView radio_img3;
        /**
         * 最右边的箭头
         */
        public ImageView arrow;
    }

    /**
     * 初始化推荐阅读列表的集合
     */
    private void initRadio_Play_List() {

        Tab3_Radio_Bean item1 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item2 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item3 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item4 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item5 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item6 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item7 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item8 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item9 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        Tab3_Radio_Bean item10 = new Tab3_Radio_Bean(R.mipmap.round, "原创", new int[]{R.mipmap.head_news1, R.mipmap.head_news1, R.mipmap.head_news1});
        radio_play_list.add(item1);
        radio_play_list.add(item2);
        radio_play_list.add(item3);
        radio_play_list.add(item4);
        radio_play_list.add(item5);
        radio_play_list.add(item6);
        radio_play_list.add(item7);
        radio_play_list.add(item8);
        radio_play_list.add(item9);
        radio_play_list.add(item10);
    }
}
