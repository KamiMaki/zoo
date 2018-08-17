package com.example.jack.zoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class informationActivity extends AppCompatActivity {

    Intent intent= new Intent();
    Bundle bundle= new Bundle();
    ImageButton introduce,show,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        intent=this.getIntent();
        introduce=(ImageButton)findViewById(R.id.imageButton34);
        show=(ImageButton)findViewById(R.id.imageButton33);
        map=(ImageButton)findViewById(R.id.imageButton35);

        introduce.setImageResource(R.drawable.building);
        show.setImageResource(R.drawable.show2);
        map.setImageResource(R.drawable.map);


        introduce.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setClass(informationActivity.this, introduce_aActivity.class);
                startActivity(intent);
            }
        });

        show.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setClass(informationActivity.this, show_aActivity.class);
                startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                intent.setClass(informationActivity.this, webview.class);
                startActivity(intent);
            }
        });

    }


}
