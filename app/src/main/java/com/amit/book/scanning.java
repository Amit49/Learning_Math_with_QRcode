package com.amit.book;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scanning extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    public ZXingScannerView zXingScannerView;
    public MediaPlayer mPlayer;
    public ImageView imageView;
    public String s;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanning);
        zXingScannerView = new ZXingScannerView(this);
        zXingScannerView.setResultHandler(this);
        setContentView(zXingScannerView);
        zXingScannerView.startCamera();
    }

    public void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_SHORT).show();
        s = result.getText();
        System.out.println(s);
        boolean quizornot = s.indexOf("quiz") != -1 ? true : false;
        if (quizornot == true) {
            mPlayer = MediaPlayer.create(this, getResources().getIdentifier(s, "raw", getPackageName()));
            mPlayer.start();

            Intent intent = new Intent(scanning.this, Main4Activity.class);
            intent.putExtra("msg", s);
            startActivity(intent);
            //zXingScannerView.resumeCameraPreview(this);

        } else {
            mPlayer = MediaPlayer.create(this, getResources().getIdentifier(s, "raw", getPackageName()));
            mPlayer.start();


            Intent intent = new Intent(scanning.this, Main3Activity.class);
            intent.putExtra("msg", s);
            startActivity(intent);

            zXingScannerView.stopCamera();
            onBackPressed();
           // zXingScannerView.resumeCameraPreview(this);
        }


    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_main2);
        //Intent intent = new Intent(scanning.this,Main2Activity.class);
        //startActivity(intent);
    }
}
