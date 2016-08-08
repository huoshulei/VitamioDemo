package com.feicuiedu.vitamiodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // MediaPlayer (媒体播放,但不负责显示)
        // MediaPlayer + SurfaceView
        // MediaPlayer + TextureView
        // VideoView (已封装好的 MediaPlayer + SurfaceView)
        // MediaController
        // 缓存处理
        // 形成一个Vitamio的Demo
    }
}