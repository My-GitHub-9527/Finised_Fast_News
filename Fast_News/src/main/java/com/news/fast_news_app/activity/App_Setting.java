package com.news.fast_news_app.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.news.fast_news_app.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class App_Setting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.app_setting);
        ButterKnife.bind(this);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @OnClick(R.id.exit_acount)
    public void onClick() {
        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);

        if (sp.getString("userName", "").equals("") && sp.getString("userIcon", "").equals("")) {
            Crouton.makeText(App_Setting.this,"账号已清除成功，请不要再次点击！OK?", Style.CONFIRM).show();
            //Toast.makeText(App_Setting.this, "账号已清除成功，请不要再次点击！OK?", Toast.LENGTH_SHORT).show();

        } else {
            SharedPreferences.Editor editor = sp.edit();
            editor.remove("userName");
            editor.remove("userIcon");
            editor.commit();
            Toast.makeText(App_Setting.this, "账号信息清除成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            setResult(120, intent);
        }

    }
}
