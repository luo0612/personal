package luo.com.viewer.ui.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * Created by Administrator on 2018/5/29.
 */

public class PreviewViewPager extends ViewPager {
    public PreviewViewPager(@NonNull Context context) {
        super(context);
    }

    public PreviewViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 用于判断子View是否滑动
     *
     * @param v
     * @param checkV
     * @param dx
     * @param x
     * @param y
     * @return
     */
    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ImageViewTouch) {
            return ((ImageViewTouch) v).canScroll(dx) || super.canScroll(v, checkV, dx, x, y);
        }
        return super.canScroll(v, checkV, dx, x, y);

    }
}
