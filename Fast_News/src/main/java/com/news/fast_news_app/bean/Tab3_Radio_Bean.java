package com.news.fast_news_app.bean;

/**
 * Created by Administrator on 2016/2/27.
 */
public class Tab3_Radio_Bean {

    /**
     * 圆形的小图标
     */
    public int round_icon;
    /**
     * 圆图片旁边的标题
     */
    public String title;
    /**
     * 电台推荐的三个频道
     */
    public int radio_imgRes[];

    /**
     * @param round_icon
     * @param title
     * @param radio_imgRes
     */
    public Tab3_Radio_Bean(int round_icon, String title, int[] radio_imgRes) {
        this.round_icon = round_icon;
        this.title = title;
        this.radio_imgRes = radio_imgRes;
    }
}
