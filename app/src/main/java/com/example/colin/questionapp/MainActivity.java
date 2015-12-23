package com.example.colin.questionapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    // This is stuff for message sending, can delete it eventually
    public static final String PATH = "com.example.colin.questionapp";
    public static final String EXTRA_MESSAGE = PATH + ".MESSAGE";

    // This is stuff for repeating alarm
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrieve a PendingIntent that will perform a broadcast
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);
        Log.i("MainActivity", "OnCreate, intent created @" + SystemClock.elapsedRealtime());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void startAlarm(View view){
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // 30 second exact repeating alarm
        manager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                1000 * 30,
                pendingIntent);

        // 15 minute inexact repeating alarm
        /*manager.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                pendingIntent);*/

        Log.i("MainActivity", "Starting alarm @ " + SystemClock.elapsedRealtime());
        Toast.makeText(this, "15-minute repeating alarm set", Toast.LENGTH_SHORT).show();
    }

    public void testAlarm(View view){
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        // One-time alarm
        manager.set(AlarmManager.RTC_WAKEUP,
                10,
                pendingIntent);

        Log.i("MainActivity", "Starting alarm @ " + SystemClock.elapsedRealtime());
        Toast.makeText(this, "Here's your test alarm", Toast.LENGTH_SHORT).show();

        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for half a second
        v.vibrate(500);
    }

    // Getting back into it!
    /*public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
}
