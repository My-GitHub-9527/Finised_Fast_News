package com.news.fast_news_app.bean;

/**
 * Created by Administrator on 2016/2/27.
 */
public class Recommend_Read_bean {
public int style;
    public String title;
    public String origin;
    public int imgRes[];

    /**
     * @param style
     * @param title
     * @param imgRes
     * @param origin
     * 推荐阅读第一种和第二种样式的布局对象
     */
    public Recommend_Read_bean(int style,int[] imgRes, String title,String origin) {
        this.title = title;
        this.style = style;
        this.imgRes = imgRes;
        this.origin = origin;
    }


}
