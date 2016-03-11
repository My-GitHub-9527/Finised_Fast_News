package com.news.fast_news_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.bean.Recommend_Read_bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/27.
 */
public class Recommend_Read_Adapter extends BaseAdapter {
    private int styleCount = 3;
    private ViewHolder holder;
    private Context mcontext;

    public Recommend_Read_Adapter(Context context) {
        mcontext = context;
        initNewsItem_List();
    }

    @Override
    public int getItemViewType(int position) {
        return recommend_read_list != null ? recommend_read_list.get(position).style : -1;
    }

    @Override
    public int getViewTypeCount() {
        return styleCount;
    }

    /**
     * 装载新闻数据的集合
     */
    private List<Recommend_Read_bean> recommend_read_list = new ArrayList<>();

    @Override
    public int getCount() {
        return recommend_read_list.size();
    }

    @Override
    public Recommend_Read_bean getItem(int position) {
        return recommend_read_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();

            switch (getItem(position).style) {
                case 0:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.rec_readitem_style_1,null,false);
                    holder.iv_recommend1 = (ImageView) convertView.findViewById(R.id.tab2_iv1);
                    holder.tv_Tilte = (TextView) convertView.findViewById(R.id.tab2_tv1);
                    holder.tv_origin = (TextView) convertView.findViewById(R.id.tab2_tv2);
                    break;
                case 1:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.rec_readitem_style_2,null,false);
                    holder.iv_recommend1 = (ImageView) convertView.findViewById(R.id.tab2_iv2);
                    holder.iv_recommend2 = (ImageView) convertView.findViewById(R.id.tab2_iv3);
                    holder.iv_recommend3 = (ImageView) convertView.findViewById(R.id.tab2_iv4);
                    holder.tv_Tilte = (TextView) convertView.findViewById(R.id.tab2_tv3);
                    holder.tv_origin = (TextView) convertView.findViewById(R.id.tab2_tv4);
                    break;
                case 2:
                    convertView = LayoutInflater.from(mcontext).inflate(R.layout.rec_readitem_style_3,null,false);
                    holder.iv_recommend1 = (ImageView) convertView.findViewById(R.id.tab2_iv5);
                    holder.tv_Tilte = (TextView) convertView.findViewById(R.id.tab2_tv5);
                    holder.tv_origin = (TextView) convertView.findViewById(R.id.tab2_tv6);
                    break;
            }
            convertView.setTag(holder);  //设置标识
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        switch (getItem(position).style){
            case 0:
                holder.iv_recommend1.setImageResource(getItem(position).imgRes[0]);
                holder.tv_Tilte.setText(getItem(position).title);
                holder.tv_origin.setText(getItem(position).origin);
                break;
            case 1:
                holder.iv_recommend1.setImageResource(getItem(position).imgRes[0]);
                holder.iv_recommend2.setImageResource(getItem(position).imgRes[1]);
                holder.iv_recommend3.setImageResource(getItem(position).imgRes[2]);
                holder.tv_Tilte.setText(getItem(position).title);
                holder.tv_origin.setText(getItem(position).origin);
                break;
            case 2:
                holder.iv_recommend1.setImageResource(getItem(position).imgRes[0]);
                holder.tv_Tilte.setText(getItem(position).title);
                holder.tv_origin.setText(getItem(position).origin);
                break;
        }
        return convertView;
    }

    private class ViewHolder {
        //推荐阅读主标题
        private TextView tv_Tilte;
        //推荐阅读来源
        private TextView tv_origin;
        //推荐阅读布局图片1
        private ImageView iv_recommend1;
        //推荐阅读图片2
        private ImageView iv_recommend2;
        //推荐阅读图片3
        private ImageView iv_recommend3;

    }
    /**
     * 初始化推荐阅读列表的集合
     */
    private void initNewsItem_List() {
        //第一种布局的样式对象
        Recommend_Read_bean item1 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item2 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item3 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        //第二种样式布局的对象
        Recommend_Read_bean item4 = new Recommend_Read_bean(1,new int[]{R.mipmap.head_news1,R.mipmap.head_news1,R.mipmap.head_news1},"真材实料远超郭Mini 韩性感女主播私照曝光","叶子猪");

        Recommend_Read_bean item5 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item6= new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        Recommend_Read_bean item7 = new Recommend_Read_bean(1,new int[]{R.mipmap.head_news1,R.mipmap.head_news1,R.mipmap.head_news1},"真材实料远超郭Mini 韩性感女主播私照曝光","叶子猪");

        Recommend_Read_bean item8 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item9 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        //第三种样式布局的对象
        Recommend_Read_bean item17 = new Recommend_Read_bean(2,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        Recommend_Read_bean item18 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item19 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        Recommend_Read_bean item20 = new Recommend_Read_bean(2,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item21 = new Recommend_Read_bean(2,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        Recommend_Read_bean item22 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item23 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");


        Recommend_Read_bean item10 = new Recommend_Read_bean(1,new int[]{R.mipmap.head_news1,R.mipmap.head_news1,R.mipmap.head_news1},"真材实料远超郭Mini 韩性感女主播私照曝光","叶子猪");

        Recommend_Read_bean item11 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item12 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        Recommend_Read_bean item13 = new Recommend_Read_bean(1,new int[]{R.mipmap.head_news1,R.mipmap.head_news1,R.mipmap.head_news1},"真材实料远超郭Mini 韩性感女主播私照曝光","叶子猪");

        Recommend_Read_bean item14 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");
        Recommend_Read_bean item15 = new Recommend_Read_bean(0,new int[]{R.mipmap.head_news1},"小米发布会直播引热议熊猫TV科技秀洞悉市场先机","熊猫TV");

        Recommend_Read_bean item16 = new Recommend_Read_bean(1,new int[]{R.mipmap.head_news1,R.mipmap.head_news1,R.mipmap.head_news1},"真材实料远超郭Mini 韩性感女主播私照曝光","叶子猪");

        recommend_read_list.add(item1);
        recommend_read_list.add(item2);
        recommend_read_list.add(item3);
        recommend_read_list.add(item4);
        recommend_read_list.add(item5);
        recommend_read_list.add(item6);
        recommend_read_list.add(item7);
        recommend_read_list.add(item8);
        recommend_read_list.add(item9);
        recommend_read_list.add(item10);
        recommend_read_list.add(item11);
        recommend_read_list.add(item12);
        recommend_read_list.add(item13);
        recommend_read_list.add(item14);
        recommend_read_list.add(item15);
        recommend_read_list.add(item16);
        recommend_read_list.add(item17);
        recommend_read_list.add(item18);
        recommend_read_list.add(item19);
        recommend_read_list.add(item20);
        recommend_read_list.add(item21);
        recommend_read_list.add(item22);
        recommend_read_list.add(item23);


    }
}
