package com.amit.book;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main3Activity extends AppCompatActivity {

    //private ZXingScannerView zXingScannerView;
    //private MediaPlayer mPlayer;
    ImageView imageView ;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView = (ImageView) findViewById(R.id.imageDisplay);
        //System.out.println(main2Activity.s);
        Intent intent = getIntent();
        String file = intent.getStringExtra("msg");
        int resID = getResources().getIdentifier(file, "drawable", getPackageName());

        imageView.setImageResource(resID);


    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
        startActivity(intent);
    }
}
