package com.example.jack.zoo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class gameActivity extends AppCompatActivity {

    ImageButton ib1,ib2;
    Intent intent=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        intent = this.getIntent();

        ib1 = (ImageButton) findViewById(R.id.imageButton39);
        ib2 = (ImageButton) findViewById(R.id.imageButton40);

        ib1.setImageResource(R.drawable.panel2);
        ib2.setImageResource(R.drawable.panel1);

        ib1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(gameActivity.this, game_aActivity.class);
                startActivity(intent);
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(gameActivity.this, game_bActivity.class);
                startActivity(intent);
            }
        });
    }
}
