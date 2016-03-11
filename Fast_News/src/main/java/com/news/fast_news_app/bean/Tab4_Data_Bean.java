package com.news.fast_news_app.bean;

/**
 * Created by Administrator on 2016/2/28.
 */
public class Tab4_Data_Bean {
    /**
     * 个人名字
     */
    public String name;
    /**
     * tab4布局的大图片
     */
    public int tab4_bigimg;
    /**
     * tab4布局的小图片
     */
    public int tab4_smallimg;
    /**
     * 标题
     */
    public String title;
    /**
     * 数据的类型
     */
    public String type;
    /**
     * 关注数量
     */
    public String attention_count;
    /**
     * 提问数量
     */
    public String ask_count;


    /**
     * @param name
     * @param tab4_bigimg
     * @param tab4_smallimg
     * @param title
     * @param type
     * @param attention_count
     * @param ask_count
     */
    public Tab4_Data_Bean(String name, int tab4_bigimg, int tab4_smallimg, String title, String type, String attention_count, String ask_count) {
        this.name = name;
        this.tab4_bigimg = tab4_bigimg;
        this.tab4_smallimg = tab4_smallimg;
        this.title = title;
        this.type = type;
        this.attention_count = attention_count;
        this.ask_count = ask_count;
    }
}
