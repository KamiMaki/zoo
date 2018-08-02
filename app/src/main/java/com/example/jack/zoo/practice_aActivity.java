package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class practice_aActivity extends AppCompatActivity {

    TextView tt = (TextView)findViewById(R.id.textView10);
    TextView tv = (TextView)findViewById(R.id.textView8);
    RadioGroup rg = (RadioGroup)findViewById(R.id.radioGroupa);

    Intent intent;
    Bundle bundle;
    String[] title = new String[3];//館別
    String[] practice = new String[3];//題目
    String[] answer = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_a);

        intent = this.getIntent();
        bundle = intent.getExtras();
        title[0]="企鵝館";
        title[1]="大貓熊館";
        title[2]="無尾熊館";
    }

    public void show (View v)
    {
        //依選取項目顯示不同訊息
        switch(rg.getCheckedRadioButtonId()){
            case R.id.radioButton1:
                tv.setText("adults ticktet"); //顯示結果
                break;
            case R.id.radioButton2:
                tv.setText("children ticket"); //顯示結果
                break;
            case R.id.radioButton3:
                tv.setText("senior ticket"); //顯示結果
                break;
        }
    }
}
