package com.example.erfanazad.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by erfanazad on 1/9/15.
 */
public class CrimePagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        mCrimes = CrimeLab.get(this).getCrimes();

        setPagerAdapter();
//        FragmentManager fm = getSupportFragmentManager();
//        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
//            @Override
//            public Fragment getItem(int position) {
//                Crime crime = mCrimes.get(position);
//                return CrimeFragment.newInstance(crime.getId());
//            }
//
//            @Override
//            public int getCount() {
//                return mCrimes.size();
//            }
//        });

        //========Changing the title of the action bar========
//        mViewPager.OnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Crime crime = mCrimes.get(position);
//                if (crime.getTitle() != null) {
//                    setTitle(crime.getTitle());
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for(int i=0; i< mCrimes.size(); i++){
            if(mCrimes.get(i).getId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }


    }


    //==========================Deleting from inside a fragment============
    public void deletePage() {
        int index = mViewPager.getCurrentItem();
        mCrimes.remove(index);
        mViewPager.getAdapter().notifyDataSetChanged();


        if(mCrimes.size() == 0){
            if (NavUtils.getParentActivityName(this) != null) {
                NavUtils.navigateUpFromSameTask(this);
            }
        }else {
            setPagerAdapter();
            //try to set to the next item
            if(index < mViewPager.getAdapter().getCount()){
                mViewPager.setCurrentItem(index);
            }else{//if no next item then go to previous item
                mViewPager.setCurrentItem(index-1);
            }
        }
    }

    //=====================================================================


    private void setPagerAdapter() {
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
    }
}
