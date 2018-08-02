package com.example.jack.zoo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class qrcode_aActivity extends AppCompatActivity {

    ImageButton ib;
    Intent intent = new Intent();
    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_a);

        ib=(ImageButton)findViewById(R.id.imageButton);
        ib.setImageResource(R.drawable.qrcode2);

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

                if(result.getContents().equals("企鵝")){
                    n=0;}
                else if(result.getContents().equals("大貓熊")){
                    n=1;}
                else if(result.getContents().equals("無尾熊")){
                    n=2;}
                intent.setClass(qrcode_aActivity.this, practiceActivity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("input", n);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

