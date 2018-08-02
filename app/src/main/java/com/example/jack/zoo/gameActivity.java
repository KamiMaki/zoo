package com.example.jack.zoo;

import android.Manifest;
import android.os.Handler;
import android.os.Message;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class gameActivity extends AppCompatActivity{

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
    Intent intent;
    Bundle bundle;
    //Table mTable;
    String[] Place = new String[17];//地點名稱
    String[] Story = new String[17];//地點介紹

    int picturenumber;

    boolean flag[]=new boolean[17];//flag0~8:紀錄按鈕點擊 flag9:紀錄是否蒐集完畢
    boolean count[]=new boolean[16];//紀錄集點狀況

    private TextView tv;
    private TextView tv2;
    private Button button;
    private ImageButton img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        checkBluetoothPermission();
        initview();
        SearchBluetooth();
        Timer timer01 = new Timer();
        timer01.schedule(task, 0, 3000);

        //以上beacon
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
        Story[0]="位於動物園園外保育公園\n" +
                "\n" +
                "臺北市立動物園現址原名為「頭廷魁」，主要為高氏族人的聚落。民國68年為新建動物園工程，徵收該地，市政府為照顧居民生計，在園外設立販賣區提供高氏族人經營，並於販賣區2樓設置高氏宗祠。後因販賣區改建，遂將高氏宗祠遷移至現址並成立高氏宗祠文史館，並於民國104年1月6日正式開放民眾參觀。高氏宗祠文史館除提供高氏後代子孫祭祀之用，更成為民眾了解在地歷史文化的展示空間。\n" +
                "\n" +
                "開放參觀時間：每週二上午9:00-12:00，若遇例假日則停止開放。";
        Story[1]="昆蟲館分為五大區域：序幕大廳、多媒體視聽教室、臺灣昆蟲區、生態展示室、昆蟲特展區。除了介紹昆蟲的起源與演化、構造與適應，更有溫室及生態網室，讓遊客身處昆蟲圍繞的環境中。館區後方還有一個擁有豐富昆蟲資源的「蟲蟲探索谷」，為本園進行戶外生態解說教育的場所之一。\n" +
                "\n" +
                "每月第四個週一休館";
        Story[2]="大貓熊館包括一個戶外展示場和兩個室內展示場，提供多樣的活動空間及攀爬、遮蔭設施，還有大小石塊及流瀑水。戶外展示場則模擬大貓熊野外棲息地，草坪寬闊，並以濃綠喬木構成背景。\n" +
                "\n" +
                "每月第一個週一休館";
        Story[3]="教育中心包括博物館展示區、圖書館、演講廳、動物藝坊及動物學堂等，為本園展示動物園文化的櫥窗。館內以動物標本、生態全景展示傳達動物知識及保育觀念，最特別的是還有亞洲象「林旺」的標本展示區，以及恐龍模型展示喔！\n" +
                "\n" +
                "每週一休館\n" +
                "入館門票：全票20元、優待票10元\n" +
                "開放時間：9:00-17:00 (16:30停止入館)";
        Story[4]="無尾熊為最具代表性的有袋目動物之一。來自澳洲「庫倫賓野生動物保護區」，代表城市友誼並肩負保育、教育使命的無尾熊們，自引進以來一直都是眾所矚目的焦點。無尾熊館設有多個獨立空間，每間屋頂都有天窗可以讓陽光照射進來。在適當天氣時，無尾熊偶爾也會到戶外展示場活動，享受溫暖的陽光。";
        Story[5]="本館以不同的生態系展示各種兩棲爬蟲活體動物，包括溼地、熱帶雨林、溫帶森林、沙漠等四大類型。除了經常性的動物生態展示區之外，館內還有靜態的解說教育展示區及定期更換主題的特展區，希望藉由各類動物、寫實模型、互動教材與文化藝品的多元展示，引導遊客進入兩棲爬蟲動物的奧秘世界。\n" +
                "\n" +
                "每月第三個週一休館";
        Story[6]="企鵝館展示「國王企鵝」及「黑腳企鵝」，牠們是不會飛的水生鳥類，牠們全是游泳的專家，在水裡潛泳可以「飛」得又快又好。在觀賞可愛的企鵝之餘，也可以在企鵝館了解牠們的分布、形態特徵、生活習性及繁殖求偶行為喔！\n" +
                "\n" +
                "每月第二個週一休館";
        Story[7]="臺灣動物區以臺灣原生動物與棲息環境為展示重點，佈置模擬動物原生棲地之生態環境，讓動物表現如野外般自然的生活習性，引導觀賞者更正確地認識本土野生動物。臺灣位處於亞熱帶，雨量充沛、氣候溫暖，擁有各種地形景觀，因而孕育了豐富龐雜的生物資源。";
        Story[8]="兒童動物園全區以埤塘、水田等各類濕地與郊野生態造景為環境意象，串聯農村動物、經濟動物、寵物、入侵之外來種動物等單元主題，點出人類與動物間的密切關係，提供學童、家長與老師一處共同體驗與學習的空間。";
        Story[9]="亞洲熱帶雨林區模擬東南亞熱帶雨林的自然生態景觀，依展示動線規劃成河口生態、密林生態及林緣生態三大展示區，區內可見板根、氣生根、支柱根、附生植物、林間霧氣等熱帶雨林特有的生態現象。";
        Story[10]="沙漠動物區以隨風搖曳的棕櫚樹模擬中東地區的沙漠環境，展示具代表性的單峰駱駝、雙峰駱駝、非洲野驢和弓角羚羊等。來到這裡，你就能知道動物用什麼方式適應乾旱、高溫及晝夜溫差大的氣候呢？";
        Story[11]="澳洲動物區栽種許多澳洲特有的桉樹，在這裡可以遇到袋鼠、鴯鶓和食火雞喔！澳洲大陸長時間與其他陸塊隔離，繁衍並演化出與其他陸域不同形態的物種，值得大小朋友一起來認識牠們喔！";
        Story[12]="非洲動物區多採動物混群的展示方式，模擬東非莽原情境，讓參觀者在視覺上宛如置身非洲草原。非洲大陸被譽為「野生動物王國」，擁有世界最龐大的動物族群，不僅動物種類豐富，數量亦最為壯觀，快來這裡拜訪陸地上體型最大和身高最高的動物吧！";
        Story[13]="溫帶動物區主要展示棲息於溫帶草原和森林中的動物。地球上廣大的溫帶氣候區有沙漠、草原、落葉林及針帶林等不同生態環境，因此動物種類繁多。然而溫帶氣候也很適合人類居住，因此這裡的動物大多面臨棲息地減少或其他與人有關的生存危機，需要我們一起來關心牠們的保育。";
        Story[14]="鳥園區包括鳥類形態區、雉類與珍禽區、鶴園、鸚鵡房、生態鳥園及水禽區，可以觀察到住在不同棲息地的鳥類，是都會環境中難得的賞鳥據點。歡迎放慢腳步，聽聽悅耳鳥鳴、看看羽色繽紛的輕盈身影，感受另一個廣闊而自由的世界。\n";
        Story[15]="經濟部能源局及工業技術研究院，結合臺北市立動物園的環境教育及生態保育理念，建造這一棟位於沙漠動物區入口處的酷Cool節能屋。這是一座結合空間設計、節能材料及再生能源利用的節能建築，導入童話故事的解說活動，適合全家人一起來體驗。\n" +
                "\n" +
                "每週一休館";


        //紀錄按鈕點擊
        for(int i=0;i<10;i++)
            flag[i]=false;

        intent = this.getIntent();
        bundle = intent.getExtras();

        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);
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

        if(count[0])
            img1.setImageResource(R.mipmap.a);
        else
            img1.setImageResource(R.mipmap.a_a);
        if(count[1])
            img2.setImageResource(R.mipmap.b);
        else
            img2.setImageResource(R.mipmap.b_b);
        if(count[2])
            img3.setImageResource(R.mipmap.c);
        else
            img3.setImageResource(R.mipmap.c_c);
        if(count[3])
            img4.setImageResource(R.mipmap.d);
        else
            img4.setImageResource(R.mipmap.d_d);
        if(count[4])
            img5.setImageResource(R.mipmap.e);
        else
            img5.setImageResource(R.mipmap.e_e);
        if(count[5])
            img6.setImageResource(R.mipmap.f);
        else
            img6.setImageResource(R.mipmap.f_f);
        if(count[6])
            img7.setImageResource(R.mipmap.g);
        else
            img7.setImageResource(R.mipmap.g_g);
        if(count[7])
            img8.setImageResource(R.mipmap.h);
        else
            img8.setImageResource(R.mipmap.h_h);
        if(count[8])
            img9.setImageResource(R.mipmap.i);
        else
            img9.setImageResource(R.mipmap.i_i);
        if(count[9])
            img10.setImageResource(R.mipmap.j);
        else
            img10.setImageResource(R.mipmap.j_j);
        if(count[10])
            img11.setImageResource(R.mipmap.k);
        else
            img11.setImageResource(R.mipmap.k_k);
        if(count[11])
            img12.setImageResource(R.mipmap.l);
        else
            img12.setImageResource(R.mipmap.l_l);
        if(count[12])
            img13.setImageResource(R.mipmap.m);
        else
            img13.setImageResource(R.mipmap.m_m);
        if(count[13])
            img14.setImageResource(R.mipmap.n);
        else
            img14.setImageResource(R.mipmap.n_n);
        if(count[14])
            img15.setImageResource(R.mipmap.o);
        else
            img15.setImageResource(R.mipmap.o_o);
        if(count[15])
            img16.setImageResource(R.mipmap.p);
        else
            img16.setImageResource(R.mipmap.p_p);

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
       


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(gameActivity.this, mapsActivity.class);

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


        Thread t1 = new Thread(r1);
        t1.start();
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
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

                if(count[0])
                    img1.setImageResource(R.mipmap.a);
                else
                    img1.setImageResource(R.mipmap.a_a);
                if(count[1])
                    img2.setImageResource(R.mipmap.b);
                else
                    img2.setImageResource(R.mipmap.b_b);
                if(count[2])
                    img3.setImageResource(R.mipmap.c);
                else
                    img3.setImageResource(R.mipmap.c_c);
                if(count[3])
                    img4.setImageResource(R.mipmap.d);
                else
                    img4.setImageResource(R.mipmap.d_d);
                if(count[4])
                    img5.setImageResource(R.mipmap.e);
                else
                    img5.setImageResource(R.mipmap.e_e);
                if(count[5])
                    img6.setImageResource(R.mipmap.f);
                else
                    img6.setImageResource(R.mipmap.f_f);
                if(count[6])
                    img7.setImageResource(R.mipmap.g);
                else
                    img7.setImageResource(R.mipmap.g_g);
                if(count[7])
                    img8.setImageResource(R.mipmap.h);
                else
                    img8.setImageResource(R.mipmap.h_h);
                if(count[8])
                    img9.setImageResource(R.mipmap.i);
                else
                    img9.setImageResource(R.mipmap.i_i);
                if(count[9])
                    img10.setImageResource(R.mipmap.j);
                else
                    img10.setImageResource(R.mipmap.j_j);
                if(count[10])
                    img11.setImageResource(R.mipmap.k);
                else
                    img11.setImageResource(R.mipmap.k_k);
                if(count[11])
                    img12.setImageResource(R.mipmap.l);
                else
                    img12.setImageResource(R.mipmap.l_l);
                if(count[12])
                    img13.setImageResource(R.mipmap.m);
                else
                    img13.setImageResource(R.mipmap.m_m);
                if(count[13])
                    img14.setImageResource(R.mipmap.n);
                else
                    img14.setImageResource(R.mipmap.n_n);
                if(count[14])
                    img15.setImageResource(R.mipmap.o);
                else
                    img15.setImageResource(R.mipmap.o_o);
                if(count[15])
                    img16.setImageResource(R.mipmap.p);
                else
                    img16.setImageResource(R.mipmap.p_p);
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
                    tv2.setText(Story[16]);
                }
                setResult(RESULT_OK,intent);
            }
        }
    };




    private View.OnClickListener i1cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[0]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[0]=true;
                tv.setText(Place[0]);
                tv2.setText(Story[0]);
                if(count[0]==true)
                    img1.setImageResource(R.mipmap.a_a);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[0])
                        img1.setImageResource(R.mipmap.a);
                    else
                        img1.setImageResource(R.mipmap.a_a);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img1.setImageResource(R.mipmap.a);
                }
            }
        }
    };

    private View.OnClickListener i2cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[1]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[1]=true;
                tv.setText(Place[1]);
                tv2.setText(Story[1]);
                if(count[1]==true)
                    img2.setImageResource(R.mipmap.b_b);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[1])
                        img2.setImageResource(R.mipmap.b);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img2.setImageResource(R.mipmap.b);
                }
            }
        }
    };

    private View.OnClickListener i3cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[2]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[2]=true;
                tv.setText(Place[2]);
                tv2.setText(Story[2]);
                if(count[2])
                    img3.setImageResource(R.mipmap.c_c);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[2])
                        img3.setImageResource(R.mipmap.c);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img3.setImageResource(R.mipmap.c);
                }
            }
        }
    };

    private View.OnClickListener i4cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[3]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[3]=true;
                tv.setText(Place[3]);
                tv2.setText(Story[3]);
                if(count[3])
                    img4.setImageResource(R.mipmap.d_d);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[3])
                        img4.setImageResource(R.mipmap.d);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img4.setImageResource(R.mipmap.d);
                }
            }
        }
    };

    private View.OnClickListener i5cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[4]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[4]=true;
                tv.setText(Place[4]);
                tv2.setText(Story[4]);
                if(count[4])
                    img5.setImageResource(R.mipmap.e_e);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[4])
                        img5.setImageResource(R.mipmap.e);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img5.setImageResource(R.mipmap.e);
                }
            }
        }
    };

    private View.OnClickListener i6cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[5]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[5]=true;
                tv.setText(Place[5]);
                tv2.setText(Story[5]);
                if(count[5])
                    img6.setImageResource(R.mipmap.f_f);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[5])
                        img6.setImageResource(R.mipmap.f);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img6.setImageResource(R.mipmap.f);
                }
            }
        }
    };

    private View.OnClickListener i7cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[6]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[6]=true;
                tv.setText(Place[6]);
                tv2.setText(Story[6]);
                if(count[6])
                    img7.setImageResource(R.mipmap.g_g);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[6])
                        img7.setImageResource(R.mipmap.g);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img7.setImageResource(R.mipmap.g);
                }
            }
        }
    };

    private View.OnClickListener i8cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[7]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[7]=true;
                tv.setText(Place[7]);
                tv2.setText(Story[7]);
                if(count[7])
                    img8.setImageResource(R.mipmap.h_h);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[7])
                        img8.setImageResource(R.mipmap.h);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img8.setImageResource(R.mipmap.h);
                }
            }
        }
    };

    private View.OnClickListener i9cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[8]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[8]=true;
                tv.setText(Place[8]);
                tv2.setText(Story[8]);
                if(count[8])
                    img9.setImageResource(R.mipmap.i_i);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[8])
                        img9.setImageResource(R.mipmap.i);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img9.setImageResource(R.mipmap.i);
                }
            }
        }
    };

    private View.OnClickListener i10cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[9]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[9]=true;
                tv.setText(Place[9]);
                tv2.setText(Story[9]);
                if(count[9])
                    img10.setImageResource(R.mipmap.j_j);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[9])
                        img10.setImageResource(R.mipmap.j);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img10.setImageResource(R.mipmap.j);
                }
            }
        }
    };

    private View.OnClickListener i11cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[10]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[10]=true;
                tv.setText(Place[10]);
                tv2.setText(Story[10]);
                if(count[10])
                    img11.setImageResource(R.mipmap.k_k);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[10])
                        img11.setImageResource(R.mipmap.k);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img11.setImageResource(R.mipmap.k);
                }
            }
        }
    };

    private View.OnClickListener i12cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[11]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[11]=true;
                tv.setText(Place[11]);
                tv2.setText(Story[11]);
                if(count[11])
                    img12.setImageResource(R.mipmap.l_l);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[11])
                        img12.setImageResource(R.mipmap.l);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img12.setImageResource(R.mipmap.l);
                }
            }
        }
    };

    private View.OnClickListener i13cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[12]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[12]=true;
                tv.setText(Place[12]);
                tv2.setText(Story[12]);
                if(count[12])
                    img13.setImageResource(R.mipmap.m_m);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[12])
                        img13.setImageResource(R.mipmap.m);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img13.setImageResource(R.mipmap.m);
                }
            }
        }
    };

    private View.OnClickListener i14cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[13]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[13]=true;
                tv.setText(Place[13]);
                tv2.setText(Story[13]);
                if(count[13])
                    img14.setImageResource(R.mipmap.n_n);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[13])
                        img14.setImageResource(R.mipmap.n);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img14.setImageResource(R.mipmap.n);
                }
            }
        }
    };

    private View.OnClickListener i15cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[14]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[14]=true;
                tv.setText(Place[14]);
                tv2.setText(Story[14]);
                if(count[14])
                    img15.setImageResource(R.mipmap.o_o);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[14])
                        img15.setImageResource(R.mipmap.o);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img15.setImageResource(R.mipmap.o);
                }
            }
        }
    };

    private View.OnClickListener i16cl =new View.OnClickListener(){
        public void onClick(View v) {
            if(flag[15]==false){
                for(int i=0;i<16;i++)
                    flag[i]=false;
                flag[15]=true;
                tv.setText(Place[15]);
                tv2.setText(Story[15]);
                if(count[15])
                    img16.setImageResource(R.mipmap.p_p);
            }
            else
            {
                for(int i=0;i<16;i++)
                    flag[i]=false;
                if(flag[16]==false)
                {
                    tv.setText("");
                    tv2.setText("");
                    if(count[15])
                        img16.setImageResource(R.mipmap.p);
                }
                else
                {
                    tv.setText(Place[16]);
                    tv2.setText(Story[16]);
                    img16.setImageResource(R.mipmap.p);
                }
            }
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
                                    final AlertDialog.Builder alertadd = new AlertDialog.Builder(gameActivity.this);
                                    LayoutInflater factory = LayoutInflater.from(gameActivity.this);
                                    final View view = factory.inflate(R.layout.dialog1, null);
                                    alertadd.setView(view);
                                    alertadd.setNeutralButton("我知道了", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            tv.setText(Place[6]);
                                            tv2.setText(Story[6]);
                                        }
                                    });
                                    alertadd.setNegativeButton("進入遊戲", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            Intent intent = new Intent();
                                            intent.setClass(gameActivity.this, qrcode_aActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                                    alertadd.show();
                                } else if (device.getName().equals(s2) && b_num!=2) {
                                    b_num = 2;
                                    final AlertDialog.Builder alertadd = new AlertDialog.Builder(gameActivity.this);
                                    LayoutInflater factory = LayoutInflater.from(gameActivity.this);
                                    final View view = factory.inflate(R.layout.dialog2, null);
                                    alertadd.setView(view);
                                    alertadd.setNeutralButton("我知道了", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            tv.setText(Place[2]);
                                            tv2.setText(Story[2]);

                                        }
                                    });
                                    alertadd.setNegativeButton("進入遊戲", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dlg, int sumthin) {
                                            Intent intent = new Intent();
                                            intent.setClass(gameActivity.this, qrcode_bActivity.class);
                                            startActivity(intent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_game,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent();
        intent.setClass(gameActivity.this, gameIFMActivity.class);
        startActivity(intent);
        return true;
        //return super.onOptionsItemSelected(item);
    }
}




