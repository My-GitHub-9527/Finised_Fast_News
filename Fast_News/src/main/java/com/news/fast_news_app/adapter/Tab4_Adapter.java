package com.news.fast_news_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.bean.Tab4_Data_Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/28.
 */
public class Tab4_Adapter extends BaseAdapter {

    private ViewHolder holder;
    private Context mcontext;

    public Tab4_Adapter(Context context) {
        mcontext = context;
        inittab4_data_List();
    }

    /**
     * 装载新闻数据的集合
     */
    private List<Tab4_Data_Bean> tab4_data_list = new ArrayList<>();


    @Override
    public int getCount() {
        return tab4_data_list.size();
    }

    @Override
    public Tab4_Data_Bean getItem(int position) {
        return tab4_data_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.tab4_layout,null);
            holder.tab4_bigimg = (ImageView) convertView.findViewById(R.id.tab4_bigimg);
            holder.tab4_smallimg = (ImageView) convertView.findViewById(R.id.tab4_smallimg);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.type = (TextView) convertView.findViewById(R.id.type);
            holder.attention_count = (TextView) convertView.findViewById(R.id.attention_count);
            holder.ask_count = (TextView) convertView.findViewById(R.id.ask_count);
            holder.attention_btn = (Button) convertView.findViewById(R.id.attention_btn);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tab4_bigimg.setImageResource(getItem(position).tab4_bigimg);
        holder.tab4_smallimg.setImageResource(getItem(position).tab4_smallimg);
        holder.title.setText(getItem(position).title);
        holder.type.setText(getItem(position).type);
        holder.attention_count.setText(getItem(position).attention_count);
        holder.ask_count.setText(getItem(position).ask_count);
        holder.attention_btn.setText(" + 关注");

        return convertView;
    }


    private class ViewHolder {

        /**
         * 个人名字
         */
        public TextView name;
        /**
         * tab4布局的大图片
         */
        public ImageView tab4_bigimg;
        /**
         * tab4布局的小图片
         */
        public ImageView tab4_smallimg;
        /**
         * 标题
         */
        public TextView title;
        /**
         * 数据的类型
         */
        public TextView type;
        /**
         * 关注数量
         */
        public TextView attention_count;
        /**
         * 提问数量
         */
        public TextView ask_count;
        /**
         * 点击关注的按钮
         */
        public Button attention_btn;
    }

    /**
     * 初始化推荐阅读列表的集合
     */
    private void inittab4_data_List() {

        Tab4_Data_Bean item1 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item2 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item3 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item4 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item5 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item6 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item7 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item8 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item9 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item10 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item11= new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        Tab4_Data_Bean item12 = new Tab4_Data_Bean("史润华/律师",R.mipmap.ls,R.mipmap.round,"我是律师史润华，有关互联网 + 以及其他疑难复杂案件，问我吧！","时政","1.4万关注","510提问");
        tab4_data_list.add(item1);
        tab4_data_list.add(item2);
        tab4_data_list.add(item3);
        tab4_data_list.add(item4);
        tab4_data_list.add(item5);
        tab4_data_list.add(item6);
        tab4_data_list.add(item7);
        tab4_data_list.add(item8);
        tab4_data_list.add(item9);
        tab4_data_list.add(item10);
        tab4_data_list.add(item11);
        tab4_data_list.add(item12);
    }
}
