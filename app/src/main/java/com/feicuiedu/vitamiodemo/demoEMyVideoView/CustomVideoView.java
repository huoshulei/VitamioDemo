package com.feicuiedu.vitamiodemo.demoEMyVideoView;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;

import com.feicuiedu.vitamiodemo.R;
import com.feicuiedu.vitamiodemo.VideoUrlRes;

import java.io.IOException;

/**
 * 一个能播放视频的控件,SurfaceView来显示视频,用MediaPlayer来进行视频的播放
 * <p/>
 * 作者：yuanchao on 2016/8/9 0009 10:00
 * 邮箱：yuanchao@feicuiedu.com
 */
public class CustomVideoView extends RelativeLayout implements SurfaceHolder.Callback{
    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    // MediaPlayer
    // MediaPlayer mediaPlayer = new MediaPlayer();
    // mediaPlayer.setDataSource(数据源);
    // mediaPlayer.prepare();
    // mediaPlayer.start()
    // 但是：MediaPlayer并不能显示视频
    // mediaPlayer.setDisplay()

    // SurfaceView
    // SurfaceView 上有一个Surface进行绘制处理,怎么样才能拿到这个Surface，怎么才能将内容显示到Surface上
    // 它提供了一个        SurfaceHodler
    // SurfaceView - getVolder();

//        SurfaceView view = null;
//        SurfaceHolder holder = view.getHolder();
//        视频画面处理 --- 不用我们去做
//
//        mediaPlayer.setDisplay(holder)

    //        Canvas canvas = holder.lockCanvas();
//        canvas.drawARGB(2,2,2,2);
//        canvas.drawARGB(2,2,2,2);
//        canvas.drawARGB(2,2,2,2);
//        canvas.drawARGB(2,2,2,2);
//        canvas.drawARGB(2,2,2,2);
//        canvas.drawARGB(2,2,2,2);
//        holder.unlockCanvasAndPost(canvas);


    // 你只是放了一个SurfaceView的控件,但是，他内部是通过Surface去处理的
    // 你怎么知道这个Surface有没有创建好？有没有改变大小？有没有dest..???
    // 所以它提供了一个Callback

    public CustomVideoView(Context context) {
        this(context, null);
    }

    public CustomVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 当前视图（其实目前也就是只有一个SurfaceView，后期当然会加上更多的视频相关控制的控件上去）
        LayoutInflater.from(context).inflate(R.layout.view_simple_video_player, this, true);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.setDataSource(VideoUrlRes.getTestVideo1());
            mediaPlayer.prepareAsync(); // 异步
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override public void surfaceDestroyed(SurfaceHolder holder) {

    }
}