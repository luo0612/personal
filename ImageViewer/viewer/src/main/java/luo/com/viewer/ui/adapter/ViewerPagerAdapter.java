package luo.com.viewer.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import luo.com.viewer.entity.ViewerSpec;
import luo.com.viewer.ui.ViewerItemFragment;

/**
 * Created by Administrator on 2018/5/29.
 */

public class ViewerPagerAdapter extends FragmentPagerAdapter {
    private OnPrimaryItemSetListener mListener;
    private final ViewerSpec mViewerSpec;

    public ViewerPagerAdapter(FragmentManager fm, OnPrimaryItemSetListener listener) {
        super(fm);
        mListener = listener;
        mViewerSpec = ViewerSpec.getInstance();
    }

    @Override
    public Fragment getItem(int position) {
        return ViewerItemFragment.newInstance(mViewerSpec.getUrls().get(position));
    }

    @Override
    public int getCount() {
        return mViewerSpec.getUrls().size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (mListener != null) {
            mListener.onPrimaryItemSet(position);
        }
    }

    public String getUrl(int position) {
        return mViewerSpec.getUrls().get(position);
    }

    public void addAll(List<String> urls) {
        mViewerSpec.getUrls().addAll(urls);
    }

    interface OnPrimaryItemSetListener {
        void onPrimaryItemSet(int position);
    }

}
