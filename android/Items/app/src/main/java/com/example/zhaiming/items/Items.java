package com.example.zhaiming.items;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.graphics.Camera;

public class Items extends ActionBarActivity {

    String itemName;
    String itemDescription; // a few sentences revealing the background of the item or some storyline connections.
    int cost;
    int increasedDefense;
    int increasedHitPoints;
    int bodyLocation; // (0 = held in hand wear, 1 = head, 2 = chest, 3 = legs, 4 = boots)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_items, menu);
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

    public void createNewItem (String name, int[] stats, Camera display){
        String itemName = name;
    }

    public int getCost(){
        return cost;
    }

    public int getIncreasedDefense (){
        return increasedDefense;
    }

    public int getIncreasedHitPoints (){
        return increasedHitPoints;
    }

    public int getBodyLocation() {
        return bodyLocation;
    }


}


