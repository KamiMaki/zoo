package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainScreen extends AppCompatActivity {

    ImageView background;
    ImageButton camera,information,map,game,food,video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        background = (ImageView) findViewById(R.id.backimage);
        camera=(ImageButton)findViewById(R.id.button1);
        information=(ImageButton)findViewById(R.id.button3);
        map=(ImageButton)findViewById(R.id.button2);
        game=(ImageButton)findViewById(R.id.button5);
        food=(ImageButton)findViewById(R.id.button4);
        video=(ImageButton)findViewById(R.id.button6);

        background.setImageResource(R.drawable.background);
        camera.setImageResource(R.drawable.camera);
        information.setImageResource(R.drawable.guide);
        map.setImageResource(R.drawable.roadsign);
        game.setImageResource(R.drawable.game);
        food.setImageResource(R.drawable.food);
        video.setImageResource(R.drawable.video);

        //AR相機
        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, cameraActivity.class);
                startActivity(intent);
            }
        });

        //AR路標
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("ame.Company.comm");
                //intent.setClass(MainScreen.this, webview.class);
                //Bundle bundle = new Bundle();
                //bundle.putInt("position", 1);
                //intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //園區資訊
        information.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, informationActivity.class);
                startActivity(intent);
            }
        });

        //用餐
        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, foodActivity.class);
                startActivity(intent);
            }
        });

        //闖關遊戲
        game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, gameActivity.class);
                startActivity(intent);
            }
        });

        //AR多媒體
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("test123.Company.com");
               // intent.setClass(MainScreen.this, animalActivity.class);
                startActivity(intent);
            }
        });
    }

    private ImageButton.OnClickListener scan = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");// 連結ZXING的API，開啟條碼掃描器
            intent.putExtra("SCAN_MODE", "SCAN_MODE");// 設定參數，兩種條碼都讀

            //因為要回傳掃描結果所以要使用startActivityForResult
            startActivityForResult(intent, 1);// 要求回傳1
        }
    };

    //設定onActivityResult
    //startActivityForResult會將值傳回到onActivity
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    //requestCode在startActivityForResult傳入參數時決定的，如果成功的話會傳回相同的值
        if (requestCode == 1) {
        //成功回傳值
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");//ZXing回傳的內容
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");//ZXing回傳的格式
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {}// Handle cancel

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }



}
