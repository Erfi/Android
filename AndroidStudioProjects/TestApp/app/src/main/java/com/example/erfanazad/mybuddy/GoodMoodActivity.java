package com.example.erfanazad.mybuddy;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Random;


/**
 * Created by erfanazad on 11/14/14.
 *
 */
public class GoodMoodActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goodmoodlayout);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void playToast(View v){
        Toast msg;
        Random rand = new Random();
        int n = rand.nextInt(5);
        switch(n){
            case 0: msg = Toast.makeText(this, "That's Awesome!", Toast.LENGTH_LONG);
                msg.show();
                break;
            case 1: msg = Toast.makeText(this, "wait...WHAAAAT?", Toast.LENGTH_LONG);
                msg.show();
                break;
            case 2: msg = Toast.makeText(this, "No way!", Toast.LENGTH_LONG);
                msg.show();
                break;
            case 3: msg = Toast.makeText(this, "LOL, Bach is weird!", Toast.LENGTH_LONG);
                msg.show();
                break;
            case 4: msg = Toast.makeText(this, "really? and then what?", Toast.LENGTH_LONG);
                msg.show();
                break;
            default: msg = Toast.makeText(this, "just like lil dicky!!!", Toast.LENGTH_LONG);
                msg.show();
                break;
        }
    }
}
