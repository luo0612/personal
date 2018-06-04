package luo.com.viewer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2018/5/29.
 */

public class ImageViewer {

    private WeakReference<Activity> mActivity;

    private ImageViewer(Activity activity) {
        mActivity = new WeakReference<Activity>(activity);
    }

    private ImageViewer(Fragment fragment) {
        this(fragment.getActivity());
    }


    @NonNull
    public static ViewerSpecCreator from(Activity activity) {
        return new ViewerSpecCreator(new ImageViewer(activity));
    }

    @NonNull
    public static ViewerSpecCreator from(Fragment fragment) {
        return new ViewerSpecCreator(new ImageViewer(fragment));
    }

    public Activity getActivity() {
        return mActivity.get();
    }


}
