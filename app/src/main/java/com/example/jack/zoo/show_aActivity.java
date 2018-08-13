package com.example.jack.zoo;

import android.app.AlarmManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class show_aActivity extends AppCompatActivity {
/*
    //使用Calendar指定時間
    Calendar calendar = Calendar.getInstance();
calendar.set(2012, 10, 8, 16, 30);
    //建立意圖
    Intent intent = new Intent();
//這裡的 this 是指當前的 Activity
//AlarmReceiver.class 則是負責接收的 BroadcastReceiver
intent.setClass(this, AlarmReceiver.class);
    //建立待處理意圖
    PendingIntent pending = PendingIntent.getBroadcast(context, 0, intent, 0);
    //取得AlarmManager
    AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//設定一個警報
//參數1,我們選擇一個會在指定時間喚醒裝置的警報類型
//參數2,將指定的時間以millisecond傳入
//參數3,傳入待處理意圖
alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending);
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_a);




    }
/*
    private Runnable r1=new Runnable () {
        public void run() {
            try {
                    AlertDialog.Builder alertadd = new AlertDialog.Builder(show_aActivity.this);
                    LayoutInflater factory = LayoutInflater.from(show_aActivity.this);
                    final View view = factory.inflate(R.layout.dialog1, null);
                    alertadd.setView(view);
                    alertadd.setNeutralButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int sumthin) {

                        }
                    });
                    alertadd.show();

            } catch (Exception e) {
                Log.e("Net", "Fail to put");
            }
        }
    };
    */
}
