package com.example.jack.zoo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class practiceActivity extends AppCompatActivity {

    TextView tt;
    TextView tv1,tv2,tv3;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9;
    RadioGroup rg1,rg2,rg3;
    ImageButton bt;


    Intent intent=new Intent();
    Bundle bundle= new Bundle();
    String[] title = new String[16];//館別
    String[][] practice = new String[16][3];//題目
    String[][] answer = new String[16][9];
    int number;
    int correct=0;
    boolean count[]=new boolean[16];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        tt = (TextView)findViewById(R.id.textView10);
        tv1 = (TextView)findViewById(R.id.textView8);
        tv2 = (TextView)findViewById(R.id.textView3);
        tv3 = (TextView)findViewById(R.id.textView11);
        rb1 = (RadioButton)findViewById(R.id.radioButton1);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        rb4 = (RadioButton)findViewById(R.id.radioButton4);
        rb5 = (RadioButton)findViewById(R.id.radioButton5);
        rb6 = (RadioButton)findViewById(R.id.radioButton6);
        rb7 = (RadioButton)findViewById(R.id.radioButton7);
        rb8 = (RadioButton)findViewById(R.id.radioButton8);
        rb9 = (RadioButton)findViewById(R.id.radioButton9);
        rg1=(RadioGroup)findViewById(R.id.radioGroup1);
        rg2=(RadioGroup)findViewById(R.id.radioGroup2);
        rg3=(RadioGroup)findViewById(R.id.radioGroup3);
        bt=(ImageButton)findViewById(R.id.imageButton43);


        title[0]="高氏宗祠文史館";
        title[1]="昆蟲館";
        title[2]="大貓熊館";
        title[3]="教育中心";
        title[4]="無尾熊館";
        title[5]="兩棲爬蟲動物館";
        title[6]="企鵝館";
        title[7]="臺灣動物區";
        title[8]="兒童動物區";
        title[9]="亞洲熱帶雨林區";
        title[10]="沙漠動物區";
        title[11]="澳洲動物區";
        title[12]="非洲動物區";
        title[13]="溫帶動物區";
        title[14]="鳥園區";
        title[15]="酷Cool節能屋";
        practice[0][0]="";
        practice[0][1]="";
        practice[0][2]="";
        practice[1][0]="";
        practice[1][1]="";
        practice[1][2]="";
        practice[2][0]="Q1.請問大貓熊天然棲地的平均氣溫為?";
        practice[2][1]="Q2.以下哪一項不是大貓熊棲地的重要條件?";//!
        practice[2][2]="Q3.大貓熊的體色為什麼是黑白相間的?";
        practice[3][0]="";
        practice[3][1]="";
        practice[3][2]="";
        practice[4][0]="Q1.請問無尾熊吃什麼樹的葉子?";
        practice[4][1]="Q2.無尾熊的主要棲息地是?";
        practice[4][2]="Q3.以下何者並非無尾熊的特徵?";
        practice[5][0]="";
        practice[5][1]="";
        practice[5][2]="";
        practice[6][0]="Q1.請問台北市立動物園的企鵝館櫥窗內未展出以下哪一種企鵝?";
        practice[6][1]="Q2.現存企鵝中體型最大的是?";
        practice[6][2]="Q3.以下何者錯誤?";
        practice[7][0]="";
        practice[7][1]="";
        practice[7][2]="";
        practice[8][0]="";
        practice[8][1]="";
        practice[8][2]="";
        practice[9][0]="";
        practice[9][1]="";
        practice[9][2]="";
        practice[10][0]="";
        practice[10][1]="";
        practice[10][2]="";
        practice[11][0]="";
        practice[11][1]="";
        practice[11][2]="";
        practice[12][0]="";
        practice[12][1]="";
        practice[12][2]="";
        practice[13][0]="";
        practice[13][1]="";
        practice[13][2]="";
        practice[14][0]="";
        practice[14][1]="";
        practice[14][2]="";
        practice[15][0]="";
        practice[15][1]="";
        practice[15][2]="";
        answer[0][0]="";
        answer[0][1]="";
        answer[0][2]="";
        answer[0][3]="";
        answer[0][4]="";
        answer[0][5]="";
        answer[0][6]="";
        answer[0][7]="";
        answer[0][8]="";
        answer[1][0]="";
        answer[1][1]="";
        answer[1][2]="";
        answer[1][3]="";
        answer[1][4]="";
        answer[1][5]="";
        answer[1][6]="";
        answer[1][7]="";
        answer[1][8]="";
        answer[2][0]="18~25度C";
        answer[2][1]="6~17度C";
        answer[2][2]="0~5度C";
        answer[2][3]="乾淨的活水源";
        answer[2][4]="同伴數目多";
        answer[2][5]="發育良好的箭竹";
        answer[2][6]="因為跟斑馬是近親";
        answer[2][7]="使牠們便於藏匿";
        answer[2][8]="使牠們更容易發現彼此";
        answer[3][0]="";
        answer[3][1]="";
        answer[3][2]="";
        answer[3][3]="";
        answer[3][4]="";
        answer[3][5]="";
        answer[3][6]="";
        answer[3][7]="";
        answer[3][8]="";
        answer[4][0]="尤加利樹";
        answer[4][1]="橄欖樹";
        answer[4][2]="麵包樹";
        answer[4][3]="澳洲東部";
        answer[4][4]="美洲西部";
        answer[4][5]="非洲南部";
        answer[4][6]="無毛具細紋的腳掌";
        answer[4][7]="銳利捲曲的長爪";
        answer[4][8]="細長靈活的尾巴";
        answer[5][0]="";
        answer[5][1]="";
        answer[5][2]="";
        answer[5][3]="";
        answer[5][4]="";
        answer[5][5]="";
        answer[5][6]="";
        answer[5][7]="";
        answer[5][8]="";
        answer[6][0]="國王企鵝";
        answer[6][1]="黑腳企鵝";
        answer[6][2]="巴布亞企鵝";
        answer[6][3]="國王企鵝";
        answer[6][4]="皇家企鵝";
        answer[6][5]="皇帝企鵝";
        answer[6][6]="跳岩企鵝性情溫馴";
        answer[6][7]="南極圈數量最多企鵝的是阿德利企鵝";
        answer[6][8]="國王企鵝兩耳部分帶有橙色斑點";
        answer[7][0]="";
        answer[7][1]="";
        answer[7][2]="";
        answer[7][3]="";
        answer[7][4]="";
        answer[7][5]="";
        answer[7][6]="";
        answer[7][7]="";
        answer[7][8]="";
        answer[8][0]="";
        answer[8][1]="";
        answer[8][2]="";
        answer[8][3]="";
        answer[8][4]="";
        answer[8][5]="";
        answer[8][6]="";
        answer[8][7]="";
        answer[8][8]="";
        answer[9][0]="";
        answer[9][1]="";
        answer[9][2]="";
        answer[9][3]="";
        answer[9][4]="";
        answer[9][5]="";
        answer[9][6]="";
        answer[9][7]="";
        answer[9][8]="";
        answer[10][0]="";
        answer[10][1]="";
        answer[10][2]="";
        answer[10][3]="";
        answer[10][4]="";
        answer[10][5]="";
        answer[10][6]="";
        answer[10][7]="";
        answer[10][8]="";
        answer[11][0]="";
        answer[11][1]="";
        answer[11][2]="";
        answer[11][3]="";
        answer[11][4]="";
        answer[11][5]="";
        answer[11][6]="";
        answer[11][7]="";
        answer[11][8]="";
        answer[12][0]="";
        answer[12][1]="";
        answer[12][2]="";
        answer[12][3]="";
        answer[12][4]="";
        answer[12][5]="";
        answer[12][6]="";
        answer[12][7]="";
        answer[12][8]="";
        answer[13][0]="";
        answer[13][1]="";
        answer[13][2]="";
        answer[13][3]="";
        answer[13][4]="";
        answer[13][5]="";
        answer[13][6]="";
        answer[13][7]="";
        answer[13][8]="";
        answer[14][0]="";
        answer[14][1]="";
        answer[14][2]="";
        answer[14][3]="";
        answer[14][4]="";
        answer[14][5]="";
        answer[14][6]="";
        answer[14][7]="";
        answer[14][8]="";
        answer[15][0]="";
        answer[15][1]="";
        answer[15][2]="";
        answer[15][3]="";
        answer[15][4]="";
        answer[15][5]="";
        answer[15][6]="";
        answer[15][7]="";
        answer[15][8]="";
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
            tv1.setText(practice[number][0]);
            tv2.setText(practice[number][1]);
            tv3.setText(practice[number][2]);
            rb1.setText(answer[number][0]);
            rb2.setText(answer[number][1]);
            rb3.setText(answer[number][2]);
            rb4.setText(answer[number][3]);
            rb5.setText(answer[number][4]);
            rb6.setText(answer[number][5]);
            rb7.setText(answer[number][6]);
            rb8.setText(answer[number][7]);
            rb9.setText(answer[number][8]);
            setResult(RESULT_OK,intent);
            }
        }
    };



    public void answer ()
    {
        correct=0;
        if(number==0){
            //依選取項目顯示不同訊息
            switch(rg1.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    break;
                case R.id.radioButton2:
                    correct+=1;
                    break;
                case R.id.radioButton3:
                    break;
            }
            switch(rg2.getCheckedRadioButtonId()){
                case R.id.radioButton4:
                    break;
                case R.id.radioButton5:
                    correct+=1;
                    break;
                case R.id.radioButton6:
                    break;
            }
            switch(rg3.getCheckedRadioButtonId()){
                case R.id.radioButton7:
                    break;
                case R.id.radioButton8:
                    break;
                case R.id.radioButton9:
                    correct+=1;
                    break;
            }
            intent.setClass(practiceActivity.this, practiceResultActivity.class);
            bundle.putInt("correct",correct);
            bundle.putInt("number",number);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
            practiceActivity.this.finish();
        }
        else if(number==2){
            //依選取項目顯示不同訊息
            switch(rg1.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    break;
                case R.id.radioButton2:
                    correct+=1;
                    break;
                case R.id.radioButton3:
                    break;
            }
            switch(rg2.getCheckedRadioButtonId()){
                case R.id.radioButton4:
                    break;
                case R.id.radioButton5:
                    correct+=1;
                    break;
                case R.id.radioButton6:
                    break;
            }
            switch(rg3.getCheckedRadioButtonId()){
                case R.id.radioButton7:
                    break;
                case R.id.radioButton8:
                    break;
                case R.id.radioButton9:
                    correct+=1;
                    break;
            }
            intent.setClass(practiceActivity.this, practiceResultActivity.class);
            bundle.putInt("correct",correct);
            bundle.putInt("number",number);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
            practiceActivity.this.finish();
        }
        else if(number==4){
            //依選取項目顯示不同訊息
            switch(rg1.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    correct+=1;
                    break;
                case R.id.radioButton2:
                    break;
                case R.id.radioButton3:
                    break;
            }
            switch(rg2.getCheckedRadioButtonId()){
                case R.id.radioButton4:
                    correct+=1;
                    break;
                case R.id.radioButton5:
                    break;
                case R.id.radioButton6:
                    break;
            }
            switch(rg3.getCheckedRadioButtonId()){
                case R.id.radioButton7:
                    break;
                case R.id.radioButton8:
                    break;
                case R.id.radioButton9:
                    correct+=1;
                    break;
            }
            intent.setClass(practiceActivity.this, practiceResultActivity.class);
            bundle.putInt("correct",correct);
            bundle.putInt("number",number);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
            practiceActivity.this.finish();
        }
        else if(number==6){
            //依選取項目顯示不同訊息
            switch(rg1.getCheckedRadioButtonId()){
                case R.id.radioButton1:
                    break;
                case R.id.radioButton2:
                    break;
                case R.id.radioButton3:
                    correct+=1;
                    break;
            }
            switch(rg2.getCheckedRadioButtonId()){
                case R.id.radioButton4:
                    break;
                case R.id.radioButton5:
                    break;
                case R.id.radioButton6:
                    correct+=1;
                    break;
            }
            switch(rg3.getCheckedRadioButtonId()){
                case R.id.radioButton7:
                    correct+=1;
                    break;
                case R.id.radioButton8:
                    break;
                case R.id.radioButton9:
                    break;
            }
            intent.setClass(practiceActivity.this, practiceResultActivity.class);
            bundle.putInt("correct",correct);
            bundle.putInt("number",number);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
            practiceActivity.this.finish();
        }
    }
}
