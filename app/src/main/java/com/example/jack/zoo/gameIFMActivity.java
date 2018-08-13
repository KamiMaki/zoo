package com.example.jack.zoo;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class gameIFMActivity extends AppCompatActivity {

    private ArrayList<View> dots;
    private ViewPager mViewPager;
    private ViewPagerAdapter adapter;
    private View view1, view2, view3;
    private int oldPosition = 0;// 记录上一次点的位置
    private int currentItem; // 当前页面
    private List<View> viewList = new ArrayList<View>();// 把需要滑动的页卡添加到这个list中
    Button bt5;
    Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_ifm);

        intent = this.getIntent();
        bt5=(Button)findViewById(R.id.button5);
        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(gameIFMActivity.this,gameIFMActivity.class);
                startActivity(intent);
            }});
        // 添加当前Acitivity到ancivitylist里面去，为了方便统一退出
        // 显示的点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        // 得到viewPager的布局
        LayoutInflater lf = LayoutInflater.from(gameIFMActivity.this);
        view1 = lf.inflate(R.layout.viewpager_item1, null);
        view2 = lf.inflate(R.layout.viewpager_item2, null);
        view3 = lf.inflate(R.layout.viewpager_item3, null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        // 找到点击进入那个按钮
        mViewPager = (ViewPager) findViewById(R.id.vp);

        adapter = new ViewPagerAdapter();
        mViewPager.setAdapter(adapter);
        dots.get(0).setBackgroundResource(R.drawable.dot_focused);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                dots.get(oldPosition).setBackgroundResource(
                        R.drawable.dot_normal);
                dots.get(position)
                        .setBackgroundResource(R.drawable.dot_focused);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    private class ViewPagerAdapter extends PagerAdapter {

        public ViewPagerAdapter() {
            super();
            // 得到viewpager切换的三个布局，并把它们加入到viewList里面,记得view用打气筒生成，否则容易出现空指针异常

        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        // 是否是同一张图片
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            ((ViewPager) view).removeView(viewList.get(position));

        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            ((ViewPager) view).addView(viewList.get(position));
            return viewList.get(position);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
