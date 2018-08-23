package com.example.jack.zoo;
//AR專區
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ARActivity extends AppCompatActivity {

    ImageButton camera,roadSign,video;
    Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);

        intent = this.getIntent();

        camera=(ImageButton)findViewById(R.id.button1);
        roadSign=(ImageButton)findViewById(R.id.button2);
        video=(ImageButton)findViewById(R.id.button6);

        camera.setImageResource(R.drawable.camera);
        roadSign.setImageResource(R.drawable.roadsign);
        video.setImageResource(R.drawable.video);

        //AR相機
        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ARActivity.this, cameraActivity.class);
                startActivity(intent);
            }
        });

        //AR路標
        roadSign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("ame.Company.comm");
                startActivity(intent);
            }
        });

        //AR多媒體
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("test123.Company.com");
                startActivity(intent);
            }
        });
    }
}
