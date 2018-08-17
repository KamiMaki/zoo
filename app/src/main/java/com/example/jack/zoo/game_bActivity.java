package com.example.jack.zoo;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class game_bActivity extends AppCompatActivity {

    private BluetoothAdapter mBluetoothAdapter;
    private ArrayAdapter<String> mylistAdapter;
    private ArrayList<String> bluetoothdeviceslist = new ArrayList<String>();
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;
    private String s1 = "BR517474";
    private String s2 = "BR517474";
    private String s3 = "BR517488";
    double dis1 = 0, dis2 = 0, dis3 = 0, dis = 0, x = 0, y = 0;
    int b_num = -1;
    Boolean isready = false;
    //以上beacon
    Intent intent=new Intent();
    Bundle bundle=new Bundle();
    //Table mTable;
    String[] Place = new String[17];//地點名稱

    int picturenumber;
    int number;

    boolean flag[]=new boolean[17];//flag0~8:紀錄按鈕點擊 flag9:紀錄是否蒐集完畢
    boolean count[]=new boolean[16];//紀錄集點狀況

    private TextView tv,correct;
    private FloatingActionButton information;
    private ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,map;
    String textToSave="",readResult1="";
    int readResult2=0;
    boolean longClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_b);

        checkBluetoothPermission();
        initview();
        SearchBluetooth();
        Timer timer01 = new Timer();
        timer01.schedule(task, 0, 3000);
        //以上beacon



        //把此activity加進activityList
        if (!practiceResultActivity.activityList.contains(game_bActivity.this)) {
            practiceResultActivity.addActivity(game_bActivity.this);
        }

        Place[0]="高氏宗祠文史館";
        Place[1]="昆蟲館";
        Place[2]="大貓熊館";
        Place[3]="教育中心";
        Place[4]="無尾熊館";
        Place[5]="兩棲爬蟲動物館";
        Place[6]="企鵝館";
        Place[7]="臺灣動物區";
        Place[8]="兒童動物區";
        Place[9]="亞洲熱帶雨林區";
        Place[10]="沙漠動物區";
        Place[11]="澳洲動物區";
        Place[12]="非洲動物區";
        Place[13]="溫帶動物區";
        Place[14]="鳥園區";
        Place[15]="酷Cool節能屋";
        Place[16]="恭喜蒐集完所有拼圖!";


        //紀錄按鈕點擊
        for(int i=0;i<17;i++)
            flag[i]=false;

        intent = this.getIntent();
        bundle = intent.getExtras();

        tv = (TextView) findViewById(R.id.textView);
        map = (ImageButton) findViewById(R.id.imageButton36);
        information=(FloatingActionButton) findViewById(R.id.floatingActionButton);
        img1 = (ImageButton) findViewById(R.id.imageButton1);
        img2 = (ImageButton) findViewById(R.id.imageButton2);
        img3 = (ImageButton) findViewById(R.id.imageButton3);
        img4 = (ImageButton) findViewById(R.id.imageButton4);
        img5 = (ImageButton) findViewById(R.id.imageButton5);
        img6 = (ImageButton) findViewById(R.id.imageButton6);
        img7 = (ImageButton) findViewById(R.id.imageButton7);
        img8 = (ImageButton) findViewById(R.id.imageButton8);
        img9 = (ImageButton) findViewById(R.id.imageButton9);
        img10 = (ImageButton) findViewById(R.id.imageButton10);
        img11 = (ImageButton) findViewById(R.id.imageButton11);
        img12 = (ImageButton) findViewById(R.id.imageButton12);
        img13= (ImageButton) findViewById(R.id.imageButton13);
        img14= (ImageButton) findViewById(R.id.imageButton14);
        img15= (ImageButton) findViewById(R.id.imageButton15);
        img16= (ImageButton) findViewById(R.id.imageButton16);
        correct= (TextView) findViewById(R.id.textView14);

        map.setImageResource(R.drawable.areamap);

        readFile1();
        readFile2();

        resetImage();

        if(count[0]&&count[1]&&count[2]&&count[3]&&count[4]&&count[5]&&count[6]&&count[7]&&count[8]&&count[9]&&count[10]&&count[11]&&count[12]&&count[13]&&count[14]&&count[15])
            flag[16]=true;

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
        img1.setOnTouchListener(i1Tcl);//为imagebutton设置按键響應事件
        img2.setOnTouchListener(i2Tcl);
        img3.setOnTouchListener(i3Tcl);
        img4.setOnTouchListener(i4Tcl);
        img5.setOnTouchListener(i5Tcl);
        img6.setOnTouchListener(i6Tcl);
        img7.setOnTouchListener(i7Tcl);
        img8.setOnTouchListener(i8Tcl);
        img9.setOnTouchListener(i9Tcl);
        img10.setOnTouchListener(i10Tcl);
        img11.setOnTouchListener(i11Tcl);
        img12.setOnTouchListener(i12Tcl);
        img13.setOnTouchListener(i13Tcl);
        img14.setOnTouchListener(i14Tcl);
        img15.setOnTouchListener(i15Tcl);
        img16.setOnTouchListener(i16Tcl);

        img1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img13.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img14.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img15.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });

        img16.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longClicked = true;
                return true;
            }
        });


        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(game_bActivity.this, mapsActivity.class);

                //如果沒有點選，則picturenumber為未蒐集到的第一個地點編號
                for(int i=0;i<16;i++)
                {
                    if(count[i]==false)
                    {
                        picturenumber=i;
                        break;
                    }
                }
                //如果有點選，則picturenumber為點選地點編號
                for(int i=0;i<16;i++)
                {
                    if(flag[i]==true)
                    {
                        picturenumber=i;
                        break;
                    }
                }
                startActivity(intent);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(game_bActivity.this, gameIFM2Activity.class);
                startActivity(intent);
            }
        });


        Thread t1 = new Thread(r1);
        t1.start();
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
                number = bundle.getInt("number");
                count[number]=true;

                writeFile1();//存檔
                readFile1();

                resetImage();
                if(count[0]&&count[1]&&count[2]&&count[3]&&count[4]&&count[5]&&count[6]&&count[7]&&count[8]&&count[9]&&count[10]&&count[11]&&count[12]&&count[13]&&count[14]&&count[15])
                    flag[16]=true;



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
                if(flag[16])
                {
                    tv.setText(Place[16]);
                }
                correct.setText(readResult1+"題");
                setResult(RESULT_OK,intent);
            }
        }
    };

    //設置圖片
    public void resetImage(){
        if(count[0])
            img1.setImageResource(R.mipmap.a_a);
        else
            img1.setImageResource(R.mipmap.a);
        if(count[1])
            img2.setImageResource(R.mipmap.b_b);
        else
            img2.setImageResource(R.mipmap.b);
        if(count[2])
            img3.setImageResource(R.mipmap.c_c);
        else
            img3.setImageResource(R.mipmap.c);
        if(count[3])
            img4.setImageResource(R.mipmap.d_d);
        else
            img4.setImageResource(R.mipmap.d);
        if(count[4])
            img5.setImageResource(R.mipmap.e_e);
        else
            img5.setImageResource(R.mipmap.e);
        if(count[5])
            img6.setImageResource(R.mipmap.f_f);
        else
            img6.setImageResource(R.mipmap.f);
        if(count[6])
            img7.setImageResource(R.mipmap.g_g);
        else
            img7.setImageResource(R.mipmap.g);
        if(count[7])
            img8.setImageResource(R.mipmap.h_h);
        else
            img8.setImageResource(R.mipmap.h);
        if(count[8])
            img9.setImageResource(R.mipmap.i_i);
        else
            img9.setImageResource(R.mipmap.i);
        if(count[9])
            img10.setImageResource(R.mipmap.j_j);
        else
            img10.setImageResource(R.mipmap.j);
        if(count[10])
            img11.setImageResource(R.mipmap.k_k);
        else
            img11.setImageResource(R.mipmap.k);
        if(count[11])
            img12.setImageResource(R.mipmap.l_l);
        else
            img12.setImageResource(R.mipmap.l);
        if(count[12])
            img13.setImageResource(R.mipmap.m_m);
        else
            img13.setImageResource(R.mipmap.m);
        if(count[13])
            img14.setImageResource(R.mipmap.n_n);
        else
            img14.setImageResource(R.mipmap.n);
        if(count[14])
            img15.setImageResource(R.mipmap.o_o);
        else
            img15.setImageResource(R.mipmap.o);
        if(count[15])
            img16.setImageResource(R.mipmap.p_p);
        else
            img16.setImageResource(R.mipmap.p);
    }

    //存檔(已答過的館)
    public void writeFile1(){

        for(int i=0;i<16;i++){
            if(count[i]==true){
                textToSave+=Integer.toString(i)+" ";//存入true的數字
            }
        }
        try{
            FileOutputStream fileOutputStream=openFileOutput("AmazooGameFile1.txt", MODE_PRIVATE);
            fileOutputStream.write(textToSave.getBytes());
            fileOutputStream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //讀檔(已答過的館)
    public void readFile1(){
        try{
            FileInputStream fileInputStream=openFileInput("AmazooGameFile1.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer= new StringBuffer();

            String lines;
            while((lines=bufferedReader.readLine())!=null){
                stringBuffer.append(lines);
            }
            String[] number = stringBuffer.toString().split(" ");
            int i=0;
            while(i<number.length){
                int a=Integer.parseInt(number[i]);
                count[a]=true;
                i++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    //讀檔(已答對的題數)
    public void readFile2(){
        try{
            FileInputStream fileInputStream=openFileInput("AmazooGameFile2.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer= new StringBuffer();

            String lines;
            while((lines=bufferedReader.readLine())!=null){
                stringBuffer.append(lines);
            }
            readResult1 = stringBuffer.toString();//字串
            readResult2=Integer.parseInt(readResult1);//整數

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private View.OnClickListener i1cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[0]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 0);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i2cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[1]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 1);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i3cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[2]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 2);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i4cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[3]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 3);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i5cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[4]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 4);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i6cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[5]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 5);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i7cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[6]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 6);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i8cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[7]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 7);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i9cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[8]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 8);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i10cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[9]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 9);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i11cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[10]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 10);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i12cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[11]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 11);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i13cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[12]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 12);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i14cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[13]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 13);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i15cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[14]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 14);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };

    private View.OnClickListener i16cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(count[15]==false){
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                bundle.putInt("input", 15);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        }
    };


    //按住細節
    private View.OnTouchListener i1Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[0]);
                    img1.setImageResource(R.mipmap.a_a);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[0])
                    img1.setImageResource(R.mipmap.a_a);
                else
                    img1.setImageResource(R.mipmap.a);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i2Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[1]);
                    img2.setImageResource(R.mipmap.b_b);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[1])
                    img2.setImageResource(R.mipmap.b_b);
                else
                    img2.setImageResource(R.mipmap.b);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i3Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[2]);
                    img3.setImageResource(R.mipmap.c_c);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[2])
                    img3.setImageResource(R.mipmap.c_c);
                else
                    img3.setImageResource(R.mipmap.c);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[2]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i4Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[3]);
                    img4.setImageResource(R.mipmap.d_d);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[3])
                    img4.setImageResource(R.mipmap.d_d);
                else
                    img4.setImageResource(R.mipmap.d);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i5Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[4]);
                    img5.setImageResource(R.mipmap.e_e);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[4])
                    img5.setImageResource(R.mipmap.e_e);
                else
                    img5.setImageResource(R.mipmap.e);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i6Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[5]);
                    img6.setImageResource(R.mipmap.f_f);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[5])
                    img6.setImageResource(R.mipmap.f_f);
                else
                    img6.setImageResource(R.mipmap.f);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i7Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[6]);
                    img7.setImageResource(R.mipmap.g_g);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[6])
                    img7.setImageResource(R.mipmap.g_g);
                else
                    img7.setImageResource(R.mipmap.g);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i8Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[7]);
                    img8.setImageResource(R.mipmap.h_h);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[7])
                    img8.setImageResource(R.mipmap.h_h);
                else
                    img8.setImageResource(R.mipmap.h);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i9Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[8]);
                    img9.setImageResource(R.mipmap.i_i);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[8])
                    img9.setImageResource(R.mipmap.i_i);
                else
                    img9.setImageResource(R.mipmap.i);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i10Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[9]);
                    img10.setImageResource(R.mipmap.j_j);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[9])
                    img10.setImageResource(R.mipmap.j_j);
                else
                    img10.setImageResource(R.mipmap.j);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i11Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[10]);
                    img11.setImageResource(R.mipmap.k_k);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[10])
                    img11.setImageResource(R.mipmap.k_k);
                else
                    img11.setImageResource(R.mipmap.k);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i12Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[11]);
                    img12.setImageResource(R.mipmap.l_l);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[11])
                    img12.setImageResource(R.mipmap.l_l);
                else
                    img12.setImageResource(R.mipmap.l);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i13Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[12]);
                    img13.setImageResource(R.mipmap.m_m);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[12])
                    img13.setImageResource(R.mipmap.m_m);
                else
                    img13.setImageResource(R.mipmap.m);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i14Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[13]);
                    img14.setImageResource(R.mipmap.n_n);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[13])
                    img14.setImageResource(R.mipmap.n_n);
                else
                    img14.setImageResource(R.mipmap.n);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i15Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[14]);
                    img15.setImageResource(R.mipmap.o_o);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[14])
                    img15.setImageResource(R.mipmap.o_o);
                else
                    img15.setImageResource(R.mipmap.o);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    private View.OnTouchListener i16Tcl = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            for(int i=0;i<16;i++)
                flag[i]=false;
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if(longClicked) {
                    tv.setText(Place[15]);
                    img16.setImageResource(R.mipmap.p_p);
                }
                Log.i("log", "action_down");
                return false;
            }
            else if (event.getAction() == MotionEvent.ACTION_UP)
            {
                if(count[15])
                    img16.setImageResource(R.mipmap.p_p);
                else
                    img16.setImageResource(R.mipmap.p);
                if(flag[16]==false)//還沒蒐集完畢
                    tv.setText("");
                else
                    tv.setText(Place[16]);
                Log.i("log", "action_up");
                return false;
            }
            return false;
        }
    };

    //以下beacon
    private TimerTask task = new TimerTask() {
        public void run() {
            Thread t2 = new Thread(r2);
            t2.start();
        }
    };
    private Runnable r2 = new Runnable() {
        public void run() {
            if(isready)
            {
                mBluetoothAdapter.startDiscovery();
                if (mBluetoothAdapter.isDiscovering()) {
                    mBluetoothAdapter.cancelDiscovery();
                }

            }
        }
    };
    private void initview() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter != null) {

            if (!mBluetoothAdapter.isEnabled()) {

                mBluetoothAdapter.enable();
            }
        }
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();




    }

    private void checkBluetoothPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android M Permission check
            if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_COARSE_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_COARSE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }
                break;
        }
    }

    public void SearchBluetooth() {
        if (mBluetoothAdapter == null) {//当mBluetoothAdapter == null说明该手机没有蓝牙设备
            Toast.makeText(this, "設備不支持藍芽", Toast.LENGTH_SHORT).show();
            finish();
        }

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(myreceiver, filter); //注册一个广播来接收搜索蓝牙过后的结果，之后才能进行配对
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(myreceiver, filter);
        isready = true;
    }

    private final BroadcastReceiver myreceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            //收到的廣播類型
            String action = intent.getAction();
            //發現設備的廣播
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                //從intent中獲取設備
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                int rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE);

                double txPower = -59;
                double ratio = rssi * 1.0 / txPower;

                if (ratio < 1.0) {
                    dis = Math.pow(ratio, 10);
                } else {
                    dis = (0.89976) * Math.pow(ratio, 7.7095) + 0.111;
                }
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    //添加到列表
                    if (device.getName() != null) {
                        if (device.getName().equals(s2) || device.getName().equals(s3)) {

                            if (dis <= 50.0) {
                                if (device.getName().equals(s3) && b_num!=3) {
                                    b_num = 3;
                                    final AlertDialog.Builder alertadd = new AlertDialog.Builder(game_bActivity.this);
                                    LayoutInflater factory = LayoutInflater.from(game_bActivity.this);
                                    final View view = factory.inflate(R.layout.dialog1, null);
                                    alertadd.setView(view);
                                    alertadd.setNeutralButton("我知道了", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            //tv.setText(Place[6]);
                                        }
                                    });
                                    alertadd.setNegativeButton("進入遊戲", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            Intent intent = new Intent();
                                            Bundle bundle=new Bundle();
                                            intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                                            bundle.putInt("input", 6);
                                            intent.putExtras(bundle);
                                            startActivityForResult(intent,0);
                                        }
                                    });
                                    alertadd.show();
                                } else if (device.getName().equals(s2) && b_num!=2) {
                                    b_num = 2;
                                    final AlertDialog.Builder alertadd = new AlertDialog.Builder(game_bActivity.this);
                                    LayoutInflater factory = LayoutInflater.from(game_bActivity.this);
                                    final View view = factory.inflate(R.layout.dialog2, null);
                                    alertadd.setView(view);
                                    alertadd.setNeutralButton("我知道了", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            //tv.setText(Place[2]);

                                        }
                                    });
                                    alertadd.setNegativeButton("進入遊戲", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            Intent intent = new Intent();
                                            Bundle bundle=new Bundle();
                                            intent.setClass(game_bActivity.this, qrcode_aActivity.class);
                                            bundle.putInt("input", 2);
                                            intent.putExtras(bundle);
                                            startActivityForResult(intent,0);
                                        }
                                    });
                                    alertadd.show();
                                }
                            }
                        }
                    }
                }
                //搜索完成
            }
            else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {


            }
        }
    };

    public  boolean turnOffBluetooth()

    {
        if (mBluetoothAdapter != null)

        {
            return mBluetoothAdapter.disable();
        }
        return false;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {

        if(keyCode == KeyEvent.KEYCODE_BACK )
        {
            turnOffBluetooth();
            this.finish();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_game,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent();
        intent.setClass(game_bActivity.this, gameIFM1Activity.class);
        startActivity(intent);
        return true;
        //return super.onOptionsItemSelected(item);
    }
}
