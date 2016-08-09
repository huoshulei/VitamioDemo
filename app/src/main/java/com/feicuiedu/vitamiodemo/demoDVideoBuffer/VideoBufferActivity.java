package com.feicuiedu.vitamiodemo.demoDVideoBuffer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.feicuiedu.vitamiodemo.R;
import com.feicuiedu.vitamiodemo.VideoUrlRes;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoBufferActivity extends AppCompatActivity implements
        MediaPlayer.OnInfoListener,
        MediaPlayer.OnBufferingUpdateListener,
        MediaPlayer.OnPreparedListener {

    @BindView(R.id.videoView) VideoView videoView;
    @BindView(R.id.tvDownloadRate) TextView tvDownloadRate;
    @BindView(R.id.tvLoadRate) TextView tvLoadRate;
    @BindView(R.id.progressBar) ProgressBar progressBar;

    @BindString(R.string.app_name)String appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("VideoBuffer");
        setContentView(R.layout.activity_video_buffer);
        ButterKnife.bind(this);
//        videoView = (VideoView) this.findViewById(R.id.videoView);
//        tvDownloadRate = (TextView) this.findViewById(R.id.tvDownloadRate);
//        tvLoadRate = (TextView) this.findViewById(R.id.tvLoadRate);
//        progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        playVideo(); // alt+enten
    }

    private void playVideo() {
        // VideoView:一个android提供的,已封装了MediaPlayer + SurfaceView的视频播放控件
        videoView.setVideoPath(VideoUrlRes.getTestVideo2());
        videoView.setMediaController(new MediaController(this));
        // 监听 info,buffer,Prepared
        videoView.setOnInfoListener(this); // 信息监听,类似“状态”监听
        videoView.setOnBufferingUpdateListener(this); // 缓冲监听
        videoView.setOnPreparedListener(this); // 准备状态监听
    }

    @Override public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            // 开始缓冲
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                startBuffer(); // loading显示出来，videoview.pause()
                break;
            // 结束缓冲
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                endBuffer(); // loading隐藏起来, videoview.start()
                break;
            // 下载速度发生变化
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                tvDownloadRate.setText(extra + "KB/S");
                break;
        }
        return false;
    }

    private void startBuffer() {
        // Vitamio进入就自动播放
        if (videoView.isPlaying()) {
            videoView.pause();
            progressBar.setVisibility(View.VISIBLE);
            tvDownloadRate.setVisibility(View.VISIBLE);
            tvLoadRate.setVisibility(View.VISIBLE);
            tvDownloadRate.setText("");
            tvLoadRate.setText("");
        }
    }

    private void endBuffer() {
        videoView.start();
        progressBar.setVisibility(View.GONE);
        tvDownloadRate.setVisibility(View.GONE);
        tvLoadRate.setVisibility(View.GONE);
    }

    @Override public void onBufferingUpdate(MediaPlayer mp, int percent) {
        tvLoadRate.setText(percent + "%");
    }

    @Override public void onPrepared(MediaPlayer mp) {
        videoView.setBufferSize(512 * 1024);
    }
}
