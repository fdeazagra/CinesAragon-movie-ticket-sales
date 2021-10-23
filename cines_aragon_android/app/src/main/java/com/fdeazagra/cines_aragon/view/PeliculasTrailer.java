package com.fdeazagra.cines_aragon.view;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.fdeazagra.cines_aragon.R;

public class PeliculasTrailer extends AppCompatActivity {

    VideoView videoView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView((R.layout.reproductor_trailer));

        videoView = (VideoView) findViewById(R.id.videoView);
        String valor = getIntent().getStringExtra("valor");

        Uri uri = Uri.parse(valor);

        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
