package com.example.jack.zoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class animalListActivity extends AppCompatActivity {

    Intent intent;
    //List<item> items;//把item用list列出
    ListView layoutTest;
    //SuperAdapter adapter;//把item弄進來

    //public int[] iconnum = new int[]{R.drawable.a, R.drawable.b, R.drawable.c};
    public String[] aname = new String[50];
    public String[] aplace = new String[50];
    public String tn="";
    public String manuid="";
    int i,j,k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        intent=this.getIntent();
        layoutTest = (ListView) findViewById(R.id.anilist);
/*
        mTable = new Table("http://140.113.73.102:8001/api", "hamburger","admin","steven8702");
        items = new ArrayList<item>();//用arraylist方式把item列出來
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Thread t1 = new Thread(r1);
                t1.start();
            }
        }, 0, 1000);


        //layoutTest = (ListView) findViewById(R.id.list);
        adapter = new SuperAdapter(this, items);
        layoutTest.setAdapter(adapter);
*/
    }
/*

    private Runnable r1 = new Runnable() {
        public void run() {
            try {
                Tuple a[] = mTable.get();

                j=0;
                for (i=0; i<a.length; i++){
                    if(a[i].get("h_type")!=null) {
                        if(a[i].get("h_id")!=null) {
                            if (a[i].get("h_type").equals("order")) {
                                if (a[i].get("h_tablenumber") != null) {
                                    if (a[i].get("h_tablenumber").equals("5")) {//目前先寫死 5
                                        mnumber[j] = a[i].get("id");
                                        manuid = a[i].get("h_id");
                                        mtable[j] = a[i].get("h_tablenumber");
                                        mtype[j] = a[i].get("h_type");
                                        for (k = 0; k < a.length; k++) {
                                            if (a[k].get("id").equals(manuid)) {
                                                mprice[j] = a[k].get("h_id");
                                                mname[j] = a[k].get("h_name");
                                                //Log.e("ggg2", "" + mname[j]);//檢查用
                                            }
                                        }
                                        j = j + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Message message = new Message();
            message.what = 1;
            h1.sendMessage(message);
        }
    };

    Handler h1 = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                item Item;
                items.clear();
                for(int p=0;p<j;p++){
                    Item=new item(iconnum[p%3], aname[p], aplace[p], mprice[p],mtable[p],mtype[p]);
                    items.add(Item);
                }
                adapter.notifyDataSetChanged();
            }
            super.handleMessage(msg);

        }
    };
   */
}
