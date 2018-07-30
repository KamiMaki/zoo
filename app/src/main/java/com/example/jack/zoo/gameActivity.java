package com.example.jack.zoo;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class gameActivity extends AppCompatActivity{

    private BluetoothAdapter mBluetoothAdapter;
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;
    private String s1 = "BR517474";
    private String s2 = "BR517474";
    private String s3 = "BR517488";
    double dis1, dis2, dis3, dis, x, y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        checkBluetoothPermission();
        initview();
        SearchBluetooth();
        Timer timer01 = new Timer();
        timer01.schedule(task, 0, 3000);
        dis1 = 0;
        dis2 = 0;
        dis3 = 0;
        x = 0;
        y = 0;
    }
    private TimerTask task = new TimerTask() {
        public void run() {
            Thread t2 = new Thread(r2);
            t2.start();
        }
    };
    private Runnable r2 = new Runnable() {
        public void run() {
            mBluetoothAdapter.startDiscovery();
            if (mBluetoothAdapter.isDiscovering()) {
                mBluetoothAdapter.cancelDiscovery();
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

        mBluetoothAdapter.startDiscovery();


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

        if (!mBluetoothAdapter.isEnabled()) {//返回值为true，说明蓝牙已打开
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 1);
            //搜索附近设备前，你需要先查询配对好了的蓝牙设备集（可能你现在需要配对的设备在之前就已经配对好了的，这样就能直接进行连 接，能节约很多资源）

        }


        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(myreceiver, filter); //注册一个广播来接收搜索蓝牙过后的结果，之后才能进行配对
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(myreceiver, filter);
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
                                if (device.getName().equals(s3)) {
                                    final AlertDialog.Builder alertadd = new AlertDialog.Builder(gameActivity.this);
                                    LayoutInflater factory = LayoutInflater.from(gameActivity.this);
                                    final View view = factory.inflate(R.layout.dialog1, null);
                                    alertadd.setView(view);
                                    alertadd.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            mBluetoothAdapter.startDiscovery();
                                            if (mBluetoothAdapter.isDiscovering()) {
                                                mBluetoothAdapter.cancelDiscovery();
                                            }

                                        }
                                    });
                                    alertadd.show();
                                } else if (device.getName().equals(s2)) {
                                    final AlertDialog.Builder alertadd = new AlertDialog.Builder(gameActivity.this);
                                    LayoutInflater factory = LayoutInflater.from(gameActivity.this);
                                    final View view = factory.inflate(R.layout.dialog2, null);
                                    alertadd.setView(view);
                                    alertadd.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            mBluetoothAdapter.startDiscovery();
                                            if (mBluetoothAdapter.isDiscovering()) {
                                                mBluetoothAdapter.cancelDiscovery();
                                            }

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
}




