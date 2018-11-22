package com.example.user.trungthph06234_project1.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.trungthph06234_project1.R;

public class HomeActivity extends AppCompatActivity {
    private Button btnPlay;
    private Button btnSetting;
    private Button btnQuit;
    private ImageView btnSound;
    private ImageView btnSoundOff;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnPlay = findViewById(R.id.playGame);
        btnSetting = findViewById(R.id.setting);
        btnQuit = findViewById(R.id.quit);
        btnSound = findViewById(R.id.sound);
        btnSoundOff = findViewById(R.id.soundoff);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.rionos);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
        btnSound.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               if (sp.getInt("Sound", 1) == 1) {
                   mediaPlayer = MediaPlayer.create(HomeActivity.this, R.raw.rionos);
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
            }
        }
                                    });
        btnSoundOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
    }
        @Override
        protected void onPause() {
            super.onPause();
            SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
            if (sp.getInt("Sound", 0) == 0)
                mediaPlayer.pause();
        }

        @Override
        protected void onRestart() {
            super.onRestart();
            SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
            if (sp.getInt("Sound", 0) == 0)
                mediaPlayer.start();
        }


    }
