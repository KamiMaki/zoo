package com.example.jack.zoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class animalActivity extends AppCompatActivity {

    Intent intent;
    ImageView animals,myanimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        intent=this.getIntent();

        animals= (ImageView) findViewById(R.id.animal1);
        myanimals= (ImageView) findViewById(R.id.animal2);

        animals.setImageResource(R.drawable.animalsimage);
        myanimals.setImageResource(R.drawable.myanimalsimage);
    }
}
