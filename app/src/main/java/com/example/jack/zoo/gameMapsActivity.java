package com.example.jack.zoo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class gameMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Location newLocation=new Location("newlocation");   //變動座標

    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1;
    //設定超過一個距離(尺)他就會做更新location的動作
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000;
    //設定超過一個時間(毫秒)他就會做更新location的動作

    protected LocationManager locationManager;
    protected AudioManager audioManager;
    protected Vibrator vibrator;
    // public final static int NOTIFICATION_ID = "NotificationActivityDemo".hashCode();

    Intent intent;
    Intent intent2;
    Bundle bundle;
    Bundle bundle2;
    //Table mTable;
    String[] Place = new String[16];//地點名稱
    String lat[] = new String[16];//緯度
    String lon[] = new String[16];//經度
    Double latnum[] = new Double[16];//緯度
    Double lonnum[] = new Double[16];//經度
    float Distance[] = new float[16];//距離
    int picturenumber;//點選圖片編號
    boolean count[]=new boolean[16];//紀錄集點狀況
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //mTable = new Table("http://140.113.73.102:8000/api/", "group12", "class", "asdf1234");//連結資料庫

        Thread t1 = new Thread(rr1);
        t1.start();

        //取得物件
        intent = this.getIntent();
        bundle = intent.getExtras();
        //bundle=getIntent().getExtras();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(
                //Provider: the name of the GPS provider
                LocationManager.GPS_PROVIDER,
                //minTime: 最小時間間隔後更新位置，以毫秒為單位
                MINIMUM_TIME_BETWEEN_UPDATES,
                //minDistance: 最短距離間隔外更新位置，以公尺為單位
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                //Listener:每次地點更新時會呼叫LocationListener中onLocationChanged(Location) 		     方法
                new MyLocationListener()
        );
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE); //此方法是由Context调用的
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);  //同上

        count[0] = bundle.getBoolean("count[0]");
        count[1] = bundle.getBoolean("count[1]");
        count[2] = bundle.getBoolean("count[2]");
        count[3] = bundle.getBoolean("count[3]");
        count[4] = bundle.getBoolean("count[4]");
        count[5] = bundle.getBoolean("count[5]");
        count[6] = bundle.getBoolean("count[6]");
        count[7] = bundle.getBoolean("count[7]");
        count[8] = bundle.getBoolean("count[8]");
        count[9] = bundle.getBoolean("count[9]");
        count[10] = bundle.getBoolean("count[10]");
        count[11] = bundle.getBoolean("count[11]");
        count[12] = bundle.getBoolean("count[12]");
        count[13] = bundle.getBoolean("count[13]");
        count[14] = bundle.getBoolean("count[14]");
        count[15] = bundle.getBoolean("count[15]");
        picturenumber=bundle.getInt("picturenumber");//取得圖片編號
    }

    private Runnable rr1 = new Runnable() {
        public void run() {
/*            try {
                Tuple tuple_get[] = mTable.get();
                for (int i = 0; i < 9; i++) {
                    Place[i] = tuple_get[i].get("text1");
                    lat[i] = tuple_get[i].get("text2");
                    lon[i] = tuple_get[i].get("text3");
                    latnum[i] = Double.valueOf(lat[i]);
                    lonnum[i] = Double.valueOf(lon[i]);
                }
            } catch (IOException e) {
                Log.e("Net", "Fail to get");
            }
*/
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
            latnum[0]=24.785360;
            latnum[1]=24.787100;
            latnum[2]=24.786296;
            latnum[3]=24.787479;
            latnum[4]=24.784752;
            latnum[5]=24.790032;
            latnum[6]=24.992944;
            latnum[7]=24.997923;
            latnum[8]=24.998885;
            latnum[9]=24.994722;
            latnum[10]=24.995008;
            latnum[11]=24.994663;
            latnum[12]=24.9951333;
            latnum[13]=24.992773;
            latnum[14]=24.995604;
            latnum[15]=24.995394;
            lonnum[0]=120.999315;
            lonnum[1]=121.000179;
            lonnum[2]=120.999632;
            lonnum[3]=121.000833;
            lonnum[4]=120.999551;
            lonnum[5]=120.997500;
            lonnum[6]=121.590773;
            lonnum[7]=121.580458;
            lonnum[8]=121.582295;
            lonnum[9]=121.583016;
            lonnum[10]=121.585454;
            lonnum[11]=121.585767;
            lonnum[12]=121.5880094;
            lonnum[13]=121.590272;
            lonnum[14]=121.589816;
            lonnum[15]=121.585483;
        }
    };

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng P1 = new LatLng(latnum[0], lonnum[0]);
        LatLng P2 = new LatLng(latnum[1], lonnum[1]);
        LatLng P3 = new LatLng(latnum[2], lonnum[2]);
        LatLng P4 = new LatLng(latnum[3], lonnum[3]);
        LatLng P5 = new LatLng(latnum[4], lonnum[4]);
        LatLng P6 = new LatLng(latnum[5], lonnum[5]);
        LatLng P7 = new LatLng(latnum[6], lonnum[6]);
        LatLng P8 = new LatLng(latnum[7], lonnum[7]);
        LatLng P9 = new LatLng(latnum[8], lonnum[8]);
        LatLng P10 = new LatLng(latnum[9], lonnum[9]);
        LatLng P11 = new LatLng(latnum[10], lonnum[10]);
        LatLng P12 = new LatLng(latnum[11], lonnum[11]);
        LatLng P13 = new LatLng(latnum[12], lonnum[12]);
        LatLng P14 = new LatLng(latnum[13], lonnum[13]);
        LatLng P15 = new LatLng(latnum[14], lonnum[14]);
        LatLng P16 = new LatLng(latnum[15], lonnum[15]);
        LatLng Point = new LatLng(latnum[picturenumber],lonnum[picturenumber]);

        //初使16個Marker
        mMap.addMarker(new MarkerOptions().position(P1).title(Place[0]));
        mMap.addMarker(new MarkerOptions().position(P2).title(Place[1]));
        mMap.addMarker(new MarkerOptions().position(P3).title(Place[2]));
        mMap.addMarker(new MarkerOptions().position(P4).title(Place[3]));
        mMap.addMarker(new MarkerOptions().position(P5).title(Place[4]));
        mMap.addMarker(new MarkerOptions().position(P6).title(Place[5]));
        mMap.addMarker(new MarkerOptions().position(P7).title(Place[6]));
        mMap.addMarker(new MarkerOptions().position(P8).title(Place[7]));
        mMap.addMarker(new MarkerOptions().position(P9).title(Place[8]));
        mMap.addMarker(new MarkerOptions().position(P10).title(Place[9]));
        mMap.addMarker(new MarkerOptions().position(P11).title(Place[10]));
        mMap.addMarker(new MarkerOptions().position(P12).title(Place[11]));
        mMap.addMarker(new MarkerOptions().position(P13).title(Place[12]));
        mMap.addMarker(new MarkerOptions().position(P14).title(Place[13]));
        mMap.addMarker(new MarkerOptions().position(P15).title(Place[14]));
        mMap.addMarker(new MarkerOptions().position(P16).title(Place[15]));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //藍點表示現在位置
        mMap.setMyLocationEnabled(true);
        //在「我的位置」圖層已啟用的情況下，[My Location] 按鈕會在地圖的右上角出現。
        // 如果已知目前的裝置位置，當使用者按一下該按鈕時，相機會把該位置放在地圖中央。
        // 如果裝置停滯不前，會在地圖上以藍色小點指出該位置；如果正在移動，會以＞形箭號呈現。


        //初使為點選地點
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Point, 18));
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(13);
        mMap.animateCamera(zoom);
    }

    private class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            //將想要印出的資料用string.format的方法存入string
            //%1$s，%2$s中，1、2代表後方第幾個參數

            //取得現在位置經緯度
            newLocation.setLatitude(location.getLatitude());
            newLocation.setLongitude(location.getLongitude());

            //16個地點的位置、與現在位置的距離
            Location Location1=new Location("Location1");
            Location1.setLatitude(latnum[0]);
            Location1.setLongitude(lonnum[0]);
            Distance[0] = newLocation.distanceTo(Location1);
            Location Location2=new Location("Location2");
            Location1.setLatitude(latnum[1]);
            Location1.setLongitude(lonnum[1]);
            Distance[1] = newLocation.distanceTo(Location2);
            Location Location3=new Location("Location3");
            Location3.setLatitude(latnum[2]);
            Location3.setLongitude(lonnum[2]);
            Distance[2] = newLocation.distanceTo(Location3);
            Location Location4=new Location("Location4");
            Location4.setLatitude(latnum[3]);
            Location4.setLongitude(lonnum[3]);
            Distance[3] = newLocation.distanceTo(Location4);
            Location Location5=new Location("Location5");
            Location1.setLatitude(latnum[4]);
            Location1.setLongitude(lonnum[4]);
            Distance[4] = newLocation.distanceTo(Location5);
            Location Location6=new Location("Location6");
            Location6.setLatitude(latnum[5]);
            Location6.setLongitude(lonnum[5]);
            Distance[5] = newLocation.distanceTo(Location6);
            Location Location7=new Location("Location7");
            Location7.setLatitude(latnum[6]);
            Location7.setLongitude(lonnum[6]);
            Distance[6] = newLocation.distanceTo(Location7);
            Location Location8=new Location("Location8");
            Location8.setLatitude(latnum[7]);
            Location8.setLongitude(lonnum[7]);
            Distance[7] = newLocation.distanceTo(Location8);
            Location Location9=new Location("Location9");
            Location9.setLatitude(latnum[8]);
            Location9.setLongitude(lonnum[8]);
            Distance[8] = newLocation.distanceTo(Location9);
            Location Location10=new Location("Location10");
            Location1.setLatitude(latnum[9]);
            Location1.setLongitude(lonnum[9]);
            Distance[9] = newLocation.distanceTo(Location10);
            Location Location11=new Location("Location11");
            Location1.setLatitude(latnum[10]);
            Location1.setLongitude(lonnum[10]);
            Distance[10] = newLocation.distanceTo(Location11);
            Location Location12=new Location("Location12");
            Location1.setLatitude(latnum[11]);
            Location1.setLongitude(lonnum[11]);
            Distance[11] = newLocation.distanceTo(Location12);
            Location Location13=new Location("Location13");
            Location1.setLatitude(latnum[12]);
            Location1.setLongitude(lonnum[12]);
            Distance[12] = newLocation.distanceTo(Location13);
            Location Location14=new Location("Location14");
            Location1.setLatitude(latnum[13]);
            Location1.setLongitude(lonnum[13]);
            Distance[13] = newLocation.distanceTo(Location14);
            Location Location15=new Location("Location15");
            Location1.setLatitude(latnum[14]);
            Location1.setLongitude(lonnum[14]);
            Distance[14] = newLocation.distanceTo(Location15);
            Location Location16=new Location("Location16");
            Location1.setLatitude(latnum[15]);
            Location1.setLongitude(lonnum[15]);
            Distance[15] = newLocation.distanceTo(Location16);



            for(int i=0;i<16;i++) {
                if (Distance[i] <= 30&&Distance[i]>=20) {
                    Toast.makeText(gameMapsActivity.this, "距"+Place[i]+Distance[i]+"公尺", Toast.LENGTH_LONG).show();
                    Thread t1 = new Thread(r1);
                    t1.start();
                    Thread t2 = new Thread(r2);
                    t2.start();
                    break;
                }
                else if (Distance[i] <= 15&&count[i]==false) {
                    Toast.makeText(gameMapsActivity.this, "地點 "+Place[i]+" 已獲得", Toast.LENGTH_LONG).show(); //地點1 綜合一館 已獲得
                    count[i]=true;
                    break;
                }
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
            //當device的GPS沒有開啟的時候他會顯示
            Toast.makeText(gameMapsActivity.this, "Provider disabled by the user. GPS turned off", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
            //當device將GPS打開的時候他會顯示
            Toast.makeText(gameMapsActivity.this, "Provider enabled by the user. GPS turned on", Toast.LENGTH_LONG).show();
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
            //當provider change的時候會顯示
            Toast.makeText(gameMapsActivity.this, "Provider status changed", Toast.LENGTH_LONG).show();
        }
    }


    //發出提示音
    private Runnable r1 = new Runnable()
    {
        public void run()
        {
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone rt = RingtoneManager.getRingtone(getApplicationContext(), uri);
            rt.play();
        }
    };

    //震動
    private Runnable r2 = new Runnable()
    {
        public void run()
        {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                //deprecated in API 26
                v.vibrate(500);

                //if (mVibrator != null) {
                // 震动 1s
                //   mVibrator.vibrate(1000);
            }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // Do something.
            //Intent intent = new Intent();
            //intent.setClass(MapsActivity.this, MainActivity.class);
            //Bundle bundle = new Bundle();
            bundle.putBoolean("count[0]",count[0]);
            bundle.putBoolean("count[1]",count[1]);
            bundle.putBoolean("count[2]",count[2]);
            bundle.putBoolean("count[3]",count[3]);
            bundle.putBoolean("count[4]",count[4]);
            bundle.putBoolean("count[5]",count[5]);
            bundle.putBoolean("count[6]",count[6]);
            bundle.putBoolean("count[7]",count[7]);
            bundle.putBoolean("count[8]",count[8]);
            bundle.putBoolean("count[9]",count[9]);
            bundle.putBoolean("count[10]",count[10]);
            bundle.putBoolean("count[11]",count[11]);
            bundle.putBoolean("count[12]",count[12]);
            bundle.putBoolean("count[13]",count[13]);
            bundle.putBoolean("count[14]",count[14]);
            bundle.putBoolean("count[15]",count[15]);

            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            //startActivityForResult(intent,1);
            //startActivity(intent);
            gameMapsActivity.this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
