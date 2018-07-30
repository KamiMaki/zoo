package com.example.jack.zoo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class tabbedActivity extends AppCompatActivity {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    Intent intent=new Intent();
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        intent=this.getIntent();
        //Bundle bundle = intent.getExtras();
        //position=bundle.getInt("position");

        mSectionsPagerAdapter=new SectionsPagerAdapter(
                getSupportFragmentManager());
        mSectionsPagerAdapter.getItem(position);
        mViewPager=(ViewPager)findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int i) {
            Fragment fragmemt=null;
            switch (i) {
                case 0:
                    fragmemt = new tab1camera();
                    break;
                case 1:
                    fragmemt = new tab2map();
                    break;
                case 2:
                    fragmemt = new tab3qrcode();
                    break;
                case 3:
                    fragmemt = new tab4food();
                    break;
                case 4:
                    fragmemt = new tab5game();
                    break;
                case 5:
                    fragmemt = new tab2animal();
                    break;
            }
            return fragmemt;
        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int i){
            switch (i) {
                case 0:
                    return "相機";
                case 1:
                    return "定位";
                case 2:
                    return "QRcode導覽";
                case 3:
                    return "訂餐";
                case 4:
                    return "遊戲";
                case 5:
                    return "認養動物";
                default:
                    return null;
            }
        }
    }
}
