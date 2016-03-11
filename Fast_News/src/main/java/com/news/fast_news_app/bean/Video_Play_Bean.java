package com.news.fast_news_app.bean;

/**
 * Created by Administrator on 2016/2/27.
 */
public class Video_Play_Bean  {

    /**
     * 未点击播放按钮时的默认图片
     */
    public int video_bg;
    /**
     * 视频播放的图标
     */
    public int play_icon;
    /**
     * 视频id
     */
    public int video_resId;
    /**
     * 标题
     */
    public String title;
    /**
     * 副标题
     */
    public String subtitle;
    /**
     * 视频时长
     */
    public String video_time;
    /**
     * 视频播放的数量
     */
    public String play_count;
    /**
     * 视频评论的数量
     */
    public String comment_count;

    /**
     * @param video_bg
     * @param play_icon
     * @param video_resId
     * @param title
     * @param subtitle
     * @param video_time
     * @param play_count
     * @param comment_count
     */
    public Video_Play_Bean(int video_bg, int play_icon, int video_resId, String title, String subtitle, String video_time, String play_count, String comment_count) {
        this.video_bg = video_bg;
        this.play_icon = play_icon;
        this.video_resId = video_resId;
        this.title = title;
        this.subtitle = subtitle;
        this.video_time = video_time;
        this.play_count = play_count;
        this.comment_count = comment_count;
    }
}
