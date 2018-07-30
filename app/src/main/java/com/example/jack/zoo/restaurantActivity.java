package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class restaurantActivity extends AppCompatActivity {

    Intent intent;
    ImageButton restaurantList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        intent=this.getIntent();

        restaurantList= (ImageButton) findViewById(R.id.restaurantlist);

        restaurantList.setImageResource(R.drawable.restaurantlist);

        restaurantList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(restaurantActivity.this, foodListActivity.class);
                startActivity(intent);
            }
        });
    }
}
