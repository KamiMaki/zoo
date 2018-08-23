package com.example.jack.zoo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class book_aActivity extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17,bt18,bt19,bt20;
    boolean reserve[]=new boolean[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_a);

        bt1=findViewById(R.id.button1);
        bt2=findViewById(R.id.button2);
        bt3=findViewById(R.id.button3);
        bt4=findViewById(R.id.button4);
        bt5=findViewById(R.id.button5);
        bt6=findViewById(R.id.button6);
        bt7=findViewById(R.id.button7);
        bt8=findViewById(R.id.button8);
        bt9=findViewById(R.id.button9);
        bt10=findViewById(R.id.button10);
        bt11=findViewById(R.id.button11);
        bt12=findViewById(R.id.button12);
        bt13=findViewById(R.id.button13);
        bt14=findViewById(R.id.button14);
        bt15=findViewById(R.id.button15);
        bt16=findViewById(R.id.button16);
        bt17=findViewById(R.id.button17);
        bt18=findViewById(R.id.button18);
        bt19=findViewById(R.id.button19);
        bt20=findViewById(R.id.button20);


        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 0);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 1);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 2);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 3);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 4);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 5);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 6);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 7);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 8);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 9);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 10);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 11);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 12);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 13);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 14);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 15);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 16);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 17);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 18);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });

        bt20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(book_aActivity.this, book_bActivity.class);
                bundle.putInt("number", 19);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });
    }
}
