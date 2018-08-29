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
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    String textToSave="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_a);

        switch1=findViewById(R.id.switch1);
        switch2=findViewById(R.id.switch2);
        switch3=findViewById(R.id.switch3);

        //先全開
        //switch1.setChecked(true);
        //switch2.setChecked(true);
        //switch3.setChecked(true);

        readFile();//讀檔讀出已關閉的
        onSwitchClicked(switch1);
        onSwitchClicked(switch2);
        onSwitchClicked(switch3);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()){//若開
                    onSwitchClicked(switch1);
                }
                else{//若關
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    sender = PendingIntent.getBroadcast(show_aActivity.this, 0, intent, 0);
                    am.cancel(sender);
                    sender=null;
                    am=null;
                    Toast.makeText(show_aActivity.this,"關閉鬧鐘提醒",Toast.LENGTH_SHORT).show();
                }
                writeFile();
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
                writeFile();
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
                writeFile();
            }
        });

        Thread t1 = new Thread(r1);
        t1.start();

    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
                writeFile();
                readFile();
            } catch (Exception e) {
                Log.e("Net", "Fail to put");
            }
        }
    };


    //存檔(關著的開關)
    public void writeFile(){

        textToSave="";
        if(switch1.isChecked()==false){
            textToSave+="1";
        }
        if(switch2.isChecked()==false){
            textToSave+=" 2";
        }
        if(switch3.isChecked()==false){
            textToSave+=" 3";
        }

        try{
            FileOutputStream fileOutputStream=openFileOutput("AmazooClockFile.txt", MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //讀檔(關著的開關)
    public void readFile(){
        try{
            FileInputStream fileInputStream=openFileInput("AmazooClockFile.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer= new StringBuffer();

            String lines;
            while((lines=bufferedReader.readLine())!=null){
                stringBuffer.append(lines);
            }

            String[] number = stringBuffer.toString().split(" ");
            int i=0;

            //RelativeLayout layout = (RelativeLayout)findViewById(R.id.r_layout);
            while(i<number.length){
                String a=number[i];
                if(a.equals("1")){
                    switch1.setChecked(false);
                    //layout.addView(switch1);
                }
                else if(a.equals("2")){
                    switch2.setChecked(false);
                    //layout.addView(sb);
                }
                else if(a.equals("3")) {
                    switch3.setChecked(false);
                    //layout.addView(sb);
                }
                i++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
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
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY));
                    calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+1);
                    calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND));
                    //calendar.set(Calendar.MILLISECOND,0);
                    //calendar.set(2018, 7, 14, 16, 23,1);

                    //广播跳转
                    Bundle bundle=new Bundle();
                    Intent intent = new Intent(show_aActivity.this, CallAlarmReceiver.class);
                    bundle.putInt("number", 0);
                    intent.putExtras(bundle);
                    //启动一个广播
                    sender = PendingIntent.getBroadcast(
                       show_aActivity.this, 0, intent, 0);
                    //创建闹钟
                    am = (AlarmManager) getSystemService(ALARM_SERVICE);
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
                    calendar.setTimeInMillis(System.currentTimeMillis());
                    calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY));
                    calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+1);
                    calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND));
                    //calendar.set(2018, 7, 14, 16, 23,30);

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
                    calendar.set(Calendar.HOUR_OF_DAY,calendar.get(Calendar.HOUR_OF_DAY));
                    calendar.set(Calendar.MINUTE,calendar.get(Calendar.MINUTE)+1);
                    calendar.set(Calendar.SECOND,calendar.get(Calendar.SECOND));
                    //calendar.set(2018, 7, 14, 16, 23,50);
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
