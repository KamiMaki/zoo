package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class foodListActivity extends AppCompatActivity {

    Intent intent;
    ImageView food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        intent=this.getIntent();

        food= (ImageView) findViewById(R.id.image1);

        food.setImageResource(R.drawable.foodlist);
    }
}
