package com.news.fast_news_app.bottom_fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.news.fast_news_app.R;
import com.news.fast_news_app.activity.Icon_Setting;
import com.news.fast_news_app.activity.Login_Regist;
import com.news.fast_news_app.activity.App_Setting;
import com.news.fast_news_app.base_fragment.Base_Fragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2016/2/22.
 */
public class Bottom_Fifth extends Base_Fragment {


    @Bind(R.id.login)
    TextView login;
    @Bind(R.id.yellow_text)
    TextView yellowText;
    @Bind(R.id.login_icon)
    CircleImageView loginIcon;
    private View tabhost_view5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tabhost_view5 = inflater.inflate(R.layout.tabhost_view5, null);
        Tag = "login";
        setOnListener();
        ButterKnife.bind(this, tabhost_view5);
        SharedPreferences sp = getActivity().getSharedPreferences("user_info", Context.MODE_PRIVATE);
        String user_name = sp.getString("userName", "");
        String user_Icon = sp.getString("userIcon", "");
        Bitmap bitmap = BitmapFactory.decodeFile(user_Icon);
        if (user_name.equals("")) {
            login.setText("立即登陆");
        } else {
            login.setText(user_name);
        }

        if (user_Icon.equals("")) {
            loginIcon.setImageResource(R.mipmap.login_icon);
        } else {
            loginIcon.setImageBitmap(bitmap);
        }


        return tabhost_view5;

    }

    private void setOnListener() {
        loginIcon = (CircleImageView) tabhost_view5.findViewById(R.id.login_icon);
        loginIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getActivity().getSharedPreferences("user_info", Context.MODE_PRIVATE);
                String user_name = sp.getString("userName", "");
                String user_Icon = sp.getString("userIcon", "");
                if (user_name.equals("") && user_Icon.equals("")) {

                    Intent intent = new Intent(getActivity(), Login_Regist.class);
                    startActivityForResult(intent, 0);
                } else {
                    //startActivity(new Intent(getActivity(), Icon_Setting.class));
                    Intent intent = new Intent(getActivity(), Icon_Setting.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("bitmap",user_Icon);
                    bundle.putString("username",user_name);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);
                }

            }
        });
    }

    public void updateLoginState(String nickName, String imgUrl) {
        login.setText(nickName);
        DisplayImageOptions options;
        options = new DisplayImageOptions.Builder().cacheOnDisk(true).build();
        ImageLoader.getInstance().displayImage(imgUrl, loginIcon, options);
        String path = ImageLoader.getInstance().getDiskCache().get(imgUrl).getPath();
        SharedPreferences sp = getActivity().getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userName", nickName);
        editor.putString("userIcon", path);
        editor.commit();
    }

    public void updateIcon(Bitmap cameraBitmap){

        loginIcon.setImageBitmap(cameraBitmap);

    }

    public void updateNickName(String updateNickName){

        login.setText(updateNickName);

    }

    public void cleanAcount(){

        login.setText("立即登陆");
        loginIcon.setImageResource(R.mipmap.login_icon);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.setting)
    public void onClick() {

        startActivityForResult(new Intent(getActivity(), App_Setting.class),5);
    }
}
