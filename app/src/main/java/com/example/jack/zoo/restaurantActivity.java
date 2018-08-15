package com.example.jack.zoo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class restaurantActivity extends AppCompatActivity {
    ListView lv;
    List<list_restaurant> restaurantList;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        lv = (ListView) findViewById(R.id.lv);
        restaurantList = new ArrayList<list_restaurant>();
        adapter = new MyAdapter(this,restaurantList);
        lv.setAdapter(adapter);
        restaurantList.add(new list_restaurant(R.drawable.s711,"店名：梅花鹿店（7-11）","位置：大門入口（服務中心旁）"));
        restaurantList.add(new list_restaurant(R.drawable.mc,"店名：臺灣黑熊店（麥當勞）","位置：大門出口旁"));
        restaurantList.add(new list_restaurant(R.drawable.bb,"店名：臺灣黑熊店（黑熊小食堂）","位置：大門出口旁（麥當勞旁）"));
        restaurantList.add(new list_restaurant(R.drawable.panda,"店名：貓熊餐廳","位置：大貓熊館二樓（特展館）"));
        restaurantList.add(new list_restaurant(R.drawable.tager,"店名：老虎店（雨林店）","位置：熱帶雨林區出口"));
        restaurantList.add(new list_restaurant(R.drawable.camel,"店名：駱駝店（倆月倆日）","位置：沙漠動物區入口"));
        restaurantList.add(new list_restaurant(R.drawable.camel2,"店名：駱駝店（愛爾蘭瘋薯）","位置：沙漠動物區入口"));
        restaurantList.add(new list_restaurant(R.drawable.camel3,"店名：駱駝店（食食再再）","位置：沙漠動物區入口"));
        restaurantList.add(new list_restaurant(R.drawable.hippo,"店名：河馬店（MOS）","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo2,"店名：河馬店（烏丼亭）","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo3,"店名：河馬店（黑面蔡）","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo4,"店名：河馬店（頂呱呱）","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo5,"店名：河馬店（假日餐車）","位置：河馬廣場旁露臺"));
        restaurantList.add(new list_restaurant(R.drawable.frog,"店名：爬蟲溫帶區（青蛙屋）","位置：爬蟲館出口旁"));
        restaurantList.add(new list_restaurant(R.drawable.frog1,"店名：爬蟲溫帶區（青蛙咖啡）","位置：爬蟲館出口旁"));
        restaurantList.add(new list_restaurant(R.drawable.spanda,"店名：爬蟲溫帶區（小貓熊店）","位置：溫帶動物區（小貓熊展區旁）"));
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(restaurantActivity.this,MainScreen.class);
                startActivity(intent);
                return true;
            }
        });
    }




}
