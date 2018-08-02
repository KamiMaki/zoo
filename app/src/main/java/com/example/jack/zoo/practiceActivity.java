package com.example.jack.zoo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class practiceActivity extends AppCompatActivity {

    TextView tt;
    TextView tv;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioGroup rg;
    Button bt;

    Intent intent=new Intent();
    Bundle bundle= new Bundle();
    String[] title = new String[3];//館別
    String[] practice = new String[3];//題目
    String[][] answer = new String[3][3];
    int number;
    boolean count[]=new boolean[16];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        tt = (TextView)findViewById(R.id.textView10);
        tv = (TextView)findViewById(R.id.textView8);
        rb1 = (RadioButton)findViewById(R.id.radioButton1);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        rg=(RadioGroup)findViewById(R.id.radioGroupa);
        bt=(Button)findViewById(R.id.button8);

        title[0]="企鵝館";
        title[1]="大貓熊館";
        title[2]="無尾熊館";
        practice[0]="請問台北市立動物園的企鵝館未展出以下哪一種企鵝?";
        practice[1]="請問大貓熊天然棲地的平均氣溫為";
        practice[2]="請問無尾熊吃什麼樹的葉子?";
        answer[0][0]="國王企鵝";
        answer[0][1]="黑腳企鵝";
        answer[0][2]="巴布亞企鵝";
        answer[1][0]="18~25度C";
        answer[1][1]="6~17度C";
        answer[1][2]="0~5度C";
        answer[2][0]="尤加利樹";
        answer[2][1]="橄欖樹";
        answer[2][2]="麵包樹";
        intent = this.getIntent();
        bundle = intent.getExtras();
        //number=bundle.getInt("input");
        Thread t1 = new Thread(r1);
        t1.start();
        //setResult(RESULT_OK,intent);

        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                answer();
            }
        });
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
                number=bundle.getInt("input");
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
            tt.setText(title[number]);
            tv.setText(practice[number]);
            rb1.setText(answer[number][0]);
            rb2.setText(answer[number][1]);
            rb3.setText(answer[number][2]);
            setResult(RESULT_OK,intent);
            }
        }
    };



    public void answer ()
    {
        if(number==0){
            //依選取項目顯示不同訊息
            switch(rg.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    Toast.makeText(this,"再試試看!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioButton2:
                    Toast.makeText(this,"你確定嗎?",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioButton3:
                    Toast.makeText(this,"恭喜答對!",Toast.LENGTH_SHORT).show();
                    count[0]=true;
                    intent.setClass(practiceActivity.this, gameActivity.class);
                    bundle.putBoolean("count[0]",count[0]);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,1);
                    break;
            }
        }
        if(number==1){
            //依選取項目顯示不同訊息
            switch(rg.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    Toast.makeText(this,"再加把勁!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioButton2:
                    Toast.makeText(this,"恭喜答對!",Toast.LENGTH_SHORT).show();
                    count[1]=true;
                    intent.setClass(practiceActivity.this, gameActivity.class);
                    bundle.putBoolean("count[1]",count[1]);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,1);
                    break;
                case R.id.radioButton3:
                    Toast.makeText(this,"答錯了喔!",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        if(number==2){
            //依選取項目顯示不同訊息
            switch(rg.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    Toast.makeText(this,"恭喜答對!",Toast.LENGTH_SHORT).show();
                    count[2]=true;
                    intent.setClass(practiceActivity.this, gameActivity.class);
                    bundle.putBoolean("count[2]",count[2]);
                    intent.putExtras(bundle);
                    startActivityForResult(intent,1);
                    break;
                case R.id.radioButton2:
                    Toast.makeText(this,"猜錯了喔",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioButton3:
                    Toast.makeText(this,"再試試看吧!",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
