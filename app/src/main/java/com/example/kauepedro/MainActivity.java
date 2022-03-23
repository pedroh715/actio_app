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
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import io.alterac.blurkit.BlurLayout;

public class MainActivity extends AppCompatActivity {

    private BlurLayout blurLayout;
    private MaterialCardView pedroButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        Intent intentPedro = new Intent(this, PedroActivity.class);
        Intent intentKaue = new Intent(this, KaueActivity.class);
        Intent intentDanilo = new Intent(this, DaniloActivity.class);

        pedroButton = findViewById(R.id.card1);

        pedroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPedro);
            }
        });

        MaterialCardView kaueButton = findViewById(R.id.card2);

        kaueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentKaue);
            }
        });

        MaterialCardView daniloButton = findViewById(R.id.card3);

        daniloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentDanilo);
            }
        });

        blurLayout = findViewById(R.id.blurLayout);

        MaterialCardView projectGithub = findViewById(R.id.cardGithub);

        projectGithub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/pedroh715/actio_app");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);

            }
        });
    }
}