package com.news.fast_news_app.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.bean.Video_Play_Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/27.
 */
public class Video_Play_Adapter extends BaseAdapter {

    private ViewHolder holder;
    private Context mcontext;

    public Video_Play_Adapter(Context context) {
        mcontext = context;
        initVideoPlay_List();
    }

    /**
     * 装载新闻数据的集合
     */
    private List<Video_Play_Bean> video_play_list = new ArrayList<>();

    @Override
    public int getCount() {
        return video_play_list.size();
    }

    @Override
    public Video_Play_Bean getItem(int position) {
        return video_play_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.video_style1,null);
            holder.video_bg = (ImageView) convertView.findViewById(R.id.video_bg);
            holder.play_icon = (ImageView) convertView.findViewById(R.id.play_icon);
            holder.video = (VideoView) convertView.findViewById(R.id.tab2_video);
            holder.title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.subtitle = (TextView) convertView.findViewById(R.id.tv_subtitle);
            holder.video_time = (TextView) convertView.findViewById(R.id.video_time);
            holder.play_count = (TextView) convertView.findViewById(R.id.play_count);
            holder.comment_count = (TextView) convertView.findViewById(R.id.comment_count);
            holder.video_share_icon = (ImageView) convertView.findViewById(R.id.video_share);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.video_bg.setImageResource(getItem(position).video_bg);
        holder.play_icon.setImageResource(getItem(position).play_icon);
        holder.video.setVideoURI(Uri.parse("android.resource://" + Video_Play_Adapter.this.getClass().getPackage() + "/" + R.raw.welcome));
        holder.title.setText(getItem(position).title);
        holder.subtitle.setText(getItem(position).subtitle);
        holder.video_time.setText(getItem(position).video_time);
        holder.play_count.setText(getItem(position).play_count);
        holder.comment_count.setText(getItem(position).comment_count);
        holder.video_share_icon.setImageResource(R.mipmap.video_share_icon);
        return convertView;
    }

    private class ViewHolder {
        /**
         * 未点击播放按钮时的默认图片
         */
        public ImageView video_bg;
        /**
         * 视频播放的图标
         */
        public ImageView play_icon;
        /**
         * 视频id
         */
        public VideoView video;
        /**
         * 标题
         */
        public TextView title;
        /**
         * 副标题
         */
        public TextView subtitle;
        /**
         * 视频时长
         */
        public TextView video_time;
        /**
         * 视频播放的数量
         */
        public TextView play_count;
        /**
         * 视频评论的数量
         */
        public TextView comment_count;
        /**
         * 视频分享图标
         */
        public ImageView video_share_icon;

    }

    /**
     * 初始化推荐阅读列表的集合
     */
    private void initVideoPlay_List() {

        Video_Play_Bean item1 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item2 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item3 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item4 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item5 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item6 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item7 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item8 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item9 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        Video_Play_Bean item10 = new Video_Play_Bean(R.mipmap.head_news4,R.mipmap.play_icon,R.raw.welcome,"超萌的香港迪士尼里的垃圾桶","最后哭着跑走什么的真是萌翻","01:22","1.0万","45");
        video_play_list.add(item1);
        video_play_list.add(item2);
        video_play_list.add(item3);
        video_play_list.add(item4);
        video_play_list.add(item5);
        video_play_list.add(item6);
        video_play_list.add(item7);
        video_play_list.add(item8);
        video_play_list.add(item9);
        video_play_list.add(item10);
    }
}
