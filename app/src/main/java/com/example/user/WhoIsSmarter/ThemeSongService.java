package com.example.user.WhoIsSmarter;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.example.user.WhoIsSmarter.R;

public class ThemeSongService extends Service {
    public ThemeSongService() {
    }

    private MediaPlayer media;
    private Timer timer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        media = MediaPlayer.create(getApplicationContext(), R.raw.tuturu);
        media.setLooping(true);
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        timer.purge();

        media.stop();
        media.release();
        stopSelf();
        super.onDestroy();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        startFadeIn();
        media.seekTo(new Random().nextInt(media.getDuration()));
        media.start();
    }

    private float volume = 0;

    private void startFadeIn() {
        final int FADE_DURATION = 1500;
        final int FADE_INTERVAL = 250;
        final int MAX_VOLUME = 1;
        int numberOfSteps = FADE_DURATION / FADE_INTERVAL;
        final float deltaVolume = MAX_VOLUME / (float) numberOfSteps;

        timer = new Timer(true);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                fadeInStep(deltaVolume);
                if (volume >= 1f) {
                    timer.cancel();
                    timer.purge();
                }
            }
        };

        timer.schedule(timerTask, 0, FADE_INTERVAL);
    }

    private void fadeInStep(float deltaVolume) {
        media.setVolume(volume, volume);
        volume += deltaVolume;
    }
}
