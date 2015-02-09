package com.example.erfanazad.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by erfi on 2/1/15.
 */
public class CrimeCameraActivity extends SingleFragmentActivity {

    @Override
    public void onCreate(Bundle savedInstancesState){
        //Hide the window title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Hide the status bar and other OS-level chrome
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstancesState);
    }

    @Override
    protected Fragment createFragment(){
        return new CrimeCameraFragment();
    }
}
