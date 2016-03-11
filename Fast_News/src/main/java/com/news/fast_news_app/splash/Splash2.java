package com.news.fast_news_app.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.guid_page.Guid_Page;

public class Splash2 extends Activity {
    private TextView number;
    private TextView text;
    private TextView skipping;
    private Handler handler = new Handler();
    private MyCountDownTimer mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置窗口全屏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash2);
        overridePendingTransition(0, 0);
        number = (TextView) findViewById(R.id.number);
        text = (TextView) findViewById(R.id.text);
        skipping = (TextView) findViewById(R.id.skipping);
        mc = new MyCountDownTimer(6000,1000);
        mc.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash2.this,Guid_Page.class);
                startActivity(intent);
                finish();
            }
        }, 6000);
    }


    class MyCountDownTimer extends CountDownTimer {
        /**
         * @param millisInFuture    表示以毫秒为单位 倒计时的总数
         *                          <p/>
         *                          例如 millisInFuture=1000 表示1秒
         * @param countDownInterval 表示 间隔 多少微秒 调用一次 onTick 方法
         *                          <p/>
         *                          例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onFinish() {
            text.setVisibility(View.GONE);
            number.setVisibility(View.GONE);
            skipping.setVisibility(View.VISIBLE);
        }

        public void onTick(long millisUntilFinished) {

            number.setText(millisUntilFinished / 1000 + "");
        }
    }
}



