package com.feicuiedu.vitamiodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.feicuiedu.vitamiodemo.demoAAndroidVideoView.AndroidVideoViewActivity;
import com.feicuiedu.vitamiodemo.demoBVitamioVideoView.VitamioVideoViewActivity;
import com.feicuiedu.vitamiodemo.demoCMediaController.MediaControllerActivity;
import com.feicuiedu.vitamiodemo.demoDVideoBuffer.VideoBufferActivity;
import com.feicuiedu.vitamiodemo.demoEMyVideoView.CustomVideoViewActivity;

// 实践操作, 从GitHub上Clone一份当前代码
// 实践操作, 从GitHub上Clone一份当前代码
// 实践操作, 从GitHub上Clone一份当前代码

// 关于我们代码下发，更新的方式, 我们的代码将上传到github
// 当前项目路径 https://github.com/yuanchaocs/VitamioDemo.git

// 各位只要做以下操作即可:
// 1. 安装GIT (32位？ 64位)，一路下一步
// 2. 进入本地指定代码目录(全英文)
//    点右键, git bash here
//    git clone https://github.com/yuanchaocs/VitamioDemo.git
// 3. 当作者有更新时
//    git pull

// 现在我们代码是怎么做的
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] datas = null;

    @Override public void onContentChanged() {
        super.onContentChanged();
        datas = new String[]{
                "Android VideoView",
                "Vitamio VideoView",
                "Vitamio MediaController",
                "Vitamio Buffer",
                "Vitamio MediaPlayer+SurfaceView"
        };
        listView = (ListView) findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ctrl + b
        setContentView(R.layout.activity_main);
    }

    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, AndroidVideoViewActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(this, VitamioVideoViewActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(this, MediaControllerActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent.setClass(this, VideoBufferActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(this, CustomVideoViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}