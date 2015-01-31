package com.azadinc.erfanazad.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by erfanazad on 1/22/15.
 */
public class AudioPlayer{

    private MediaPlayer mPlayer;
    private boolean isPaused = false;
    private int pos = 0;

    public void stop_safe(){
        if(mPlayer != null){
            if(!isPaused ){
                pos = 0;
            }
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void stop(){
        if(mPlayer != null){
            pos = 0;
            mPlayer.release();
            mPlayer = null;
        }
    }


    public void play(Context c){

        stop_safe();
        isPaused = false;

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.seekTo(pos);
        mPlayer.start();
    }

    public void pause(Context c){
        if(mPlayer != null && mPlayer.isPlaying()) {
            pos = mPlayer.getCurrentPosition();
            isPaused = true;
            mPlayer.pause();
        }
    }

    public void playPause(Context c){
        if(mPlayer == null){
            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
        }
        if(mPlayer.isPlaying()){
            mPlayer.pause();
        }else{
            mPlayer.start();
        }


    }
}
