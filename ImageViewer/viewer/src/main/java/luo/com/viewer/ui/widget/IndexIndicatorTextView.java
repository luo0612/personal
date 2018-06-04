package luo.com.viewer.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2018/5/29.
 */

public class IndexIndicatorTextView extends android.support.v7.widget.AppCompatTextView {
    private int mSize;
    private int mIndex;

    public IndexIndicatorTextView(Context context) {
        super(context);
    }

    public IndexIndicatorTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexIndicatorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setIndex(int index) {
        mIndex = index;
        StringBuilder builder = new StringBuilder();
        builder.append(mIndex).append("/").append(mSize);
        setText(builder.toString());
    }

    public void setSize(int size) {
        mSize = size;
    }
}
