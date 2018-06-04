package luo.com.viewer;

import android.app.Activity;
import android.content.Intent;

import java.util.List;

import luo.com.viewer.engine.IImageEngine;
import luo.com.viewer.entity.ViewerSpec;
import luo.com.viewer.ui.ImageViewerActivity;

/**
 * Created by Administrator on 2018/5/29.
 */

public final class ViewerSpecCreator {
    private ImageViewer mViewer;
    private final ViewerSpec mViewerSpec;

    ViewerSpecCreator(ImageViewer viewer) {
        mViewer = viewer;
        mViewerSpec = ViewerSpec.getInstance();
    }

    public ViewerSpecCreator setUrls(List<String> urls) {
        mViewerSpec.setUrls(urls);
        return this;
    }

    public ViewerSpecCreator setIndex(int index) {
        mViewerSpec.setIndex(index);
        return this;
    }

    public ViewerSpecCreator setImageEngine(IImageEngine engine) {
        mViewerSpec.setEngine(engine);
        return this;
    }

    public void launch() {
        boolean error= mViewerSpec.checkSpec();
        if(error){
            return;
        }
        Activity activity = mViewer.getActivity();
        Intent intent = new Intent(activity, ImageViewerActivity.class);
        activity.startActivity(intent);
    }

}
