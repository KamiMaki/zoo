package com.example.jack.zoo;
//預約借書
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class bookActivity extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17,bt18,bt19,bt20;
    boolean reserve[]=new boolean[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
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
                if(!reserve[0]) {
                    bt1.setText("取消預約");
                    reserve[0]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt1.setText("預約借書");
                    reserve[0]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!reserve[1]) {
                    bt2.setText("取消預約");
                    reserve[1]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt2.setText("預約借書");
                    reserve[1]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[2]==false) {
                    bt3.setText("取消預約");
                    reserve[2]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt3.setText("預約借書");
                    reserve[2]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[3]==false) {
                    bt4.setText("取消預約");
                    reserve[3]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt4.setText("預約借書");
                    reserve[3]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[4]==false) {
                    bt5.setText("取消預約");
                    reserve[4]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt5.setText("預約借書");
                    reserve[4]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[5]==false) {
                    bt6.setText("取消預約");
                    reserve[5]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt6.setText("預約借書");
                    reserve[5]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[6]==false) {
                    bt7.setText("取消預約");
                    reserve[6]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt7.setText("預約借書");
                    reserve[6]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[7]==false) {
                    bt8.setText("取消預約");
                    reserve[7]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt8.setText("預約借書");
                    reserve[7]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[8]==false) {
                    bt9.setText("取消預約");
                    reserve[8]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt9.setText("預約借書");
                    reserve[8]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[9]==false) {
                    bt10.setText("取消預約");
                    reserve[9]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt10.setText("預約借書");
                    reserve[9]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[10]==false) {
                    bt11.setText("取消預約");
                    reserve[10]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt11.setText("預約借書");
                    reserve[10]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[11]==false) {
                    bt12.setText("取消預約");
                    reserve[11]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt12.setText("預約借書");
                    reserve[11]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[12]==false) {
                    bt13.setText("取消預約");
                    reserve[12]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt13.setText("預約借書");
                    reserve[12]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[13]==false) {
                    bt14.setText("取消預約");
                    reserve[13]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt14.setText("預約借書");
                    reserve[13]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[14]==false) {
                    bt15.setText("取消預約");
                    reserve[14]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt15.setText("預約借書");
                    reserve[14]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[15]==false) {
                    bt16.setText("取消預約");
                    reserve[15]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt16.setText("預約借書");
                    reserve[15]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[16]==false) {
                    bt17.setText("取消預約");
                    reserve[16]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt17.setText("預約借書");
                    reserve[16]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[17]==false) {
                    bt18.setText("取消預約");
                    reserve[17]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt18.setText("預約借書");
                    reserve[17]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[18]==false) {
                    bt19.setText("取消預約");
                    reserve[18]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt19.setText("預約借書");
                    reserve[18]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });

        bt20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(reserve[19]==false) {
                    bt20.setText("取消預約");
                    reserve[19]=true;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("預約成功")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
                else{
                    bt20.setText("預約借書");
                    reserve[19]=false;
                    new AlertDialog.Builder(bookActivity.this)
                            .setMessage("已取消預約")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                }
                            }).show();
                }
            }
        });
    }
}
