package com.example.jack.zoo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class menu extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    static Button btn;
    static int total_price = 0;
    static final List<list_menu> cart = new ArrayList<list_menu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        btn = findViewById(R.id.button15);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        btn.setText("前往結帳(總金額:0元)");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("cart", (Serializable) cart);
                bundle.putInt("price",total_price);
                intent.putExtras(bundle);
                intent.setClass(menu.this,cart.class);
                startActivityForResult(intent,1);
            }
        });

    }
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        if(requestCode==1&&resultCode==RESULT_OK){
            total_price = data.getExtras().getInt("price");
            btn.setText("前往結帳(總金額:"+total_price+"元)");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static void setbtn(int price)
    {
        total_price+=price;
        btn.setText("前往結帳(總金額:"+total_price+"元)");
    }

    public static class PlaceholderFragment extends Fragment
    {

        private static final String ARG_SECTION_NUMBER = "section_number";
        public PlaceholderFragment() { }
        public static PlaceholderFragment newInstance(int sectionNumber)
        {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
            int position = getArguments().getInt(ARG_SECTION_NUMBER);
            final ListView lv = rootView.findViewById(R.id.ll);
            final List<list_menu> foodList;

            foodList = new ArrayList<list_menu>();
            lv.setAdapter(new ListViewAdapter(getActivity(),foodList));

            switch (position)
            {

                case 1:
                    foodList.clear();
                    foodList.add(new list_menu(R.drawable.set_a,"蜂蜜芥末+洋蔥圈",210));
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("加入購物車")//設定視窗標題
                                    .setMessage("是否要加入此餐點")
                            .setNeutralButton("確定",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int which)
                                {
                                     list_menu x =  (list_menu)parent.getItemAtPosition(position);
                                     menu.cart.add(x);
                                    int p = x.get_Price();
                                    menu.setbtn(p);

                                }
                                }
                                    ).setNegativeButton("取消",new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog,int which) {
                                    dialog.cancel();
                                }

                            }).show();//呈現對話視窗
                        }
                    });
                    break;
                case 2:

                    foodList.clear();
                    foodList.add(new list_menu(R.drawable.pizza,"乳酪披薩醬",105));
                    foodList.add(new list_menu(R.drawable.cream,"招牌酸奶油",95));
                    foodList.add(new list_menu(R.drawable.honey,"蜂蜜芥末醬",90));
                    foodList.add(new list_menu(R.drawable.cheese,"特調起司醬",125));
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("加入購物車")//設定視窗標題
                                    .setMessage("是否要加入此餐點")
                                    .setNeutralButton("確定",new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog,int which)
                                                {
                                                    list_menu x =  (list_menu)parent.getItemAtPosition(position);
                                                    cart.add(x);
                                                   int p=x.get_Price();
                                                    menu.setbtn(p);

                                                }
                                            }
                                    ).setNegativeButton("取消",new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog,int which) {
                                    dialog.cancel();
                                }

                            }).show();//呈現對話視窗
                        }
                    });

                    break;
                case 3:

                    foodList.clear();

                    foodList.add(new list_menu(R.drawable.onion,"洋蔥圈",85));
                    foodList.add(new list_menu(R.drawable.chicken,"雞柳條",85));
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("加入購物車")//設定視窗標題
                                    .setMessage("是否要加入此餐點")
                                    .setNeutralButton("確定",new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog,int which)
                                                {
                                                    list_menu x =  (list_menu)parent.getItemAtPosition(position);
                                                    cart.add(x);
                                                   int p=x.get_Price();
                                                    menu.setbtn(p);

                                                }
                                            }
                                    ).setNegativeButton("取消",new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog,int which) {
                                    dialog.cancel();
                                }

                            }).show();//呈現對話視窗
                        }
                    });
                    break;
                case 4:
                    foodList.clear();
                    foodList.add(new list_menu(R.drawable.cola,"汽水",25));
                    foodList.add(new list_menu(R.drawable.juice,"100%柳橙汁",60));
                    foodList.add(new list_menu(R.drawable.soda,"特調氣泡飲",75));
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("加入購物車")//設定視窗標題
                                    .setMessage("是否要加入此餐點")
                                    .setNeutralButton("確定",new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog,int which)
                                                {
                                                    list_menu x =  (list_menu)parent.getItemAtPosition(position);
                                                    cart.add(x);
                                                    int p = x.get_Price();
                                                    menu.setbtn(p);

                                                }
                                            }
                                    ).setNegativeButton("取消",new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog,int which) {
                                    dialog.cancel();
                                }

                            }).show();//呈現對話視窗
                        }
                    });

                    break;
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }
}

class ListViewAdapter extends BaseAdapter {

    private List<list_menu> food;
    private LayoutInflater layoutInflater;
    private Context context;
    public ListViewAdapter(Context context,List<list_menu> food){
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

