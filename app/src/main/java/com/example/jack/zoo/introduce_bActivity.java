package com.example.jack.zoo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class introduce_bActivity extends AppCompatActivity {

    Intent intent = new Intent();
    Bundle bundle=new Bundle();
    String[] Time = new String[16];//地點名稱
    String[] Story = new String[16];//地點介紹
    int number;
    TextView tv1,tv2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_b);

        intent = this.getIntent();
        bundle = intent.getExtras();

        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView17);
        img = (ImageView) findViewById(R.id.imageView5);

        Time[0]="開放參觀時間：\n每週二上午9:00-12:00，若遇例假日則停止開放。\n";
        Time[1]="開放參觀時間：\n每日9:00 - 16:30\n每月第四個週一休館";
        Time[2]="開放參觀時間：\n每日9:00 - 16:30\n每月第一個週一休館";
        Time[3]="開放參觀時間：\n每日9:00 - 17:00 (16:30停止入館)\n每週一休館\n\n入館門票：\n全票20元、優待票10元\n";
        Time[4]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[5]="開放參觀時間：\n每日9:00 - 16:30\n每月第三個週一休館\n";
        Time[6]="開放參觀時間：\n每日9:00 - 16:30\n每月第二個週一休館\n";
        Time[7]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[8]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[9]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[10]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[11]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[12]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[13]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[14]="開放參觀時間：\n每日9:00 - 16:30\n";
        Time[15]="開放參觀時間：\n每日9:00 - 16:30\n每週一休館";

        Story[0]="展館介紹：\n位於動物園園外保育公園\n臺北市立動物園現址原名為「頭廷魁」，主要為高氏族人的聚落。民國68年為新建動物園工程，徵收該地，市政府為照顧居民生計，在園外設立販賣區提供高氏族人經營，並於販賣區2樓設置高氏宗祠。後因販賣區改建，遂將高氏宗祠遷移至現址並成立高氏宗祠文史館，並於民國104年1月6日正式開放民眾參觀。高氏宗祠文史館除提供高氏後代子孫祭祀之用，更成為民眾了解在地歷史文化的展示空間。\n" ;
        Story[1]="展館介紹：\n昆蟲館分為五大區域：序幕大廳、多媒體視聽教室、臺灣昆蟲區、生態展示室、昆蟲特展區。除了介紹昆蟲的起源與演化、構造與適應，更有溫室及生態網室，讓遊客身處昆蟲圍繞的環境中。館區後方還有一個擁有豐富昆蟲資源的「蟲蟲探索谷」，為本園進行戶外生態解說教育的場所之一。\n" ;
        Story[2]="展館介紹：\n大貓熊館包括一個戶外展示場和兩個室內展示場，提供多樣的活動空間及攀爬、遮蔭設施，還有大小石塊及流瀑水。戶外展示場則模擬大貓熊野外棲息地，草坪寬闊，並以濃綠喬木構成背景。\n";
        Story[3]="展館介紹：\n教育中心包括博物館展示區、圖書館、演講廳、動物藝坊及動物學堂等，為本園展示動物園文化的櫥窗。館內以動物標本、生態全景展示傳達動物知識及保育觀念，最特別的是還有亞洲象「林旺」的標本展示區，以及恐龍模型展示喔！\n" ;
        Story[4]="展館介紹：\n無尾熊為最具代表性的有袋目動物之一。來自澳洲「庫倫賓野生動物保護區」，代表城市友誼並肩負保育、教育使命的無尾熊們，自引進以來一直都是眾所矚目的焦點。無尾熊館設有多個獨立空間，每間屋頂都有天窗可以讓陽光照射進來。在適當天氣時，無尾熊偶爾也會到戶外展示場活動，享受溫暖的陽光。";
        Story[5]="展館介紹：\n本館以不同的生態系展示各種兩棲爬蟲活體動物，包括溼地、熱帶雨林、溫帶森林、沙漠等四大類型。除了經常性的動物生態展示區之外，館內還有靜態的解說教育展示區及定期更換主題的特展區，希望藉由各類動物、寫實模型、互動教材與文化藝品的多元展示，引導遊客進入兩棲爬蟲動物的奧秘世界。\n";
        Story[6]="展館介紹：\n企鵝館展示「國王企鵝」及「黑腳企鵝」，牠們是不會飛的水生鳥類，牠們全是游泳的專家，在水裡潛泳可以「飛」得又快又好。在觀賞可愛的企鵝之餘，也可以在企鵝館了解牠們的分布、形態特徵、生活習性及繁殖求偶行為喔！\n";
        Story[7]="展館介紹：\n臺灣動物區以臺灣原生動物與棲息環境為展示重點，佈置模擬動物原生棲地之生態環境，讓動物表現如野外般自然的生活習性，引導觀賞者更正確地認識本土野生動物。臺灣位處於亞熱帶，雨量充沛、氣候溫暖，擁有各種地形景觀，因而孕育了豐富龐雜的生物資源。\n";
        Story[8]="展館介紹：\n兒童動物園全區以埤塘、水田等各類濕地與郊野生態造景為環境意象，串聯農村動物、經濟動物、寵物、入侵之外來種動物等單元主題，點出人類與動物間的密切關係，提供學童、家長與老師一處共同體驗與學習的空間。\n";
        Story[9]="展館介紹：\n亞洲熱帶雨林區模擬東南亞熱帶雨林的自然生態景觀，依展示動線規劃成河口生態、密林生態及林緣生態三大展示區，區內可見板根、氣生根、支柱根、附生植物、林間霧氣等熱帶雨林特有的生態現象。\n";
        Story[10]="展館介紹：\n沙漠動物區以隨風搖曳的棕櫚樹模擬中東地區的沙漠環境，展示具代表性的單峰駱駝、雙峰駱駝、非洲野驢和弓角羚羊等。來到這裡，你就能知道動物用什麼方式適應乾旱、高溫及晝夜溫差大的氣候呢？\n";
        Story[11]="展館介紹：\n澳洲動物區栽種許多澳洲特有的桉樹，在這裡可以遇到袋鼠、鴯鶓和食火雞喔！澳洲大陸長時間與其他陸塊隔離，繁衍並演化出與其他陸域不同形態的物種，值得大小朋友一起來認識牠們喔！\n";
        Story[12]="展館介紹：\n非洲動物區多採動物混群的展示方式，模擬東非莽原情境，讓參觀者在視覺上宛如置身非洲草原。非洲大陸被譽為「野生動物王國」，擁有世界最龐大的動物族群，不僅動物種類豐富，數量亦最為壯觀，快來這裡拜訪陸地上體型最大和身高最高的動物吧！\n";
        Story[13]="展館介紹：\n溫帶動物區主要展示棲息於溫帶草原和森林中的動物。地球上廣大的溫帶氣候區有沙漠、草原、落葉林及針帶林等不同生態環境，因此動物種類繁多。然而溫帶氣候也很適合人類居住，因此這裡的動物大多面臨棲息地減少或其他與人有關的生存危機，需要我們一起來關心牠們的保育。\n";
        Story[14]="展館介紹：\n鳥園區包括鳥類形態區、雉類與珍禽區、鶴園、鸚鵡房、生態鳥園及水禽區，可以觀察到住在不同棲息地的鳥類，是都會環境中難得的賞鳥據點。歡迎放慢腳步，聽聽悅耳鳥鳴、看看羽色繽紛的輕盈身影，感受另一個廣闊而自由的世界。\n";
        Story[15]="展館介紹：\n經濟部能源局及工業技術研究院，結合臺北市立動物園的環境教育及生態保育理念，建造這一棟位於沙漠動物區入口處的酷Cool節能屋。這是一座結合空間設計、節能材料及再生能源利用的節能建築，導入童話故事的解說活動，適合全家人一起來體驗。\n";

        Thread t1 = new Thread(r1);
        t1.start();
    }

    private Runnable r1=new Runnable () {
        public void run() {

            try {
                number=bundle.getInt("input");
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
            if (msg.what == 1&&bundle!=null) {
                tv1.setText(Time[number]);
                tv2.setText(Story[number]);
                if(number==0)
                    img.setImageResource(R.mipmap.a__a);
                else if(number==1)
                    img.setImageResource(R.mipmap.b__b);
                else if(number==2)
                    img.setImageResource(R.mipmap.c__c);
                else if(number==3)
                    img.setImageResource(R.mipmap.d__d);
                else if(number==4)
                    img.setImageResource(R.mipmap.e__e);
                else if(number==5)
                    img.setImageResource(R.mipmap.f__f);
                else if(number==6)
                    img.setImageResource(R.mipmap.g__g);
                else if(number==7)
                    img.setImageResource(R.mipmap.h__h);
                else if(number==8)
                    img.setImageResource(R.mipmap.i__i);
                else if(number==9)
                    img.setImageResource(R.mipmap.j__j);
                else if(number==10)
                    img.setImageResource(R.mipmap.k__k);
                else if(number==11)
                    img.setImageResource(R.mipmap.l__l);
                else if(number==12)
                    img.setImageResource(R.mipmap.m__m);
                else if(number==13)
                    img.setImageResource(R.mipmap.n__n);
                else if(number==14)
                    img.setImageResource(R.mipmap.o__o);
                else if(number==15)
                    img.setImageResource(R.mipmap.p__p);
                setResult(RESULT_OK,intent);
            }
        }
    };
}
