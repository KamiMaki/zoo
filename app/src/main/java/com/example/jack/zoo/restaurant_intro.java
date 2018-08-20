package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class restaurant_intro extends AppCompatActivity {
    TextView res_name;
    TextView res_group;
    TextView res_tel;
    TextView res_food;
    TextView res_num;
    Button res_order;
    Button res_line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_intro);
        Bundle bundle =restaurant_intro.this.getIntent().getExtras();
        final String name = bundle.getString("res_name");
        String group = bundle.getString("res_group");
        String tel = bundle.getString("res_tel");
        String food = bundle.getString("res_food");
        String num = bundle.getString("res_num");
        String order = bundle.getString("res_order");
        res_name = findViewById(R.id.res_name);
        res_group = findViewById(R.id.res_group);
        res_tel = findViewById(R.id.res_tel);
        res_food = findViewById(R.id.res_food);
        res_num = findViewById(R.id.res_num);
        res_order = findViewById(R.id.res_order);
        res_line = findViewById(R.id.res_line);
        res_name.setText(name);
        res_group.setText(group);
        res_tel.setText(tel);
        res_food.setText(food);
        res_num.setText(num);
        res_order.setVisibility(View.INVISIBLE);
        res_line.setVisibility(View.INVISIBLE);
        if(order.equals("y"))
        {
            res_order.setVisibility(View.VISIBLE);
        }
        else if(order.equals("l"))
        {
            res_line.setVisibility(View.VISIBLE);
        }
        res_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(restaurant_intro.this,menu.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        res_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();




            }
        });
    }
}
