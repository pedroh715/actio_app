package com.example.kauepedro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.google.android.material.card.MaterialCardView;

public class KaueActivity extends AppCompatActivity {
    Animation imgAnim, arrowAnim;
    MaterialCardView fotoKaue, linkKaue;
    MediaPlayer mediaPlayer;
    ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaue);
        setSoundState();
        playSound();

        imgAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);
        arrowAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.arrow_anim);
        fotoKaue = findViewById(R.id.materialCardView);

        fotoKaue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fotoKaue.startAnimation(imgAnim);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        arrowBack = findViewById(R.id.arrow_back);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrowBack.startAnimation(arrowAnim);
                mediaPlayer.stop();
                finish();
            }
        });

        linkKaue = findViewById(R.id.kaueLink);

        linkKaue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/kauegran");
                Intent intentKaue = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentKaue);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    private void setSoundState(){
        ToggleButton button = findViewById(R.id.button_sound);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!button.isChecked()){
                    mediaPlayer.setVolume(0,0);
                } else mediaPlayer.setVolume(1, 1);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        finish();
    }

    private void playSound() {
        mediaPlayer = MediaPlayer.create(this, R.raw.musica_kaue);
        mediaPlayer.seekTo(15800);
        mediaPlayer.start();
    }
}