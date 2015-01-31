package com.example.erfanazad.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by erfanazad on 1/7/15.
 */
public class CrimeLab {

    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crimes.json";

    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;
    private CriminalIntentJSONSerializer mSerializer;


    public CrimeLab(Context appContext){
        mAppContext = appContext;
        mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);
        try{
            mCrimes = mSerializer.loadCrimes();
        }catch(Exception e){
            mCrimes = new ArrayList<Crime>();
            Log.e(TAG, "Error loading crimes", e);
        }
    }

    public static CrimeLab get(Context c){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public void addCrime(Crime c){
        mCrimes.add(c);
    }

    public void deleteCriem(Crime c){
        mCrimes.remove(c);
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

    public boolean saveCrimes(){
        try{
            mSerializer.saveCrimes(mCrimes);
            Log.d(TAG, "crimes saved to file");
            return true;
        }catch (Exception e){
            Log.e(TAG, "Error saving files", e);
            return false;
        }
    }
}
