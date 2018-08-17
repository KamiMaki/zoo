package com.example.jack.zoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class practiceResultActivity extends AppCompatActivity {

    Intent intent=new Intent();
    Bundle bundle=new Bundle();
    TextView cr,ncr;
    ImageButton ans,back;
    //boolean count[]=new boolean[16];
    int n,number;
    public static List<Activity> activityList = new LinkedList<Activity>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_result);


        ans = (ImageButton)findViewById(R.id.imageButton38);
        back = (ImageButton)findViewById(R.id.imageButton37);
        ans.setImageResource(R.drawable.answer);
        back.setImageResource(R.drawable.home);

        intent = this.getIntent();
        bundle = intent.getExtras();
        cr = (TextView)findViewById(R.id.textView12);
        ncr = (TextView)findViewById(R.id.textView13);
        Thread t1 = new Thread(r1);
        t1.start();

        ans.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.setClass(practiceResultActivity.this, practiceAnsActivity.class);
                bundle.putInt("number",number);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                intent.setClass(practiceResultActivity.this, gameActivity.class);
                bundle.putInt("number",number);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
                practiceResultActivity.this.finish();
                finishActivity();
            }
        });

    }

    //把其他activity加進activityList
    public static void addActivity(Activity activity) {
        if (!activityList.contains(activity)) {
            activityList.add(activity);
        }
    }

    //刪除activityList裡的activity
    public static void finishActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
                n=bundle.getInt("correct");
                number=bundle.getInt("number");
            } catch (Exception e) {
                Log.e("Net", "Fail to put");
            }
            Message message = new Message();
            message.what = 1;
            h1.sendMessage(message);

        }
    };

    Handler h1 = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                String n1=Integer.toString(n);
                String n2=Integer.toString(3-n);
                cr.setText(n1);
                ncr.setText(n2);
                setResult(RESULT_OK,intent);
            }
        }
    };


    //返回鍵失效
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
