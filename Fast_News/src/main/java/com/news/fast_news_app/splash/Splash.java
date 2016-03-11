package com.news.fast_news_app.splash;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.news.fast_news_app.R;
import com.news.fast_news_app.guid_page.Video_Guid;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.tandong.swichlayout.BaseEffects;
import com.tandong.swichlayout.SwitchLayout;

public class Splash extends Activity {

    private boolean isFirstRun = false;
private ShimmerTextView shimmerTextView;
    private Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置窗口全屏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);
        SwitchLayout.animDuration = 3000;
        SwitchLayout.ScaleBig(this, false, BaseEffects.getQuickReScrollEffect());
        shimmerTextView = (ShimmerTextView) findViewById(R.id.shimmer_tv);
        shimmer = new Shimmer();
        shimmer.start(shimmerTextView);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                /**
                 * 判断是否是第一次进入APP
                 */
                SharedPreferences sp = getSharedPreferences("guid", MODE_PRIVATE);
                isFirstRun = sp.getBoolean("isFirstRun", true);
                if (isFirstRun) {
                    startActivity(new Intent(getApplication(), Video_Guid.class));
                    finish();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("isFirstRun", false);
                    editor.commit();
                } else {
                    startActivity(new Intent(getApplication(), Splash2.class));
                    finish();

                }
            }
        }, 4000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        shimmer.cancel();
    }
}




