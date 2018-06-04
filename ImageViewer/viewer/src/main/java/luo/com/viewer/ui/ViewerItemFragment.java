package luo.com.viewer.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import luo.com.viewer.R;
import luo.com.viewer.entity.ViewerSpec;

/**
 * Created by Administrator on 2018/5/29.
 */

public class ViewerItemFragment extends Fragment {

    private static final String ARGS_URL = "args_url";

    public static ViewerItemFragment newInstance(String url) {
        ViewerItemFragment fragment = new ViewerItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARGS_URL, url);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_viewer_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String url = getArguments().getString(ARGS_URL);
        if (TextUtils.isEmpty(url)) {
            return;
        }

        ImageViewTouch content = view.findViewById(R.id.ivt_viewer_item_content);
        content.setDisplayType(ImageViewTouchBase.DisplayType.NONE);
        ViewerSpec.getInstance().getEngine().loadImage(getContext(), content, url);
    }

    public void resetView() {
        if (getView() != null) {
            ((ImageViewTouch) getView().findViewById(R.id.ivt_viewer_item_content)).resetMatrix();
        }
    }
}
