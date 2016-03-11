package com.news.fast_news_app.bean;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flyco.dialog.widget.popup.BasePopup;
import com.news.fast_news_app.R;

import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Administrator on 2016/3/7.
 */
public class SimpleCustomPop extends BasePopup<SimpleCustomPop> {

    private LinearLayout mTvItem1;
    private LinearLayout mTvItem2;
    private LinearLayout mTvItem3;
    private LinearLayout mTvItem4;

    public SimpleCustomPop(Context context) {
        super(context);
    }

    @Override
    public View onCreatePopupView() {
        View inflate = View.inflate(mContext, R.layout.popup_custom, null);
        mTvItem1 = (LinearLayout) inflate.findViewById(R.id.tv_item_1);
        mTvItem2 = (LinearLayout) inflate.findViewById(R.id.tv_item_2);
        mTvItem3 = (LinearLayout) inflate.findViewById(R.id.tv_item_3);
        mTvItem4 = (LinearLayout) inflate.findViewById(R.id.tv_item_4);
        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        mTvItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "写跟帖", Toast.LENGTH_SHORT).show();
            }
        });
        mTvItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "分享", Toast.LENGTH_SHORT).show();

                OnekeyShare oks = new OnekeyShare();
                //关闭sso授权
                oks.disableSSOWhenAuthorize();

                // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
                //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
                // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
                oks.setTitle("分享");
                // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
                oks.setTitleUrl("http://sharesdk.cn");
                // text是分享文本，所有平台都需要这个字段
                oks.setText("我是分享文本");
                // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
                //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
                // url仅在微信（包括好友和朋友圈）中使用
                oks.setUrl("http://sharesdk.cn");
                // comment是我对这条分享的评论，仅在人人网和QQ空间使用
                oks.setComment("我是测试评论文本");
                // site是分享此内容的网站名称，仅在QQ空间使用
                oks.setSite("http://www.baidu.com");
                // siteUrl是分享此内容的网站地址，仅在QQ空间使用
                oks.setSiteUrl("http://sharesdk.cn");

                // 启动分享GUI
                oks.show(getContext());
                //隐藏对话框
                hide();
            }
        });
        mTvItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "收藏", Toast.LENGTH_SHORT).show();
            }
        });
        mTvItem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "保存", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
