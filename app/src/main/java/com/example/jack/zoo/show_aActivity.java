package com.example.jack.zoo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Message;
import android.os.PowerManager;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class show_aActivity extends AppCompatActivity {

    Calendar calendar;
    PendingIntent sender;
    AlarmManager am;
    SimpleDateFormat   format  =   new   SimpleDateFormat   ("HH:mm:ss");
    Date curDate =  new Date(System.currentTimeMillis());
    Switch switch1,switch2,switch3;
    Button bt;
    boolean is_enable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_a);

        switch1=findViewById(R.id.switch1);
        switch2=findViewById(R.id.switch2);
        switch3=findViewById(R.id.switch3);
        bt=findViewById(R.id.button7);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()){
                    onSwitchClicked(switch1);
                }
                else{
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    sender = PendingIntent.getBroadcast(show_aActivity.this, 0, intent, 0);
                    am.cancel(sender);
                    sender=null;
                    am=null;
                    Toast.makeText(show_aActivity.this,"關閉鬧鐘提醒",Toast.LENGTH_SHORT).show();
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()){
                    onSwitchClicked(switch2);
                }
                else{
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    sender = PendingIntent.getBroadcast(show_aActivity.this, 1, intent, 0);
                    am.cancel(sender);
                    sender=null;
                    am=null;
                    Toast.makeText(show_aActivity.this,"關閉鬧鐘提醒",Toast.LENGTH_SHORT).show();
                }
            }
        });

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()){
                    onSwitchClicked(switch3);
                }
                else{
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    sender = PendingIntent.getBroadcast(show_aActivity.this, 2, intent, 0);
                    am.cancel(sender);
                    sender=null;
                    am=null;
                    Toast.makeText(show_aActivity.this,"關閉鬧鐘提醒",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void button_click(View view){
        if(is_enable == true)
        {
            is_enable = false;
            bt.setText("啟用Switch按钮");
        }
        else{
            is_enable = true;
            bt.setText("禁用Switch按钮");
        }
        switch1.setEnabled(is_enable);
        switch2.setEnabled(is_enable);
        switch3.setEnabled(is_enable);
    }

    public void onSwitchClicked(View view) {
        switch(view.getId()) {
            case R.id.switch1://風潮音樂：陶笛阿志
                if (switch1.isChecked()) {
                    // TODO Auto-generated method stub
                    calendar=Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    //int mHour = calendar.get(Calendar.HOUR_OF_DAY);
                    //int mMinute = calendar.get(Calendar.MINUTE);

                    // 设置时间
                    //calendar.setTimeInMillis(System.currentTimeMillis());
                    //calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                    //calendar.set(Calendar.MINUTE,minute);
                    //calendar.set(Calendar.SECOND,0);
                    //calendar.set(Calendar.MILLISECOND,0);

                    calendar.set(2018, 7, 14, 16, 23,1);
                    //广播跳转
                    Bundle bundle=new Bundle();
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    bundle.putInt("number", 1);
                    intent.putExtras(bundle);
                    //启动一个广播
                    sender = PendingIntent.getBroadcast(
                       show_aActivity.this, 0, intent, 0);
                    //创建闹钟
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 86400000, sender);//每日重複

                    String tmpS = format.format(curDate);

                    //SharedPreferences保存数据，并提交
                    SharedPreferences time1Share = getPreferences(0);
                    SharedPreferences.Editor editor = time1Share.edit();
                    editor.putString("TIME1", tmpS);
                    editor.commit();

                    Toast.makeText(show_aActivity.this,"開啟鬧鐘提醒",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.switch2://動物舞蹈帶動跳 Part.1
                if (switch2.isChecked()) {
                    // TODO Auto-generated method stub
                    calendar=Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());

                    calendar.set(2018, 7, 14, 16, 23,30);
                    //广播跳转
                    Bundle bundle=new Bundle();
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    bundle.putInt("number", 1);
                    intent.putExtras(bundle);
                    //启动一个广播
                    sender = PendingIntent.getBroadcast(
                            show_aActivity.this, 1, intent, 0);
                    //创建闹钟
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 86400000, sender);//每日重複


                    String tmpS = format.format(curDate);

                    //SharedPreferences保存数据，并提交
                    SharedPreferences time1Share = getPreferences(0);
                    SharedPreferences.Editor editor = time1Share.edit();
                    editor.putString("TIME1", tmpS);
                    editor.commit();

                    Toast.makeText(show_aActivity.this,"開啟鬧鐘提醒",Toast.LENGTH_SHORT).show();

                }
                break;
            case R.id.switch3://全能保育員：你懂我的心
                if (switch3.isChecked()) {
                    calendar=Calendar.getInstance();
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(2018, 7, 14, 16, 23,50);
                    //广播跳转
                    Bundle bundle=new Bundle();
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    bundle.putInt("number", 2);
                    intent.putExtras(bundle);
                    //启动一个广播
                    sender = PendingIntent.getBroadcast(
                            show_aActivity.this, 2, intent, 0);
                    //创建闹钟
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
                    am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 86400000, sender);//每日重複

                    String tmpS = format.format(curDate);

                    //SharedPreferences保存数据，并提交
                    SharedPreferences time1Share = getPreferences(0);
                    SharedPreferences.Editor editor = time1Share.edit();
                    editor.putString("TIME1", tmpS);
                    editor.commit();

                    Toast.makeText(show_aActivity.this,"開啟鬧鐘提醒",Toast.LENGTH_SHORT).show();
                }
        }
    };


}
