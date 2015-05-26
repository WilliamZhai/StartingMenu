package com.example.zhaiming.button;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.MediaPlayer;


public class ButtonActivity extends ActionBarActivity {

    MediaPlayer mySound1;
    MediaPlayer mySound2;
    MediaPlayer mySound3;
    MediaPlayer mySound4;

    @Override
    protected void onPause() {
        super.onPause();
        mySound1.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        mySound1 = MediaPlayer.create (this, R.raw.burp);
        mySound2 = MediaPlayer.create (this, R.raw.scream);
        mySound3 = MediaPlayer.create (this, R.raw.ak47);
        mySound4 = MediaPlayer.create (this, R.raw.sniper);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void burp (View v){
        mySound1.start();
    }

    public void scream (View v) {
        mySound2.start();
    }

    public void ak47 (View v) {
        mySound3.start();
    }

    public void sniper (View v) {
        mySound4.start();
    }
}
