package com.example.jack.zoo;
//鬧鐘提醒
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

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
        Intent alarmIntent = new Intent(context, show_bActivity.class);
        alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(alarmIntent);
    }
}
