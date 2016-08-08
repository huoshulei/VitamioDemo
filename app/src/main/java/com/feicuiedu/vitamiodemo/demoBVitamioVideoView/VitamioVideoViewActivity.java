package com.feicuiedu.vitamiodemo.demoBVitamioVideoView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.vitamiodemo.R;
import com.feicuiedu.vitamiodemo.VideoUrlRes;

import io.vov.vitamio.widget.VideoView;

public class VitamioVideoViewActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("VitamioVideoView");
        setContentView(R.layout.activity_vitamio_video_view);
        videoView = (VideoView) findViewById(R.id.videoView);
        playVideo(); // alt+enten
    }

    private void playVideo() {
        // VideoView:一个android提供的,已封装了MediaPlayer + SurfaceView的视频播放控件
        videoView.setVideoPath(VideoUrlRes.getTestVideo2());
        videoView.start();
    }

}
