package com.example.erfanazad.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by erfanazad on 1/8/15.
 */
public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }

}
