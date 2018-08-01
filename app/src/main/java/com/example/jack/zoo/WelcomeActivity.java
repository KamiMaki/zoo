package com.example.jack.zoo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        img=(ImageView)findViewById(R.id.imageView3);
        img.setImageResource(R.drawable.start);

        mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 1500);//1.5秒跳轉
    }

    private static final int GOTO_MAIN_ACTIVITY = 0;

    private Handler mHandler = new Handler(){

        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    Intent intent = new Intent();
                    intent.setClass(WelcomeActivity.this, MainScreen.class);
                    startActivity(intent);
                    finish();
                    break;

                default:
                    break;
            }
        };
    };
}
