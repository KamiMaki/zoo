package com.example.jack.zoo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.jack.zoo.menu.total_price;

public class cart extends AppCompatActivity {
    ListView lv;
    Intent intent = new Intent();
    ListViewAdapter1 adapter;
    TextView tv;
    Button order,back;
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        lv = findViewById(R.id.lv);
        tv = findViewById(R.id.textView21);
        order = findViewById(R.id.button);
        back = findViewById(R.id.button15);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        total = bundle.getInt("price");
        final ArrayList cart = (ArrayList)bundle.getSerializable("cart");
        adapter = new ListViewAdapter1(this,cart);
        lv.setAdapter(adapter);
        tv.setText("總金額:"+total);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(cart.this)
                        .setTitle("取消餐點")//設定視窗標題
                        .setMessage("是否要取消此餐點")
                        .setNeutralButton("確定",new DialogInterface.OnClickListener() {
                                    @SuppressLint("SetTextI18n")
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        list_menu x =  (list_menu)parent.getItemAtPosition(position);
                                         int price = x.get_Price();
                                        total -= price;
                                        tv.setText("總金額:"+total);
                                        assert cart != null;
                                        cart.remove(position);
                                        adapter.notifyDataSetChanged();

                                    }
                                }
                        ).setNegativeButton("取消",new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog,int which) {
                        dialog.cancel();
                    }

                }).show();//呈現對話視窗
                return false;
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub

        if (keyCode == KeyEvent.KEYCODE_BACK) { // 攔截返回鍵
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("price",total);
            intent.putExtras(bundle);
            setResult(RESULT_OK,intent);
            cart.this.finish();

        }
        return true;
    }
}

class ListViewAdapter1 extends BaseAdapter {

    private List<list_menu> food;
    private LayoutInflater layoutInflater;
    private Context context;
    public ListViewAdapter1(Context context,List<list_menu> food){
        this.context=context;
        this.food=food;
        this.layoutInflater=LayoutInflater.from(context);
    }
    /**
     * 组件集合，对应list.xml中的控件
     * @author Administrator
     */
    public final class foods{
        public ImageView food_img;
        public TextView food_name;
        public TextView food_price;
    }
    @Override
    public int getCount() {
        return food.size();
    }
    /**
     * 获得某一位置的数据
     */
    @Override
    public Object getItem(int position) {
        return food.get(position);
    }
    /**
     * 获得唯一标识
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        foods _food=null;
        if(convertView==null){
            _food=new foods();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.activity_list_menu, null);
            _food.food_img=(ImageView)convertView.findViewById(R.id.food_img);
            _food.food_name=(TextView)convertView.findViewById(R.id.food_name);
            _food.food_price=(TextView)convertView.findViewById(R.id.food_price);
            convertView.setTag(_food);
        }else{
            _food=(foods) convertView.getTag();
        }
        //绑定数据
        _food.food_img.setImageResource((Integer)food.get(position).get_Img());
        _food.food_name.setText((String)food.get(position).get_Name());
        _food.food_price.setText(""+food.get(position).get_Price());
        return convertView;
    }

}
