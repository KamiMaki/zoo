package com.example.jack.zoo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class practiceAnsActivity extends AppCompatActivity {

    Intent intent=new Intent();
    Bundle bundle=new Bundle();
    TextView explanation;
    String[] ans = new String[16];//解析
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_ans);

        explanation = (TextView)findViewById(R.id.textView16);
        intent = this.getIntent();
        bundle = intent.getExtras();
        Thread t1 = new Thread(r1);
        t1.start();

        ans[0]="";
        ans[1]="";
        ans[2]="A1."+"\n"+"大貓熊天然棲地的平均氣溫為6至17度。牠們在演化的過程中，早已習慣低溫環境。" +"\n"+
                "A2."+"\n"+"大貓熊的棲地一般具備乾淨的活水源與發育良好的箭竹。" +"\n"+
                "貓熊為獨居動物，所以時常獨來獨往，除了繁殖季節會進行短短幾天的交配。" +"\n"+
                "A3."+"\n"+"大貓熊黑白相間的體色是一種醒目的視覺信號可以讓獨來獨往的他們輕易地發現彼此，避免發生領域爭執，繁殖期也更容易找到對象。";
        ans[3]="";
        ans[4]="A1."+"\n"+"無尾熊以尤加利樹葉和嫩枝為食" +"\n"+
                "A2."+"\n"+"無尾熊分布於澳洲大陸的東部及東南部，當地的澳大利亞森林大多由尤加利樹組成。" +"\n"+
                "A3."+"\n"+"無尾熊具備無毛具細紋的腳掌以及銳利捲曲的長爪使其更擅於攀爬。" +"\n"+
                "牠的尾巴因退化而短小，但不影響牠的平衡感。";
        ans[5]="";
        ans[6]="A1."+"\n"+"台北動物園的櫥窗內只展示了國王企鵝與黑腳企鵝兩種企鵝。" +"\n"+
                "A2."+"\n"+"皇帝企鵝是現存企鵝中體型最大的。" +"\n"+
                "A3."+"\n"+"跳岩企鵝最具攻擊性，並不溫馴。";
        ans[7]="";
        ans[8]="";
        ans[9]="";
        ans[10]="";
        ans[11]="";
        ans[12]="";
        ans[13]="";
        ans[14]="";
        ans[15]="";
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
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
                explanation.setText(ans[number]);
                setResult(RESULT_OK,intent);
            }
        }
    };
}
