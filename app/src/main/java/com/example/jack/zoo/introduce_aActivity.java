package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class introduce_aActivity extends AppCompatActivity {

    ImageButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p;
    Intent intent=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_a);

        intent=this.getIntent();
        a=(ImageButton)findViewById(R.id.imageButton32);
        b=(ImageButton)findViewById(R.id.imageButton31);
        c=(ImageButton)findViewById(R.id.imageButton30);
        d=(ImageButton)findViewById(R.id.imageButton29);
        e=(ImageButton)findViewById(R.id.imageButton28);
        f=(ImageButton)findViewById(R.id.imageButton27);
        g=(ImageButton)findViewById(R.id.imageButton26);
        h=(ImageButton)findViewById(R.id.imageButton25);
        i=(ImageButton)findViewById(R.id.imageButton24);
        j=(ImageButton)findViewById(R.id.imageButton23);
        k=(ImageButton)findViewById(R.id.imageButton22);
        l=(ImageButton)findViewById(R.id.imageButton21);
        m=(ImageButton)findViewById(R.id.imageButton20);
        n=(ImageButton)findViewById(R.id.imageButton19);
        o=(ImageButton)findViewById(R.id.imageButton18);
        p=(ImageButton)findViewById(R.id.imageButton17);

        a.setImageResource(R.drawable.a__a);
    }
}
