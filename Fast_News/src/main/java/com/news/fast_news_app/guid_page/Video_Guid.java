package com.news.fast_news_app.guid_page;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.VideoView;

import com.news.fast_news_app.R;

public class Video_Guid extends Activity {
    private VideoView video1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置窗口全屏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.video__guid);
        //初始化控件videoview
        video1 = (VideoView) findViewById(R.id.video1);
        //设置视频资源
        video1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome));
        video1.start();
        //设置播放事件监听
        video1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
               /* //当视频播放完成，再跳转到第4秒一直重复播放
                video1.seekTo(4000);
                video1.start();*/
                Intent intent = new Intent(Video_Guid.this,Guid_Page.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 点击按钮跳转到下一个页面
     */
    public void seekto(View v) {
        Intent intent = new Intent(Video_Guid.this,Guid_Page.class);
        startActivity(intent);
        video1.stopPlayback();
        finish();
    }

}
