package com.example.jack.zoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class animalActivity extends AppCompatActivity {

    Intent intent;
    ImageButton animals,myanimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        intent=this.getIntent();

        animals= (ImageButton) findViewById(R.id.animala);
        myanimals= (ImageButton) findViewById(R.id.animalb);

        animals.setImageResource(R.drawable.animal_a);
        myanimals.setImageResource(R.drawable.animal_b);

        animals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(animalActivity.this, animalListActivity.class);
                startActivity(intent);
            }
        });

        myanimals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(animalActivity.this, myAnimalListActivity.class);
                startActivity(intent);
            }
        });
    }
}
