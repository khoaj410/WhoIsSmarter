package com.example.user.WhoIsSmarter.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.example.user.WhoIsSmarter.Constant;
import com.example.user.WhoIsSmarter.R;
import com.example.user.WhoIsSmarter.ThemeSongService;

public class HomeActivity extends AppCompatActivity implements Constant {
    private Button btnPlay;
    private Button btnSetting;
    private Button btnQuit;
    MediaPlayer mediaPlayer;
    private ToggleButton tgbSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initBackgroundSound();
        initAction();
    }
    private void initView(){
        btnPlay = findViewById(R.id.playGame);
        btnSetting = findViewById(R.id.setting);
        btnQuit = findViewById(R.id.quit);
        tgbSound = findViewById(R.id.tgbSound);
    }
    private void initAction(){
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
                Intent intent = new Intent(HomeActivity.this, AboutMeActivity.class);
                startActivity(intent);
            }
        });
        btnQuit.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent a = new Intent(Intent.ACTION_MAIN);
                                           a.addCategory(Intent.CATEGORY_HOME);
                                           a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                           startActivity(a);
                                       }
                                   });

        tgbSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences pref = getSharedPreferences(PREF_SOUND, MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                if (!isChecked) {
                    startService(new Intent(HomeActivity.this, ThemeSongService.class));
                    editor.putBoolean(IS_SOUND, true);
                } else {
                    stopService(new Intent(HomeActivity.this, ThemeSongService.class));
                    editor.putBoolean(IS_SOUND, false);
                }
                editor.apply();
            }
        });
    }

    private void initBackgroundSound() {
        SharedPreferences pref = getSharedPreferences(PREF_SOUND, MODE_PRIVATE);
        boolean sound = pref.getBoolean(IS_SOUND, true);
        if (sound) {
            startService(new Intent(HomeActivity.this, ThemeSongService.class));
        } else {
            tgbSound.setChecked(true);
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "onRestart");
        initBackgroundSound();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(HomeActivity.this, ThemeSongService.class));
    }
    public void onBackPressed() {

    }
}
