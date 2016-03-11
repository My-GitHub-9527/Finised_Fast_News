package com.news.fast_news_app.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.animation.NewsPaperEnter;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.news.fast_news_app.R;
import com.news.fast_news_app.utils.SharedPrefUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class Icon_Setting extends Activity {

    @Bind(R.id.setting)
    TextView setting;
    @Bind(R.id.login1_icon)
    CircleImageView login1Icon;
    @Bind(R.id.login1)
    TextView login1;
    @Bind(R.id.yellow_text1)
    TextView yellowText1;
    private String picpath;
    private String newFilePath;
    private View abc;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.icon_setting);
        ButterKnife.bind(this);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        abc =  View.inflate(this,R.layout.edit_dialog, null);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String bitMap = (String) bundle.get("bitmap");
        String userName = (String) bundle.get("username");
        Bitmap bitmap = BitmapFactory.decodeFile(bitMap);
        login1Icon.setImageBitmap(bitmap);
        login1.setText(userName);

    }

    @OnClick({R.id.setting, R.id.login1_icon, R.id.login1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                break;
            case R.id.login1_icon:
                final String[] stringItems = {"拍照", "从相册选择", "修改昵称"};
                //View v1 = findViewById(R.id.root);
                //不用再填充布局来findviewbyId

                final ActionSheetDialog dialog = new ActionSheetDialog(Icon_Setting.this, stringItems, null);
                dialog.isTitleShow(false);
                dialog.showAnim(new NewsPaperEnter());
                dialog.show();

                dialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, final View view, int position, long id) {
                        switch (position) {
                            case 1:
                                final Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                                /*intent.addCategory(Intent.CATEGORY_OPENABLE);
                                intent.setType("image*//*");*/

                                intent.putExtra("crop", "true");
                                intent.putExtra("aspectX", 1);
                                intent.putExtra("aspectY", 1);
                                intent.putExtra("outputX", 300);
                                intent.putExtra("outputY", 300);
                                intent.putExtra("return-data", true);

                                startActivityForResult(intent, 1);
                                break;
                            case 2:
                                final NiftyDialogBuilder dialogBuilder = NiftyDialogBuilder.getInstance(Icon_Setting.this);

                                dialogBuilder
                                        .withTitle("网易新闻")
                                        .withTitleColor("#FFFFFF")
                                        .withDividerColor("#11000000")
                                        .withMessage("您要修改你的昵称吗？")
                                        .withMessageColor("#FFFFFFFF")
                                        .withDialogColor("#7cd12e")
                                        .withIcon(R.mipmap.ic_launcher)
                                        .withDuration(700)
                                        .withEffect(Effectstype.Newspager)
                                        .withButton1Text("确认")
                                        .withButton2Text("取消")
                                        .isCancelableOnTouchOutside(true)
                                        .setCustomView(abc,Icon_Setting.this)
                                        .setButton1Click(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                EditText nickName = (EditText)abc.findViewById(R.id.nickName);
                                                if(nickName.getText().toString().equals("")){
                                                    Toast.makeText(Icon_Setting.this, "请输入要修改的昵称在点击确认！", Toast.LENGTH_SHORT).show();
                                                }else{
                                                    text = nickName.getText().toString();
                                                    Log.d("My", text);
                                                    login1.setText(text);
                                                    Intent intent1 = new Intent();
                                                    intent1.putExtra("updateNickName",text);
                                                    setResult(130,intent1);
                                                    SharedPrefUtils.putString(Icon_Setting.this,"userName", text);
                                                    dialogBuilder.hide();

                                                }

                                            }
                                        })
                                        .setButton2Click(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialogBuilder.hide();
                                            }
                                        })
                                        .show();
                                break;
                        }
                        Toast.makeText(Icon_Setting.this, stringItems[position], Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.login1:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {

            if (null != data) {
                Bitmap cameraBitmap = (Bitmap) data.getExtras().get("data");
                login1Icon.setImageBitmap(cameraBitmap);
                Intent intent = new Intent();
                intent.putExtra("cameraBitmap", cameraBitmap);
                setResult(110, intent);

                saveCroppedImage(cameraBitmap);
                SharedPrefUtils.putString(this, "userIcon", newFilePath);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void saveCroppedImage(Bitmap bmp) {
        File file = new File("/sdcard/myFolder");
        if (!file.exists())
            file.mkdir();

        file = new File("/sdcard/temp.jpg".trim());
        String fileName = file.getName();
        String mName = fileName.substring(0, fileName.lastIndexOf("."));
        String sName = fileName.substring(fileName.lastIndexOf("."));

        // /sdcard/myFolder/temp_cropped.jpg
        newFilePath = "/sdcard/myFolder" + "/" + mName + "_cropped" + sName;
        file = new File(newFilePath);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
