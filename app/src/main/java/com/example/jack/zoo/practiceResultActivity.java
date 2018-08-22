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
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class practiceResultActivity extends AppCompatActivity {

    Intent intent=new Intent();
    Bundle bundle=new Bundle();
    TextView cr,ncr,book;//顯示答對/錯題數
    ImageButton ans,back;
    String textToSave="",readResult1="";
    String[] bookname = new String[16];
    //boolean count[]=new boolean[16];
    int n,number,readResult2=0;
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
        book = (TextView)findViewById(R.id.textView23);

        bookname[2]="別吵醒貓熊/克里斯.歐文\n我是大貓熊I'm panda/譚楷文\n大貓熊與瀕危物種/瑪麗.波.奧斯本,娜塔莉.波.博以斯\n熊貓和浣熊/梁潤生";
        bookname[4]="無尾熊壞嘴巴/克莉絲汀.貝潔\n當無尾熊遇到老虎:認識自己的天賦特質/張曼琳";
        bookname[6]="小企鵝釣大魚！/宮西達也\n企鵝/陳炳煌\n365隻企鵝/尚路克．佛羅門塔\n正能量企鵝/るるてあRURUTEA\n波普先生的企鵝/理查.艾特瓦特夫婦\n企鵝熱氣球/林世仁\n工藤紀子繪本集:小企鵝歡樂旅程/工藤紀子";


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
                intent.setClass(practiceResultActivity.this, game_aActivity.class);
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
                readFile2();
                writeFile2();
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
                book.setText(bookname[number]);
                setResult(RESULT_OK,intent);
            }
        }
    };

    //存檔(已答對的題數)
    public void writeFile2(){

        textToSave=Integer.toString(readResult2+n);//存入答對的題數

        try{
            FileOutputStream fileOutputStream=openFileOutput("AmazooGameFile2.txt", MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

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


    //返回鍵失效
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
