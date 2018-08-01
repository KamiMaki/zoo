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

public class qrcode_bActivity extends AppCompatActivity {

    ImageButton ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_b);

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
                //
                Toast.makeText(this,result.getContents(),Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
