package com.example.erfanazad.geoquiz;

/**
 * Created by erfanazad on 12/20/14.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getQuestion(){
        return mQuestion;
    }

    public void setQuestion(int question){
        mQuestion = question;
    }

    public boolean getTrueQuestion(){
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion){
        mTrueQuestion = trueQuestion;
    }
}
