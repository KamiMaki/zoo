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

    ImageButton AR,book,game,food,information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);


        AR=(ImageButton)findViewById(R.id.button1);
        book=(ImageButton)findViewById(R.id.button2);
        game=(ImageButton)findViewById(R.id.button5);
        food=(ImageButton)findViewById(R.id.button4);
        information=(ImageButton)findViewById(R.id.button3);

        AR.setImageResource(R.drawable.ar);
        book.setImageResource(R.drawable.book);
        game.setImageResource(R.drawable.game);
        food.setImageResource(R.drawable.food);
        information.setImageResource(R.drawable.guide);

        //AR


        //AR路標
        AR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, ARActivity.class);
                startActivity(intent);
            }
        });

        //借閱圖書
        book.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, bookActivity.class);
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

        //園區資訊
        information.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, informationActivity.class);
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
