package com.example.jack.zoo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class menu extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

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

    public static class PlaceholderFragment extends Fragment
    {
        int total_price = 0;
        List<list_menu> cart;
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
                    foodList.add(new list_menu(R.drawable.cream,"蜂蜜芥末+洋蔥圈+蜂蜜檸檬水",229));
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
                                     total_price+=x.get_Price();

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
                    foodList.add(new list_menu(R.drawable.pizza,"番茄披薩",95));
                    break;
                case 3:

                    foodList.clear();
                    break;
                case 4:

                    foodList.clear();
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

