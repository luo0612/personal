package luo.com.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import luo.com.viewer.ui.ImageViewerActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Start(View view) {
        startActivity(new Intent(this, ImageViewerActivity.class));
    }
}
