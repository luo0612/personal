package luo.com.viewer.engine.impl;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import luo.com.viewer.engine.IImageEngine;

/**
 * Created by Administrator on 2018/5/29.
 */

public class GlideEngine implements IImageEngine {
    @Override
    public void loadImage(Context context, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .priority(Priority.HIGH)
                .fitCenter()
                .into(imageView);
    }

    @Override
    public void loadGifImage(Context context, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .asGif()
                .priority(Priority.HIGH)
                .into(imageView);
    }
}
