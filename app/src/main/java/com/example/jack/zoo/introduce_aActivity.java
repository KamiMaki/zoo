package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class introduce_aActivity extends AppCompatActivity {

    ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;
    Intent intent=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_a);

        intent=this.getIntent();
        img1=(ImageButton)findViewById(R.id.imageButton32);
        img2=(ImageButton)findViewById(R.id.imageButton31);
        img3=(ImageButton)findViewById(R.id.imageButton30);
        img4=(ImageButton)findViewById(R.id.imageButton29);
        img5=(ImageButton)findViewById(R.id.imageButton28);
        img6=(ImageButton)findViewById(R.id.imageButton27);
        img7=(ImageButton)findViewById(R.id.imageButton26);
        img8=(ImageButton)findViewById(R.id.imageButton25);
        img9=(ImageButton)findViewById(R.id.imageButton24);
        img10=(ImageButton)findViewById(R.id.imageButton23);
        img11=(ImageButton)findViewById(R.id.imageButton22);
        img12=(ImageButton)findViewById(R.id.imageButton21);
        img13=(ImageButton)findViewById(R.id.imageButton20);
        img14=(ImageButton)findViewById(R.id.imageButton19);
        img15=(ImageButton)findViewById(R.id.imageButton18);
        img16=(ImageButton)findViewById(R.id.imageButton17);

        img1.setImageResource(R.mipmap.a__a);
        img2.setImageResource(R.mipmap.b__b);
        img3.setImageResource(R.mipmap.c__c);
        img4.setImageResource(R.mipmap.d__d);
        img5.setImageResource(R.mipmap.e__e);
        img6.setImageResource(R.mipmap.f__f);
        img7.setImageResource(R.mipmap.g__g);
        img8.setImageResource(R.mipmap.h__h);
        img9.setImageResource(R.mipmap.i__i);
        img10.setImageResource(R.mipmap.j__j);
        img11.setImageResource(R.mipmap.k__k);
        img12.setImageResource(R.mipmap.l__l);
        img13.setImageResource(R.mipmap.m__m);
        img14.setImageResource(R.mipmap.n__n);
        img15.setImageResource(R.mipmap.o__o);
        img16.setImageResource(R.mipmap.p__p);

        img1.setOnClickListener(i1cl);
        img2.setOnClickListener(i2cl);
        img3.setOnClickListener(i3cl);
        img4.setOnClickListener(i4cl);
        img5.setOnClickListener(i5cl);
        img6.setOnClickListener(i6cl);
        img7.setOnClickListener(i7cl);
        img8.setOnClickListener(i8cl);
        img9.setOnClickListener(i9cl);
        img10.setOnClickListener(i10cl);
        img11.setOnClickListener(i11cl);
        img12.setOnClickListener(i12cl);
        img13.setOnClickListener(i13cl);
        img14.setOnClickListener(i14cl);
        img15.setOnClickListener(i15cl);
        img16.setOnClickListener(i16cl);
    }

    private View.OnClickListener i1cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 0);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i2cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 1);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i3cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 2);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i4cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 3);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i5cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 4);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i6cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 5);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i7cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 6);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i8cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 7);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i9cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 8);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i10cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 9);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i11cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 10);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i12cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 11);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i13cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 12);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i14cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 13);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i15cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 14);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };

    private View.OnClickListener i16cl =new View.OnClickListener(){
        public void onClick(View v) {
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            intent.setClass(introduce_aActivity.this, introduce_bActivity.class);
            bundle.putInt("input", 15);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }
    };


}
