package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class foodActivity extends AppCompatActivity {

    ImageButton restaurant,shopping;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        restaurant= (ImageButton) findViewById(R.id.restaurant);
        shopping=(ImageButton) findViewById(R.id.mylist);

        restaurant.setImageResource(R.drawable.restaurant);
        shopping.setImageResource(R.drawable.shopping);

        restaurant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(foodActivity.this, restaurantActivity.class);
                startActivity(intent);
            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(foodActivity.this, myFoodListActivity.class);
                startActivity(intent);
            }
        });
    }
}
