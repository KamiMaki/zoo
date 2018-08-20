package com.example.jack.zoo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class rewardActivity extends AppCompatActivity {

    TextView correct;
    ImageButton bt;
    ImageView img1,img2;
    String readResult1="";
    int readResult2=0;
    Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);

        correct= (TextView) findViewById(R.id.textView20);
        bt=findViewById(R.id.imageButton41);
        img1=findViewById(R.id.imageView25);
        img2=findViewById(R.id.imageView26);

        img1.setImageResource(R.drawable.reward1);
        img2.setImageResource(R.drawable.reward2);
        bt.setImageResource(R.drawable.reward3);

        intent = this.getIntent();

        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final AlertDialog.Builder alertadd = new AlertDialog.Builder(rewardActivity.this);
                LayoutInflater factory = LayoutInflater.from(rewardActivity.this);
                if(readResult2>=40){
                    final View view = factory.inflate(R.layout.dialog3, null);
                    alertadd.setView(view);
                    alertadd.setNeutralButton("結束", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int sumthin) {
                        }
                    });
                    alertadd.show();
                }
                else if(readResult2>=0){
                    final View view = factory.inflate(R.layout.dialog3, null);
                    alertadd.setView(view);
                    alertadd.setNeutralButton("結束", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int sumthin) {
                        }
                    });
                    alertadd.show();
                }
                else{
                    Toast.makeText(rewardActivity.this,"答對題數尚未達到標準",Toast.LENGTH_SHORT).show();
                }
            }
        });

        Thread t1 = new Thread(r1);
        t1.start();
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
                readFile2();

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

                correct.setText(readResult1+"題");
                setResult(RESULT_OK,intent);
            }
        }
    };

    //讀檔(已答對的題數)
    public void readFile2(){
        try{
            FileInputStream fileInputStream=openFileInput("AmazooGameFile2.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer= new StringBuffer();

            String lines;
            while((lines=bufferedReader.readLine())!=null){
                stringBuffer.append(lines);
            }
            readResult1 = stringBuffer.toString();//字串
            readResult2=Integer.parseInt(readResult1);//整數

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
