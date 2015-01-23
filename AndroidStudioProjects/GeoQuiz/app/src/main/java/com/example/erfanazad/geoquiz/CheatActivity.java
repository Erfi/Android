package com.example.erfanazad.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by erfanazad on 12/23/14.
 */
public class CheatActivity extends Activity{
    public static final String EXTRA_ANSWER_IS_TURE = "com.example.erfanazad.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.erfanazad.geoquiz.answer_shown";
    private static final String CHEAT_VAR = "cheat";
    private Boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private boolean hasCheated;

    private void setAnswerShownResult(Boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TURE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTexView);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        //Answer will not be shown until the user
        //presses the button
        hasCheated = false;
        setAnswerShownResult(hasCheated);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue)
                    mAnswerTextView.setText(R.string.true_button);
                else
                    mAnswerTextView.setText(R.string.false_button);
                hasCheated = true;
                setAnswerShownResult(hasCheated);
            }
        });

        if(savedInstanceState != null) {
            hasCheated = savedInstanceState.getBoolean(CHEAT_VAR, false);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle  savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(CHEAT_VAR, hasCheated);
    }


}
