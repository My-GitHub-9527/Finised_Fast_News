package com.news.fast_news_app.bean;

public class NewsItem_bean {

    public String title;
    public String subTitle;
    public String comentCount;
    public int style;
    public int imgRes[];

    /**
     * @param title
     * @param subTitle
     * @param comentCount
     * @param style
     * @param imgRes
     * 新闻布局第一种和第二种样式的布局对象
     */
    public NewsItem_bean(String title, String subTitle, String comentCount, int style, int[] imgRes) {
        this.title = title;
        this.subTitle = subTitle;
        this.comentCount = comentCount;
        this.style = style;
        this.imgRes = imgRes;
    }

    /**
     * @param title
     * @param comentCount
     * @param style
     * @param imgRes
     * 新闻布局第三种样式的布局对象
     */
    public NewsItem_bean(String title, String comentCount, int style, int[] imgRes) {
        this.title = title;
        this.comentCount = comentCount;
        this.style = style;
        this.imgRes = imgRes;
    }
}
