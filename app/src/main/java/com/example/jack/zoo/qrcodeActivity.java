package com.example.jack.zoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class qrcodeActivity extends AppCompatActivity {

    Intent intent= new Intent();
    Bundle bundle= new Bundle();
    ImageButton introduce,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        intent=this.getIntent();
        introduce=(ImageButton)findViewById(R.id.imageButton34);
        show=(ImageButton)findViewById(R.id.imageButton33);

        introduce.setImageResource(R.drawable.introduce);
        show.setImageResource(R.drawable.show);


        introduce.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setClass(qrcodeActivity.this, introduce_aActivity.class);
                startActivity(intent);
            }
        });

        show.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setClass(qrcodeActivity.this, show_aActivity.class);
                startActivity(intent);
            }
        });

    }


}
