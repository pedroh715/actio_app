package com.example.kauepedro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.card.MaterialCardView;

public class PedroActivity extends AppCompatActivity {

    Animation imgAnim, arrowAnim;
    MaterialCardView fotoPedro, linkPedro;
    MediaPlayer mediaPlayer;
    ImageView arrowBack;
    TextView bioPedro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedro);
        playSound();
        setSoundState();
        bioPedro = findViewById(R.id.biopedro);
        bioPedro.setMovementMethod(new ScrollingMovementMethod());

        imgAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);
        arrowAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.arrow_anim);

        setUI();
        setFindView();
        setOnClicks();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        finish();
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
    private void playSound() {
         mediaPlayer = MediaPlayer.create(this, R.raw.moda_casual);
         mediaPlayer.seekTo(14000);
         mediaPlayer.start();
    }
    private void setUI(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
    private void setOnClicks() {
        fotoPedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fotoPedro.startAnimation(imgAnim);
            }
        });

        linkPedro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/pedroh715");
                Intent intentPedro = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentPedro);
            }
        });

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrowBack.startAnimation(arrowAnim);
                mediaPlayer.stop();
                finish();
            }
        });
    }
    private void setFindView(){
        fotoPedro = findViewById(R.id.materialCardView);
        arrowBack = findViewById(R.id.arrow_back);
        linkPedro = findViewById(R.id.pedroLink);
    }
}