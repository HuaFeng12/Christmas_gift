package com.hqbb.christmasgift;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.VideoView;


public class StartActivity extends AppCompatActivity {
    Button btn_start;
    private Button start;
    private VideoView videoView;
    private MediaPlayer mediaPlayer;
    private MediaPlayer Player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // 实例化 MediaPlayer 对象并设置音频文件
        mediaPlayer = MediaPlayer.create(this, R.raw.shengdan);
        Player = MediaPlayer.create(this, R.raw.shenyin);
        // 播放音频
        mediaPlayer.start();

        // 获取按钮
        btn_start = findViewById(R.id.start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 关闭音频
                mediaPlayer.stop();
                mediaPlayer.release();
//                finish(); // 关闭 Activity
                Intent intent = new Intent();
                intent.setClass(StartActivity.this, MainActivity.class);
                startActivity(intent);
                // 初始化MediaPlayer对象
                Player.start();
                switch (view.getId()) {
                    case R.id.start:
                        setAnimateScale(start);
                        break;
                }
            }

        });
      /*   //找VideoView控件
        videoView = (VideoView)findViewById(R.id.videoview);
        //加载视频文件
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.xiaojiejie));
        //播放
        videoView.start();
        //循环播放
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });*/
    }
    public void onClick(View v) {
        // 初始化MediaPlayer对象
        mediaPlayer = MediaPlayer.create(this, R.raw.shenyin);
        mediaPlayer.start();
        switch (v.getId()) {
            case R.id.start:
                setAnimateScale(start);
                break;
    }
}
    protected void onDestroy() {
        super.onDestroy();
        // 释放MediaPlayer资源
        mediaPlayer.release();
        stopService(new Intent(this, BackgroundSoundService.class));
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setAnimateScale(final View view) {
        view.animate()
                .scaleX(1.5f).scaleY(1.5f)
                .setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.animate()
                                .scaleX(1.0f).scaleY(1.0f)
                                .setDuration(200);
                    }
                }).start();
    }

    }