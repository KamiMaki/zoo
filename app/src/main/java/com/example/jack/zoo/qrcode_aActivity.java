package com.example.jack.zoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class qrcode_aActivity extends AppCompatActivity {

    ImageButton ib;
    TextView tt;
    TextView tv;
    Intent intent = new Intent();
    Bundle bundle=new Bundle();
    String[] title = new String[16];//館別
    String[] hint = new String[16];//提示
    int n;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_a);

        intent = this.getIntent();
        bundle = intent.getExtras();
        ib=(ImageButton)findViewById(R.id.imageButton);
        ib.setImageResource(R.drawable.qrcode2);
        tt = (TextView)findViewById(R.id.textView6);
        tv = (TextView)findViewById(R.id.textView7);

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

        hint[0]="先測試";
        hint[1]="先測試";
        hint[2]="我在有團團圓圓背影的介紹旁邊喔";
        hint[3]="先測試";
        hint[4]="我在珍珠跟Q弟的介紹掛牌中間喔";
        hint[5]="先測試";
        hint[6]="我在國王企鵝的展示櫥窗附近喔";
        hint[7]="先測試";
        hint[8]="先測試";
        hint[9]="先測試";
        hint[10]="先測試";
        hint[11]="先測試";
        hint[12]="先測試";
        hint[13]="先測試";
        hint[14]="先測試";
        hint[15]="先測試";



        Thread t1 = new Thread(r1);
        t1.start();

        final Activity activity = this;
        ib.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

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
            if (msg.what == 1&&bundle!=null) {
                tt.setText(title[number]);
                tv.setText(hint[number]);
                setResult(RESULT_OK,intent);
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result!= null)
        {
            if (result.getContents()==null)
            {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_SHORT).show();
            }
            else
            {
                //Toast.makeText(this,result.getContents(),Toast.LENGTH_SHORT).show();

                if(result.getContents().equals("高氏宗祠文史館")){
                    n=0;}
                else if(result.getContents().equals("昆蟲館")){
                    n=1;}
                else if(result.getContents().equals("大貓熊館")){
                    n=2;}
                else if(result.getContents().equals("教育中心")){
                    n=3;}
                else if(result.getContents().equals("無尾熊館")){
                    n=4;}
                else if(result.getContents().equals("兩棲爬蟲動物館")){
                    n=5;}
                else if(result.getContents().equals("企鵝館")){
                    n=6;}
                else if(result.getContents().equals("臺灣動物區")){
                    n=7;}
                else if(result.getContents().equals("兒童動物區")){
                    n=8;}
                else if(result.getContents().equals("亞洲熱帶雨林區")){
                    n=9;}
                else if(result.getContents().equals("沙漠動物區")){
                    n=10;}
                else if(result.getContents().equals("澳洲動物區")){
                    n=11;}
                else if(result.getContents().equals("非洲動物區")){
                    n=12;}
                else if(result.getContents().equals("溫帶動物區")){
                    n=13;}
                else if(result.getContents().equals("鳥園區")){
                    n=14;}
                else if(result.getContents().equals("酷Cool節能屋")){
                    n=15;}
                intent.setClass(qrcode_aActivity.this, practiceActivity.class);
                bundle.putInt("input", n);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
                qrcode_aActivity.this.finish();
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

