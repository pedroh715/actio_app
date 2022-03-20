package com.example.kauepedro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PedroActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedro);
        playSound();

        Intent homeIntent = new Intent(this, MainActivity.class);

        ImageView arrowBack = findViewById(R.id.arrow_back);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeIntent);
                finish();
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
         mediaPlayer = MediaPlayer.create(this, R.raw.sound_test);
         mediaPlayer.start();
    }
}