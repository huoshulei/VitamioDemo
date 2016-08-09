package com.feicuiedu.vitamiodemo.demoEMyVideoView;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;

import com.feicuiedu.vitamiodemo.R;

import java.io.IOException;

/**
 * CustomVideoView，使用MediaPlayer + SurfaceView实现视频播放
 * <p/>
 * 在使用此控件前，请先设置视频地址
 * <p/>
 * 作者：yuanchao on 2016/8/9 0009 10:00
 * 邮箱：yuanchao@feicuiedu.com
 */
public class CustomVideoView extends RelativeLayout implements SurfaceHolder.Callback {

    private MediaPlayer mediaPlayer; // 用来播放
    private SurfaceView surfaceView; // 用来显示播放效果
    private String videoPath; // 视频地址
    private SurfaceHolder surfaceHolder;

    public CustomVideoView(Context context) {
        this(context, null);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 当前布局(就是一个SurfaceView)
        // 一般的需求:
        // 有SurfaceView（用来显示视频内容）
        // 有视频控制的控件(比如，播放.......)
        LayoutInflater.from(getContext()).inflate(R.layout.view_simple_video_player, this, true);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override public void surfaceCreated(SurfaceHolder holder) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(holder);
            mediaPlayer.setDataSource(videoPath);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
