package com.example.user.WhoIsSmarter.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.WhoIsSmarter.Model.ComputerQuestion;
import com.example.user.WhoIsSmarter.R;
import com.example.user.WhoIsSmarter.SQLite.ComputerOpenHelper;

import java.util.Collections;
import java.util.List;

public class ComputerNormalActivity extends AppCompatActivity {
    Button buttonA, buttonB, buttonC, buttonD;
    Button btnGameOver, btnTimeUp, btnNext;
    TextView questionText, triviaQuizText, timeText, resultText, coinText;
    ComputerOpenHelper computerQuiz;
    ComputerQuestion computerQuestion;
    List<ComputerQuestion> computerList;
    int qid = 0;
    int timeValue = 20;
    int coinValue = 0;
    CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        questionText = findViewById(R.id.triviaQuestion);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        triviaQuizText = findViewById(R.id.triviaQuizText);
        timeText = findViewById(R.id.timeText);
        resultText = findViewById(R.id.resultText);
        coinText = findViewById(R.id.coinText);
        computerQuiz = new ComputerOpenHelper(this);
        computerQuiz.getWritableDatabase();
        if (computerQuiz.getAllOfTheQuestions().size() == 0) {
            computerQuiz.allQuestion();

        }
        computerList = computerQuiz.getAllOfTheQuestions();
        Collections.shuffle(computerList);
        computerQuestion = computerList.get(qid);
        countDownTimer = new CountDownTimer(22000, 1000) {
            public void onTick(long millisUntilFinished) {

                timeText.setText(String.valueOf(timeValue) + "\"");

                timeValue -= 1;

                if (timeValue == -1) {

                    disableButton();
                }
            }

            public void onFinish() {
                timeUp();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ComputerNormalActivity.this, GameWonActivity.class);
                        intent.putExtra("Score", coinValue);
                        startActivity(intent);
                        finish();
                    }
                }, 1000);
            }

        }.start();
        updateQuestion();


    }

    public void updateQuestion() {
        questionText.setText(computerQuestion.getQuestion());
        buttonA.setText(computerQuestion.getOptionA());
        buttonB.setText(computerQuestion.getOptionB());
        buttonC.setText(computerQuestion.getOptionC());
        buttonD.setText(computerQuestion.getOptionD());
        timeValue = 20;
        countDownTimer.cancel();
        countDownTimer.start();
        coinText.setText(String.valueOf(coinValue));
        coinValue++;
    }

    public void buttonA(View view) {
        countDownTimer.cancel();
        if (computerQuestion.getOptionA().equals(computerQuestion.getAnswer())) {
            if (qid < computerList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(ComputerNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
        if (computerQuestion.getOptionA().equals(computerQuestion.getAnswer())) {
            if (qid == computerList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }

    public void buttonB(View view) {
        countDownTimer.cancel();
        if (computerQuestion.getOptionB().equals(computerQuestion.getAnswer())) {
            if (qid < computerList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(ComputerNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            }, 1000);
        }
        if (computerQuestion.getOptionB().equals(computerQuestion.getAnswer())) {
            if (qid == computerList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }
    public void buttonC(View view) {
        countDownTimer.cancel();
        if (computerQuestion.getOptionC().equals(computerQuestion.getAnswer())) {
            if (qid < computerList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(ComputerNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
        if (computerQuestion.getOptionC().equals(computerQuestion.getAnswer())) {
            if (qid == computerList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }

    public void buttonD(View view) {
        countDownTimer.cancel();
        if (computerQuestion.getOptionD().equals(computerQuestion.getAnswer())) {
            if (qid < computerList.size() - 1) {
                disableButton();
                playSoundRight();
                correctDialog();
            } else {
                gameWon();
            }
        } else {
            playSoundWrong();
            gameLost();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(ComputerNormalActivity.this, GameWonActivity.class);
                    intent.putExtra("Score", coinValue);
                    startActivity(intent);
                    finish();
                }
            },1000);
        }
        if (computerQuestion.getOptionD().equals(computerQuestion.getAnswer())) {
            if (qid == computerList.size() - 1) {
                playSoundRight();
                coinText.setText(String.valueOf(coinValue));
                coinValue++;
                gameWon();
            }
        }
    }

    public void gameWon() {
        Intent intent = new Intent(this, GameWonActivity.class);
        intent.putExtra("Score",coinValue-1);
        startActivity(intent);

    }

    public void gameLost() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView =inflater.inflate(R.layout.dialog_wrong_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
    }
    public void timeUp(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView =inflater.inflate(R.layout.dialog_timeup_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
    }
    public void correctDialog(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View dialogView =inflater.inflate(R.layout.dialog_correct_normal, null);
        dialog.setView(dialogView);
        dialog.setCancelable(false);
        final Dialog dialog1 = dialog.show();
        btnNext = dialogView.findViewById(R.id.Next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
                qid++;
                computerQuestion=computerList.get(qid);
                updateQuestion();
                enableButton();
            }
        });
    }

    public void disableButton() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
    }

    public void enableButton() {
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void playSoundRight() {
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.rightsound);
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
        }
    }

    public void playSoundWrong() {
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.wrongsound);
            mediaPlayer.start();
            mediaPlayer.setLooping(false);
        }
    }
}
