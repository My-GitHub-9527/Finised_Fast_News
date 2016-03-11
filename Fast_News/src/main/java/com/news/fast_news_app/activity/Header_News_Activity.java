package com.news.fast_news_app.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.flyco.animation.NewsPaperEnter;
import com.flyco.animation.SlideExit.SlideTopExit;
import com.news.fast_news_app.R;
import com.news.fast_news_app.bean.SimpleCustomPop;
import com.news.fast_news_app.view.Dispatch_ViewPager;
import com.ryanharter.viewpager.PagerAdapter;
import com.tandong.swichlayout.SwitchLayout;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import uk.co.senab.photoview.PhotoView;

public class Header_News_Activity extends SwipeBackActivity {
private Dispatch_ViewPager mViewPager;
    private SwipeBackLayout mSwipeBackLayout;
    private static final int[] sDrawables = {R.mipmap.head_news1,R.mipmap.head_news2,R.mipmap.head_news3,R.mipmap.head_news4,R.mipmap.head_news5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header_news_activity);
        SwitchLayout.animDuration=2000;
        SwitchLayout.ScaleBig(this,false,null);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        mViewPager = (Dispatch_ViewPager) findViewById(R.id.header_news);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        mSwipeBackLayout.setEdgeSize(200);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return sDrawables.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoView photoView = new PhotoView(container.getContext());
                photoView.setImageResource(sDrawables[position]);

                // Now just add PhotoView to ViewPager and return it
                container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

                return photoView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View)object);
            }
        });
    }

    /**
     * @param view
     * 点击按钮进行分享
     */
    public void share(View view){

        ImageView share = (ImageView) getWindow().getDecorView().findViewById(R.id.share);
        SimpleCustomPop mQuickCustomPopup = new SimpleCustomPop(this);
        mQuickCustomPopup
                .anchorView(share)
                .offset(-10, 5)
                .gravity(Gravity.TOP)
                .showAnim(new NewsPaperEnter())
                .dismissAnim(new SlideTopExit())
                .dimEnabled(false)
                .show();


    }
}
