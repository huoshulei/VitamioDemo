package com.feicuiedu.vitamiodemo.demoAAndroidVideoView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.feicuiedu.vitamiodemo.R;
import com.feicuiedu.vitamiodemo.VideoUrlRes;

public class AndroidVideoViewActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("AndroidVideoView");
        setContentView(R.layout.activity_android_video_view);
        videoView = (VideoView) findViewById(R.id.videoView);
        playVideo(); // alt+enten
    }

    private void playVideo() {
        // VideoView:一个android提供的,已封装了MediaPlayer + SurfaceView的视频播放控件
        videoView.setVideoPath(VideoUrlRes.getTestVideo1());
        videoView.start();
    }

}
