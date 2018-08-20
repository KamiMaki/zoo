package com.example.jack.zoo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class restaurantActivity extends AppCompatActivity {
    ListView lv;
    List<list_restaurant> restaurantList;
    MyAdapter adapter;
    String[][] res_content = new String[16][6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        lv = (ListView) findViewById(R.id.lv);
        res_content[0][0] = "7-11";
        res_content[0][1] = "是";
        res_content[0][2] = "02-8661-8147";
        res_content[0][3] = "簡易餐點（便當、御飯糰、泡麵、關東煮）\n" +
                "各式飲料冰品\n" +
                "衛生用品\n" +
                "糖果零食";
        res_content[0][4] = "無";
        res_content[0][5] = "n";

        res_content[1][0] = "麥當勞";
        res_content[1][1] = "是";
        res_content[1][2] = "02-8661-7111";
        res_content[1][3] = "美式速食餐點\n" +
                "各式飲料冰品";
        res_content[1][4] = "1";
        res_content[1][5] = "n";

        res_content[2][0] = "黑熊小食堂";
        res_content[2][1] = "是";
        res_content[2][2] = "0913-027875";
        res_content[2][3] = "簡餐（紅燒牛腩、黑胡椒牛肉、咖哩雞肉、蜜汁燒肉）\n" +
                "爆米花、茶葉蛋\n" +
                "飲料及各式冰品（粒粒冰、雞蛋冰、膠囊冰淇淋）\n" +
                "包子、粽子";
        res_content[2][4] = "3";
        res_content[2][5] = "y";

        res_content[3][0] = "貓熊餐廳";
        res_content[3][1] = "是";
        res_content[3][2] = "02-2936-1725分機24";
        res_content[3][3] = "公平交易咖啡飲品\n" +
                "精美蛋糕下午茶\n" +
                "新鮮水果輕食\n" +
                "新鮮果汁、現打冰沙茶類\n" +
                "麵食、飯類、披薩主餐熟食";
        res_content[3][4] = "5";
        res_content[3][5] = "l";

        res_content[4][0] = "雨林店";
        res_content[4][1] = "是";
        res_content[4][2] = "0926-706830";
        res_content[4][3] = "牛/雞肉捲\n" +
                "簡易型餐點\n" +
                "各式飲料冰品";
        res_content[4][4] = "無";
        res_content[4][5] = "n";

        res_content[5][0] = "倆月倆日";
        res_content[5][1] = "是";
        res_content[5][2] = "0915-338-577";
        res_content[5][3] = "果醬類可麗餅\n" +
                "風味類可麗餅\n" +
                "飲品類";
        res_content[5][4] = "無";
        res_content[5][5] = "n";

        res_content[6][0] = "愛爾蘭瘋薯";
        res_content[6][1] = "否";
        res_content[6][2] = "0915-338-577";
        res_content[6][3] = "炸物類食品系列\n" +
                "熱狗堡輕食類\n" +
                "都柏林美食系列";
        res_content[6][4] = "無";
        res_content[6][5] = "y";

        res_content[7][0] = "食食再再";
        res_content[7][1] = "是";
        res_content[7][2] = "02-2653-0338";
        res_content[7][3] = "泡芙系列\n" +
                "飲料系列";
        res_content[7][4] = "無";
        res_content[7][5] = "n";

        res_content[8][0] = "MOS摩斯漢堡";
        res_content[8][1] = "是";
        res_content[8][2] = "02-2939-1838";
        res_content[8][3] = "日式速食餐點\n" +
                "米漢堡系列\n" +
                "各式飲料";
        res_content[8][4] = "無";
        res_content[8][5] = "n";

        res_content[9][0] = "烏丼亭";
        res_content[9][1] = "是";
        res_content[9][2] = "02-8661-9251";
        res_content[9][3] = "日弍烏龍麵系列\n" +
                "日式丼飯系列";
        res_content[9][4] = "無";
        res_content[9][5] = "n";

        res_content[10][0] = "黑面蔡";
        res_content[10][1] = "是";
        res_content[10][2] = "0919-120353";
        res_content[10][3] = "特調飲品\n" +
                "滷味食品";
        res_content[10][4] = "無";
        res_content[10][5] = "n";

        res_content[11][0] = "頂呱呱";
        res_content[11][1] = "是";
        res_content[11][2] = "02-8661-3707";
        res_content[11][3] = "炸物食品\n" +
                "飲品類\n" +
                "現場提供兒童餐";
        res_content[11][4] = "無";
        res_content[11][5] = "n";

        res_content[12][0] = "假日餐車1";
        res_content[12][1] = "是";
        res_content[12][2] = "02-2936-1725";
        res_content[12][3] = "雙淇淋\n" +
                "雞蛋糕";
        res_content[12][4] = "無";
        res_content[12][5] = "n";

        res_content[13][0] = "青蛙屋";
        res_content[13][1] = "是";
        res_content[13][2] = "0987-296-169";
        res_content[13][3] = "義大利麵、鐵板炒麵\n" +
                "德式香腸堡、米漢堡\n" +
                "雞肉焗飯、紐奧良翅小腿\n" +
                "玉米濃湯、清涼飲品";
        res_content[13][4] = "無";
        res_content[13][5] = "n";

        res_content[14][0] = "青蛙咖啡";
        res_content[14][1] = "是";
        res_content[14][2] = "0987-296-169";
        res_content[14][3] = "現烤魷魚\n" +
                "青蛙雞蛋糕、奶油棒\n" +
                "黃金爆米花、鮮蝦餅\n" +
                "清涼飲品";
        res_content[14][4] = "無";
        res_content[14][5] = "n";

        res_content[15][0] = "萊爾富";
        res_content[15][1] = "是";
        res_content[15][2] = "02-2936-8675";
        res_content[15][3] = "簡易餐點（便當、鮮食、泡麵、關東煮）\n" +
                "各式飲料冰品\n" +
                "衛生用品\n" +
                "糖果零食";
        res_content[15][4] = "無";
        res_content[15][5] = "n";

        lv.setTextFilterEnabled(true);
        restaurantList = new ArrayList<list_restaurant>();
        adapter = new MyAdapter(this,restaurantList);
        lv.setAdapter(adapter);
        restaurantList.add(new list_restaurant(R.drawable.s711,"店名：7-11","位置：大門入口\n\n(服務中心旁)"));
        restaurantList.add(new list_restaurant(R.drawable.mc,"店名：麥當勞","位置：大門出口旁"));
        restaurantList.add(new list_restaurant(R.drawable.bb,"店名：黑熊小食堂","位置：大門出口旁\n\n(麥當勞旁)"));
        restaurantList.add(new list_restaurant(R.drawable.panda,"店名：貓熊餐廳","位置：大貓熊館二樓\n\n(特展館)"));
        restaurantList.add(new list_restaurant(R.drawable.tager,"店名：雨林店","位置：熱帶雨林區出口"));
        restaurantList.add(new list_restaurant(R.drawable.camel,"店名：倆月倆日","位置：沙漠動物區入口"));
        restaurantList.add(new list_restaurant(R.drawable.camel2,"店名：愛爾蘭瘋薯","位置：沙漠動物區入口"));
        restaurantList.add(new list_restaurant(R.drawable.camel3,"店名：食食再再","位置：沙漠動物區入口"));
        restaurantList.add(new list_restaurant(R.drawable.hippo,"店名：MOS摩斯漢堡","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo2,"店名：烏丼亭","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo3,"店名：黑面蔡","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo4,"店名：頂呱呱","位置：河馬廣場"));
        restaurantList.add(new list_restaurant(R.drawable.hippo5,"店名：假日餐車","位置：河馬廣場旁露臺"));
        restaurantList.add(new list_restaurant(R.drawable.frog,"店名：青蛙屋","位置：爬蟲館出口旁"));
        restaurantList.add(new list_restaurant(R.drawable.frog1,"店名：青蛙咖啡","位置：爬蟲館出口旁"));
        restaurantList.add(new list_restaurant(R.drawable.spanda,"店名：萊爾富","位置：溫帶動物區\n\n(小貓熊展區旁)"));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("res_name",res_content[position][0]);
                bundle.putString("res_group",res_content[position][1]);
                bundle.putString("res_tel",res_content[position][2]);
                bundle.putString("res_food",res_content[position][3]);
                bundle.putString("res_num",res_content[position][4]);
                bundle.putString("res_order",res_content[position][5]);
                intent.putExtras(bundle);
                intent.setClass(restaurantActivity.this,restaurant_intro.class);
                startActivity(intent);
            }
        });
    }
}

class MyAdapter extends BaseAdapter implements Filterable {
    LayoutInflater myInflater;
    Context context;
    List<list_restaurant> list_restaurants;
    MyAdapter(Context context, List<list_restaurant> list_restaurants){
        myInflater = LayoutInflater.from(context);
        this.context = context;
        this.list_restaurants = list_restaurants;
    }

    @Override
    public int getCount() {
        return list_restaurants.size();
    }

    @Override
    public Object getItem(int position) {
        return list_restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list_restaurants.indexOf(getItem(position));
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {


            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return null;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

            }
        };
        return filter;

    }

    public class ViewHolder {
        ImageView img;
        TextView tv_name;
        TextView tv_location;
        public ViewHolder(ImageView img,TextView tv_name, TextView tv_location){
            this.img = img;
            this.tv_name = tv_name;
            this.tv_location = tv_location;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyAdapter.ViewHolder holder;
        myInflater = LayoutInflater.from(context);
        convertView = myInflater.inflate(R.layout.activity_list_restaurant, null);
        holder = new MyAdapter.ViewHolder((ImageView) convertView.findViewById(R.id.imageView9),
                (TextView) convertView.findViewById(R.id.textView),
                (TextView) convertView.findViewById(R.id.textView2)
        );
        list_restaurant pos = list_restaurants.get(position);
        holder.img.setImageResource(pos.get_Img());
        holder.tv_name.setText(pos.get_Name());
        holder.tv_location.setText(pos.get_Location());
        convertView.setTag(holder);
        return convertView;
    }
}
