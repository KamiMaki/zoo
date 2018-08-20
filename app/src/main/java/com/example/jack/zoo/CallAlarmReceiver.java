package com.example.jack.zoo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;

import java.util.Calendar;

public class CallAlarmReceiver extends BroadcastReceiver {

    int number;
    Bundle bundle=new Bundle();

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        bundle = intent.getExtras();
        number = bundle.getInt("number");
        bundle.putInt("number", number);
        intent.putExtras(bundle);
        Intent alaramIntent = new Intent(context, show_bActivity.class);
        alaramIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(alaramIntent);
    }
}
