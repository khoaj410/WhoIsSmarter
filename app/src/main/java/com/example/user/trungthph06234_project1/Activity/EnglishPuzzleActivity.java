package com.example.user.trungthph06234_project1.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.trungthph06234_project1.Adapter.GridViewAnswerAdapter;
import com.example.user.trungthph06234_project1.Adapter.GridViewSuggestAdapter;
import com.example.user.trungthph06234_project1.Common;
import com.example.user.trungthph06234_project1.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class EnglishPuzzleActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    public List<String> suggestSource = new ArrayList<>();

    public GridViewAnswerAdapter answerAdapter;
    public GridViewSuggestAdapter suggestAdapter;

    public Button btnSubmit;

    public GridView gridViewAnswer, gridViewSuggest;

    public ImageView imgViewQuestion;

    int[] image_list = {

            R.drawable.apple,
            R.drawable.bicycle,
            R.drawable.dinosaur,
            R.drawable.elephant,
            R.drawable.lightning,
            R.drawable.fire,
            R.drawable.doctor,
            R.drawable.eclipse,
            R.drawable.hunter,
            R.drawable.knife,
            R.drawable.knight,
            R.drawable.lion,
            R.drawable.moon,
            R.drawable.museum,
            R.drawable.police,
            R.drawable.shield,
            R.drawable.sky,
            R.drawable.wings,
            R.drawable.assassin,
            R.drawable.magic,
            R.drawable.basketball,
            R.drawable.flags,
            R.drawable.chair,
            R.drawable.gate,
            R.drawable.support,
            R.drawable.lantern,
            R.drawable.festival,
            R.drawable.balloons,
            R.drawable.monster,
            R.drawable.darkness
    };

    public char[] answer;

    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_puzzle);

        initView();


    }

    private void initView() {
        gridViewAnswer = (GridView) findViewById(R.id.gridViewAnswer);
        gridViewSuggest = (GridView) findViewById(R.id.gridViewSuggest);

        imgViewQuestion = (ImageView) findViewById(R.id.img);

        setupList();

        btnSubmit = (Button) findViewById(R.id.buttonA);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                for (int i = 0; i < Common.user_submit_answer.length; i++)
                    result += String.valueOf(Common.user_submit_answer[i]);
                if (result.equals(correct_answer)) {
                    Toast.makeText(getApplicationContext(), "Chính Xác, Đây Là " + result, Toast.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
                    if (sp.getInt("Sound", 0) == 0) {
                        mediaPlayer = MediaPlayer.create(EnglishPuzzleActivity.this, R.raw.rightsound);
                        mediaPlayer.start();
                        mediaPlayer.setLooping(false);
                    }

                    Common.count = 0;
                    Common.user_submit_answer = new char[correct_answer.length()];
                    GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(setupNullList(), getApplicationContext());
                    gridViewAnswer.setAdapter(answerAdapter);
                    answerAdapter.notifyDataSetChanged();

                    GridViewSuggestAdapter suggestAdapter = new GridViewSuggestAdapter(suggestSource, getApplicationContext(), EnglishPuzzleActivity.this);
                    gridViewSuggest.setAdapter(suggestAdapter);
                    suggestAdapter.notifyDataSetChanged();

                    setupList();
                } else {
                SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
                if (sp.getInt("Sound", 0) == 0) {
                    mediaPlayer = MediaPlayer.create(EnglishPuzzleActivity.this, R.raw.wrongsound);
                    mediaPlayer.start();
                    mediaPlayer.setLooping(false);
                }
            }

                }
            });
        }

    private void setupList() {

        Random random = new Random();
        int imageSelected = image_list[random.nextInt(image_list.length)];
        imgViewQuestion.setImageResource(imageSelected);

        correct_answer = getResources().getResourceName(imageSelected);
        correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/") + 1);

        answer = correct_answer.toCharArray();

        Common.user_submit_answer = new char[answer.length];

        suggestSource.clear();
        for (char item : answer) {
            suggestSource.add(String.valueOf(item));
        }

        for (int i = answer.length; i < answer.length * 2; i++)
            suggestSource.add(Common.alphabet_character[random.nextInt(Common.alphabet_character.length)]);

        Collections.shuffle(suggestSource);

        answerAdapter = new GridViewAnswerAdapter(setupNullList(), this);
        suggestAdapter = new GridViewSuggestAdapter(suggestSource, this, this);

        answerAdapter.notifyDataSetChanged();
        suggestAdapter.notifyDataSetChanged();

        gridViewSuggest.setAdapter(suggestAdapter);
        gridViewAnswer.setAdapter(answerAdapter);


    }

    private char[] setupNullList() {
        char result[] = new char[answer.length];
        for (int i = 0; i < answer.length; i++)
            result[i] = ' ';
        return result;
    }
}