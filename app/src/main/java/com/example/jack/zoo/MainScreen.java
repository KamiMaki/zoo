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
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainScreen extends AppCompatActivity {

    ImageButton AR,book,game,food,information;
    private BluetoothAdapter mBluetoothAdapter;
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;
    private String s1 = "BR517474";
    private String s2 = "BR517474";
    private String s3 = "BR517488";
    double dis = 0;
    int b_num = -1;
    Boolean isready = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        checkBluetoothPermission();
        initview();
        SearchBluetooth();
        mBluetoothAdapter.startDiscovery();
        Log.e("discovering","discovering");
        //Timer timer01 = new Timer();
        //timer01.schedule(task, 0, 3000);


        AR=(ImageButton)findViewById(R.id.button1);
        book=(ImageButton)findViewById(R.id.button2);
        game=(ImageButton)findViewById(R.id.button5);
        food=(ImageButton)findViewById(R.id.button4);
        information=(ImageButton)findViewById(R.id.button3);

        AR.setImageResource(R.drawable.ar);
        book.setImageResource(R.drawable.book);
        game.setImageResource(R.drawable.game);
        food.setImageResource(R.drawable.food);
        information.setImageResource(R.drawable.guide);

        //AR


        //AR路標
        AR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, ARActivity.class);
                startActivity(intent);
            }
        });

        //借閱圖書
        book.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, book_aActivity.class);
                startActivity(intent);
            }
        });


        //用餐
        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, foodActivity.class);
                startActivity(intent);
            }
        });

        //闖關遊戲
        game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, gameActivity.class);
                startActivity(intent);
            }
        });

        //園區資訊
        information.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainScreen.this, informationActivity.class);
                startActivity(intent);
            }
        });

        //以下beacon


    }

    private ImageButton.OnClickListener scan = new ImageButton.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent("com.google.zxing.client.android.SCAN");// 連結ZXING的API，開啟條碼掃描器
            intent.putExtra("SCAN_MODE", "SCAN_MODE");// 設定參數，兩種條碼都讀

            //因為要回傳掃描結果所以要使用startActivityForResult
            startActivityForResult(intent, 1);// 要求回傳1
        }
    };

    //設定onActivityResult
    //startActivityForResult會將值傳回到onActivity
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    //requestCode在startActivityForResult傳入參數時決定的，如果成功的話會傳回相同的值
        if (requestCode == 1) {
        //成功回傳值
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");//ZXing回傳的內容
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");//ZXing回傳的格式
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {}// Handle cancel

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

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
                Log.e("discovering","discovering");
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
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);//添加到列表
                    if (device.getName() != null) {

                                if (device.getName().equals(s3)) {
                                    Log.e("found","found");

                                    final AlertDialog.Builder alertadd = new AlertDialog.Builder(MainScreen.this);
                                    LayoutInflater factory = LayoutInflater.from(MainScreen.this);
                                    alertadd.setTitle("表演時間").setMessage("是否要前往設置鬧鐘提醒?").setNeutralButton("前往設置", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            Intent intent = new Intent();
                                            Bundle bundle=new Bundle();
                                            intent.setClass(MainScreen.this, show_aActivity.class);
                                            intent.putExtras(bundle);
                                            startActivityForResult(intent,0);
                                        }
                                    });
                                    alertadd.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {


                                        }
                                    });
                                    alertadd.show();
                                }
                    }
                //搜索完成
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



}
