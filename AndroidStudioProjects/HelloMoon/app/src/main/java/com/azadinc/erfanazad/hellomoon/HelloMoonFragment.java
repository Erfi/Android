package com.azadinc.erfanazad.hellomoon;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by erfanazad on 1/22/15.
 */
public class HelloMoonFragment extends Fragment {
    private AudioPlayer mPlayer = new AudioPlayer();
//    private Button mPlayButton;
//    private Button mStopButton;
//    private Button mPauseButton;
    private Button mPlayPauseButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

//        //==========================Play Button========================
//        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
//        mPlayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPauseButton.setEnabled(true);
//                mPlayer.play(getActivity());
//            }
//        });
//
//        //==========================Stop Button========================
//        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
//        mStopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPauseButton.setEnabled(false);
//                mPlayer.stop();
//            }
//        });
//
//        //==========================Pause Button========================
//        mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
//        mPauseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPauseButton.setEnabled(false);
//                mPlayer.pause(getActivity());
//            }
//        });

        //==========================Play/Pause Button========================
        mPlayPauseButton = (Button)v.findViewById(R.id.hellomoon_playPauseButton);
        mPlayPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.playPause(getActivity());
            }
        });

        return v;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mPlayer.stop();
    }

}
