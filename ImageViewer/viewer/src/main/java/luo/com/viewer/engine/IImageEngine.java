package luo.com.viewer.engine;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/5/29.
 */

public interface IImageEngine {
    void loadImage(Context context, ImageView imageView, String url);

    void loadGifImage(Context context, ImageView imageView, String url);
}
