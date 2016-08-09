package com.feicuiedu.vitamiodemo.demoEMyVideoView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.vitamiodemo.R;
import com.feicuiedu.vitamiodemo.VideoUrlRes;

public class CustomVideoViewActivity extends AppCompatActivity {

    private CustomVideoView customVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_video_view);

        customVideoView = (CustomVideoView) findViewById(R.id.customVideoView);
        customVideoView.setVideoPath(VideoUrlRes.getTestVideo1());
    }
}
