package com.example.user.WhoIsSmarter.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.WhoIsSmarter.R;

public class GameWonActivity extends AppCompatActivity {
    TextView txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);
        txtScore = findViewById(R.id.txtScore);
        Intent intent = getIntent();
        int score = intent.getIntExtra("Score", 0);
        score = score-1;
        txtScore.setText("Your score: " + score);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),CategoryActivity.class));
                finish();
            }
        },4000);
    }
    @Override
    public void onBackPressed() { }
}
