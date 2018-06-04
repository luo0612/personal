package luo.com.viewer.entity;

import java.util.ArrayList;
import java.util.List;

import luo.com.viewer.engine.IImageEngine;
import luo.com.viewer.engine.impl.GlideEngine;

/**
 * Created by Administrator on 2018/5/29.
 */

public class ViewerSpec {
    private static final ViewerSpec ourInstance = new ViewerSpec();

    public static ViewerSpec getInstance() {
        return ourInstance;
    }

    private ViewerSpec() {
    }

    private IImageEngine mEngine;
    private List<String> mUrls = new ArrayList<String>();
    private int mIndex;

    public IImageEngine getEngine() {
        if (mEngine == null) {
            mEngine = new GlideEngine();
        }
        return mEngine;
    }

    public void setEngine(IImageEngine engine) {
        mEngine = engine;
    }

    public List<String> getUrls() {
        return mUrls;
    }

    public void setUrls(List<String> urls) {
        mUrls = urls;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int index) {
        mIndex = index;
    }

    public boolean checkSpec() {
        if (mUrls == null || mUrls.size() == 0) {
            Exception exception = new Exception("urls can't be empty");
            exception.printStackTrace();
            return true;
        }
        return false;
    }
}
