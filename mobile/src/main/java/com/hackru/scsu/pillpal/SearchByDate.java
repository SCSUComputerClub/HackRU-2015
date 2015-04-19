package com.hackru.scsu.pillpal;

import android.support.v7.app.ActionBarActivity;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;


public class SearchByDate extends ActionBarActivity {

    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_date);

        dp = (DatePicker) findViewById(R.id.datePicker);
        Calendar date = Calendar.getInstance();

        dp.init(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH),
                new OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {

                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search_by_date, menu);
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
}
