package com.example.user.trungthph06234_project1.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.List;

import com.example.user.trungthph06234_project1.Common;
import com.example.user.trungthph06234_project1.Activity.EnglishPuzzleActivity;

/**
 * Created by reale on 3/9/2017.
 */

public class GridViewSuggestAdapter extends BaseAdapter {

    private List<String> suggestSource;
    private Context context;
    private EnglishPuzzleActivity englishPuzzleActivity;

    public GridViewSuggestAdapter(List<String> suggestSource, Context context, EnglishPuzzleActivity englishPuzzleActivity) {
        this.suggestSource = suggestSource;
        this.context = context;
        this.englishPuzzleActivity = englishPuzzleActivity;
    }

    @Override
    public int getCount() {
        return suggestSource.size();
    }

    @Override
    public Object getItem(int position) {
        return suggestSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button button;
        if(convertView == null)
        {
            if(suggestSource.get(position).equals("null"))
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);
            }
            else
            {
                button = new Button(context);
                button.setLayoutParams(new GridView.LayoutParams(85,85));
                button.setPadding(8,8,8,8);
                button.setBackgroundColor(Color.DKGRAY);
                button.setTextColor(Color.YELLOW);
                button.setText(suggestSource.get(position));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(String.valueOf(englishPuzzleActivity.answer).contains(suggestSource.get(position)))
                        {
                            char compare = suggestSource.get(position).charAt(0);

                            for(int i = 0; i< englishPuzzleActivity.answer.length; i++)
                            {
                                if(compare == englishPuzzleActivity.answer[i])
                                    Common.user_submit_answer[i] = compare;
                            }

                            GridViewAnswerAdapter answerAdapter = new GridViewAnswerAdapter(Common.user_submit_answer,context);
                            englishPuzzleActivity.gridViewAnswer.setAdapter(answerAdapter);
                            answerAdapter.notifyDataSetChanged();

                            englishPuzzleActivity.suggestSource.set(position,"null");
                            englishPuzzleActivity.suggestAdapter = new GridViewSuggestAdapter(englishPuzzleActivity.suggestSource,context, englishPuzzleActivity);
                            englishPuzzleActivity.gridViewSuggest.setAdapter(englishPuzzleActivity.suggestAdapter);
                            englishPuzzleActivity.suggestAdapter.notifyDataSetChanged();
                        }
                        else //
                        {
                            englishPuzzleActivity.suggestSource.set(position,"null");
                            englishPuzzleActivity.suggestAdapter = new GridViewSuggestAdapter(englishPuzzleActivity.suggestSource,context, englishPuzzleActivity);
                            englishPuzzleActivity.gridViewSuggest.setAdapter(englishPuzzleActivity.suggestAdapter);
                            englishPuzzleActivity.suggestAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
        else
            button = (Button)convertView;
        return button;

    }
}
