package com.example.colin.questionapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Colin on 12/21/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Placeholder
        Toast.makeText(context, "Here's your alarm", Toast.LENGTH_SHORT).show();
    }
}
