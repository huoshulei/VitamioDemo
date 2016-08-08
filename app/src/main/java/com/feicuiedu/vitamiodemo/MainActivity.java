package com.feicuiedu.vitamiodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

// 关于代码下发，更新的方式
// 代码将上传到github,每次代码更改后，将更新
// 各位只要做以下操作即可:

// 1. 安装GIT (32位？ 64位)，一路下一步

// 2. 进入本地指定代码目录(全英文)
//    点右键, git bash here
//    git cloen https://github.com/yuanchaocs/VitamioDemo.git

// 3. 当作者有更新时
//    git pull

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