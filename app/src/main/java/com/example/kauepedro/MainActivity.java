package com.example.kauepedro;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import io.alterac.blurkit.BlurLayout;

public class MainActivity extends AppCompatActivity {

    private TextView actioLogo, ativMobile;
    private BlurLayout blurLayout;
    private MaterialCardView pedroBtn, kaueBtn, daniloBtn, projectGithub;
    private Intent intentPedro, intentKaue, intentDanilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
        setFindView();
        setIntent();
        setOnClicks();
    }
    protected void setFindView() {
        pedroBtn = findViewById(R.id.card1);
        kaueBtn = findViewById(R.id.card2);
        daniloBtn = findViewById(R.id.card3);
        projectGithub = findViewById(R.id.cardGithub);
        blurLayout = findViewById(R.id.blurLayout);
    }
    protected void setIntent() {
        intentPedro = new Intent(this, PedroActivity.class);
        intentKaue = new Intent(this, KaueActivity.class);
        intentDanilo = new Intent(this, DaniloActivity.class);
    }
    protected void setUI() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
    protected void setOnClicks(){
        pedroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPedro);
            }
        });

        kaueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentKaue);
            }
        });

        daniloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentDanilo);
            }
        });

        projectGithub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/pedroh715/actio_app");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);

            }
        });
    }
}