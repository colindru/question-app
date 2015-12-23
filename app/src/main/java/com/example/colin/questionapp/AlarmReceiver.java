package com.example.colin.questionapp;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Colin on 12/21/2015.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // This is the Intent to deliver to our service.
        Intent service = new Intent(context, SimpleWakefulService.class);

        Log.i("SimpleWakefulReceiver", "Starting service @ " + SystemClock.elapsedRealtime());
        // Start the service, keeping the device awake while it is launching
        startWakefulService(context, service);
    }

    private class SimpleWakefulService extends IntentService {
        public SimpleWakefulService() {
            super("SimpleWakefulService");
        }

        @Override
        protected void onHandleIntent(Intent intent) {
            Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for half a second
            v.vibrate(500);

            Log.i("SimpleWakefulReceiver", "Completed service @ " + SystemClock.elapsedRealtime());
            AlarmReceiver.completeWakefulIntent(intent);
        }
    }

}