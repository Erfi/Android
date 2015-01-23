package com.example.erfanazad.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by erfanazad on 1/7/15.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        //temporarily filling with boring crimes
        for(int i=0 ; i< 100; i++){
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);//every other one
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime c : mCrimes){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
}
