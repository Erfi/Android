package com.example.erfanazad.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by erfanazad on 1/7/15.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;
    private static final String TAG = "CrimeListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();

        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
        Log.d(TAG, c.getTitle() + " was clicked!");

        //start CrimePagerActivity with this Crime
        Intent i = new Intent(getActivity(), CrimePagerActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
        startActivity(i);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    //========================CrimeAdapter Class=========================
    private class CrimeAdapter extends ArrayAdapter<Crime>{

        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            //if not given a view inflate one yourself
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }
            //configure the view for this crime
            Crime c = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            SimpleDateFormat df = new SimpleDateFormat("EEE dd-LLL-yyyy");//format for the date!
            dateTextView.setText(df.format(c.getDate()));

            CheckBox solvedCheckBox = (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }
    }
    //====================================================================


}
