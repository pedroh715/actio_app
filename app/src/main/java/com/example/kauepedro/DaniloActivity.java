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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.card.MaterialCardView;

public class DaniloActivity extends AppCompatActivity {

    MaterialCardView fotoDanilo;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danilo);
        setSoundState();
        playSound();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        Animation imgAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);
        Animation arrowAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.arrow_anim);
        ImageView arrowBack = findViewById(R.id.arrowback);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrowBack.startAnimation(arrowAnim);
                mediaPlayer.stop();
                finish();
            }
        });

        fotoDanilo = findViewById(R.id.materialCardView);
        fotoDanilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fotoDanilo.startAnimation(imgAnim);
            }
        });

        MaterialCardView daniloGithub = findViewById(R.id.githubDanilo);

        daniloGithub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/Danilo-Mota");
                Intent intentDanilo = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentDanilo);

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
        mediaPlayer = MediaPlayer.create(this, R.raw.musica_danilo);
        mediaPlayer.seekTo(30900);
        mediaPlayer.start();

    }
}