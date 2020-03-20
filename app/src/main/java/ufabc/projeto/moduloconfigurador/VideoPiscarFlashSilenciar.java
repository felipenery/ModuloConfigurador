package ufabc.projeto.moduloconfigurador;

import android.media.MediaPlayer;
import android.media.session.MediaController;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class VideoPiscarFlashSilenciar extends AppCompatActivity {

    VideoView videoView;
    android.widget.MediaController media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_piscar_flash_silenciar);
        videoView = (VideoView) findViewById(R.id.videoId);
        media = new android.widget.MediaController(this);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.huggo;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        videoView.setMediaController(media);
        media.setAnchorView(videoView);



    }

//    android:layout_gravity="center"
  //  android:layout_margin="5dp"
    //android:layout_marginTop="5dp"




}
