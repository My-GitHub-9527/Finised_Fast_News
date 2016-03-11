package com.news.fast_news_app.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.news.fast_news_app.R;

public class News_Detail_Pager_Style1 extends Activity {

    private WebView news_detail_pager_style1;
    //private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detail__pager__style1);
        news_detail_pager_style1 = (WebView) findViewById(R.id.news_detail);
        //progressBar = (ProgressBar) findViewById(R.id.progress);

        news_detail_pager_style1.loadUrl("http://news.hiapk.com/internet/1669066.html");
        WebSettings setting = news_detail_pager_style1.getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setBuiltInZoomControls(true);//显示放大缩小按钮
        setting.setUseWideViewPort(true);//设置双击放大缩小
        news_detail_pager_style1.setWebViewClient(new WebViewClient() {

            private View balls;

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //网页开始加载
                super.onPageStarted(view, url, favicon);
                //progressBar.setVisibility(View.VISIBLE);
                balls = getWindow().getDecorView().findViewById(R.id.balls);
                balls.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                //网页加载结束
                super.onPageFinished(view, url);
                //progressBar.setVisibility(View.GONE);
                balls.setVisibility(View.GONE);

            }
        });
    }

}
