package com.example.erfanazad.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by erfanazad on 1/5/15.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title){
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Crime(){
        //generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    @Override
    public String toString(){
        return mTitle;
    }
}
