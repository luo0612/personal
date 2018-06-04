package luo.com.viewer.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import luo.com.viewer.R;
import luo.com.viewer.entity.ViewerSpec;
import luo.com.viewer.ui.adapter.ViewerPagerAdapter;
import luo.com.viewer.ui.widget.IndexIndicatorTextView;

public class ImageViewerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mVpPager;
    private ViewerPagerAdapter mAdapter;
    private IndexIndicatorTextView mIndicatorTextView;
    private ViewerSpec mViewerSpec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        mViewerSpec = ViewerSpec.getInstance();

        mIndicatorTextView = findViewById(R.id.iitv_view_indicator);
        mIndicatorTextView.setSize(mViewerSpec.getUrls().size());
        mVpPager = findViewById(R.id.pvp_viewer_pager);
        mVpPager.addOnPageChangeListener(this);
        mAdapter = new ViewerPagerAdapter(getSupportFragmentManager(), null);
        mVpPager.setAdapter(mAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ViewerPagerAdapter adapter = (ViewerPagerAdapter) mVpPager.getAdapter();
        mIndicatorTextView.setIndex(position + 1);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVpPager.removeOnPageChangeListener(this);
    }
}
