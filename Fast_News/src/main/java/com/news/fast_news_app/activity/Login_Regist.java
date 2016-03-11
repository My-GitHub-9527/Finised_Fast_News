package com.news.fast_news_app.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.news.fast_news_app.R;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class Login_Regist extends Activity {

    @Bind(R.id.back)
    ImageView back;
    @Bind(R.id.acount)
    EditText acount;
    @Bind(R.id.clear_acount)
    ImageView clearAcount;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.clear_pwd)
    ImageView clearPwd;
    @Bind(R.id.tgbtn_show_psw)
    ToggleButton tgbtnShowPsw;
    @Bind(R.id.login_btn)
    Button loginBtn;
    @Bind(R.id.smsregist)
    LinearLayout smsregist;
    private Platform qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_login__regist);
        ButterKnife.bind(this);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        //控制登录用户名图标大小
        EditText editText1 = (EditText) findViewById(R.id.acount);
        Drawable drawable1 = getResources().getDrawable(R.mipmap.acount);
        drawable1.setBounds(0, 0, 40, 40);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        editText1.setCompoundDrawables(drawable1, null, null, null);//只放左边

        //控制登录密码图标大小
        EditText editText2 = (EditText) findViewById(R.id.password);
        Drawable drawable2 = getResources().getDrawable(R.mipmap.password);
        drawable2.setBounds(0, 0, 40, 40);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        editText2.setCompoundDrawables(drawable2, null, null, null);//只放左边

        /*设置监听事件*/
        setOnListener();

        //togglebutton的事件监听
        toggleButtonListener();

    }

    /**
     * 对togglebutton设置监听事件
     */
    private void toggleButtonListener() {

        tgbtnShowPsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    password.setTransformationMethod(
                            HideReturnsTransformationMethod.getInstance());
                } else {
                    //隐藏密码
                    password.setTransformationMethod(
                            PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void setOnListener() {

        /*监听账号输入框的文本改变*/
        acount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (acount.getText().toString().length() > 0) {
                    clearAcount.setVisibility(View.VISIBLE);
                    if (password.getText().toString().length() > 0) {
                        loginBtn.setEnabled(true);
                    } else {
                        loginBtn.setEnabled(false);
                    }
                } else {
                    loginBtn.setEnabled(false);
                    clearAcount.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        /*
        * 监听密码输入框的文本改变*/

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (password.getText().toString().length() > 0) {
                    clearPwd.setVisibility(View.VISIBLE);
                    if (acount.getText().toString().length() > 0) {
                        loginBtn.setEnabled(true);
                    } else {
                        loginBtn.setEnabled(false);
                    }
                } else {
                    loginBtn.setEnabled(false);
                    clearPwd.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    /**
     * @param v 监听点击清楚图片将编辑框里面的内容清除
     */
    public void clean_text(View v) {
        if (v.getId() == clearAcount.getId()) {
            acount.setText("");
        } else {
            password.setText("");
        }
    }


    public void other_Login_way(View v) {

        switch (v.getId()) {

            case R.id.wx_login:

                //进入微信授权页面
                break;

            case R.id.sina_login:

                //进入新浪授权页面

                break;

            case R.id.qq_login:

                //进入qq授权页面
                qq = ShareSDK.getPlatform(QQ.NAME);
                qq.removeAccount(true);
                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

                       /* if (i == Platform.ACTION_USER_INFOR) {
                            PlatformDb platDB = platform.getDb();//获取数平台数据DB
                            //通过DB获取各种数据
                            String token = platDB.getToken();
                            String gender = platDB.getUserGender();
                            String Icon =platDB.getUserIcon();
                           String id = platDB.getUserId();
                            String username = platDB.getUserName();
                            String str = "token="+token+",gender="+gender+",Icon="+Icon+"Id="+id+"username="+username;*/

                            Message message = Message.obtain();
                            message.obj = hashMap;
                            message.what = 0;
                            handler.sendMessage(message);


                            System.out.println(hashMap);
                            Log.d("TAG",hashMap.toString());


                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(Platform platform, int i) {

                    }
                });
                qq.showUser(null);
                /*qq.SSOSetting(false);
                qq.authorize();*/






        }
    }

    /**
     * @param v
     *
     */
    public void SMSRegist(View v){

        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");


                }
            }
        });
        registerPage.show(this);
    }

private Handler handler = new Handler(){
    @Override
    public void handleMessage(Message msg) {

        if(msg.what==0){
            HashMap<String,Object> hashMap = (HashMap<String, Object>) msg.obj;
            String bigImgUrl = (String)hashMap.get("figureurl_qq_2");
            String nickname = (String)hashMap.get("nickname");
            String city = (String)hashMap.get("city");
            String province = (String) hashMap.get("province");
            String gender = (String)hashMap.get("gender");
            Toast.makeText(Login_Regist.this, "完成回调了", Toast.LENGTH_SHORT).show();
            Toast.makeText(Login_Regist.this, bigImgUrl+",   "+nickname+",    "+city+"," +
                    "    "+province+",   "+gender, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.putExtra("nickname",nickname);
            intent.putExtra("imgUrl",bigImgUrl);
            setResult(RESULT_OK,intent);

            finish();

        }
    }
};
}
