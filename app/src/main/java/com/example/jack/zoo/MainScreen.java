package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.unity3d.player.UnityPlayerActivity;

public class MainScreen extends AppCompatActivity {

    ImageView background;
    ImageButton camera,QRcode,map,game,food,animal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        background = (ImageView) findViewById(R.id.backimage);
        camera=(ImageButton)findViewById(R.id.button1);
        QRcode=(ImageButton)findViewById(R.id.button3);
        map=(ImageButton)findViewById(R.id.button2);
        game=(ImageButton)findViewById(R.id.button5);
        food=(ImageButton)findViewById(R.id.button4);
        animal=(ImageButton)findViewById(R.id.button6);

        background.setImageResource(R.drawable.background);
        camera.setImageResource(R.drawable.camera);
        QRcode.setImageResource(R.drawable.qrcode);
        map.setImageResource(R.drawable.map);
        game.setImageResource(R.drawable.game);
        food.setImageResource(R.drawable.food);
        animal.setImageResource(R.drawable.animal);

        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, cameraActivity.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, mapsActivity.class);
                //Bundle bundle = new Bundle();
                //bundle.putInt("position", 1);
                //intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        QRcode.setOnClickListener(scan);

        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, foodActivity.class);
                startActivity(intent);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, gameActivity.class);
                startActivity(intent);
            }
        });

        animal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, animalActivity.class);
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
