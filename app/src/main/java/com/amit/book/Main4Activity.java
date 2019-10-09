package com.amit.book;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3;
    ImageView imageView;
    int num;
    String A,Amit="Amit",Apu="Apu";
    DatabaseHelper databaseHelper;
    public  static int Amit_num=0,Apu_num=0;
    public MediaPlayer mPlayer;
    public String all_quiz[][]={
            {"quiz_chagol","৩","৫","৮"},
            {"quiz_ghora","১","৫","৬"},
            {"quiz_juta","৪","৫","৬"},
            {"quiz_putul","৩","৫","৬"},
            {"quiz_khelna","২","৫","৬"},
            {"quiz_dim","৭","৯","৮"},
            {"quiz_fol","৮","১১","১২"},
            {"quiz_ful","২","৩","৪"},
            {"quiz_jama","৫","৬","৪"},
            {"quiz_khat","০","১","৩"},
            {"quiz_kolsi","৪","৬","৭"},
            {"quiz_nowka","৪","৭","৩"},
            {"quiz_pakhi","৫","৩","৬"},
            {"quiz_pakhi_beyog","২","১","৩"},
            {"quiz_shiyal","৪","৭","৫"},
            {"quiz_tala","৫","৩","৬"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageViewId);
        Intent intent = getIntent();
        String file = intent.getStringExtra("msg");
        int resID = getResources().getIdentifier(file, "drawable", getPackageName());
        setquiz(file);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                if(b1.getText().equals(all_quiz[num][1]) ){
                    Toast.makeText(Main4Activity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    A = "r3";
                    if(databaseHelper.u.equals(Amit)){
                        Amit_num++;
                    }
                    else if (databaseHelper.u.equals(Apu)) {
                        Apu_num++;
                    }
                    mPlayer = MediaPlayer.create(this, getResources().getIdentifier(A, "raw", getPackageName()));
                    mPlayer.start();
                    Intent intent = new Intent(Main4Activity.this,Main2Activity.class);
                    startActivity(intent);
                    //setContentView(R.layout.activity_main2);
                }
                else{
                    Toast.makeText(Main4Activity.this, "You Are Wrong", Toast.LENGTH_SHORT).show();
                    A = "w2";
                    mPlayer = MediaPlayer.create(this, getResources().getIdentifier(A, "raw", getPackageName()));
                    mPlayer.start();
                    setContentView(R.layout.activity_main2);
                }
                break;

            case R.id.button2:
                if(b2.getText().equals(all_quiz[num][1])){
                    Toast.makeText(Main4Activity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    A = "r3";
                    mPlayer = MediaPlayer.create(this, getResources().getIdentifier(A, "raw", getPackageName()));
                    mPlayer.start();
                    setContentView(R.layout.activity_main2);

                }
                else {
                    Toast.makeText(Main4Activity.this, "You Are Wrong", Toast.LENGTH_SHORT).show();
                    A = "w2";
                    mPlayer = MediaPlayer.create(this, getResources().getIdentifier(A, "raw", getPackageName()));
                    mPlayer.start();
                    setContentView(R.layout.activity_main2);
                }

                break;

            case R.id.button3:
                if(b3.getText().equals(all_quiz[num][1])){
                    Toast.makeText(Main4Activity.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    A = "r3";
                    mPlayer = MediaPlayer.create(this, getResources().getIdentifier(A, "raw", getPackageName()));
                    mPlayer.start();
                    setContentView(R.layout.activity_main2);

                }
                else{
                    Toast.makeText(Main4Activity.this, "You Are Wrong", Toast.LENGTH_SHORT).show();
                    A = "w2";
                    mPlayer = MediaPlayer.create(this, getResources().getIdentifier(A, "raw", getPackageName()));
                    mPlayer.start();
                    setContentView(R.layout.activity_main2);
                }
                break;


        }
    }
    public void setquiz(String s){
        for (int i=0;i<all_quiz.length;i++){
            if(all_quiz[i][0].equals(s)){
                b1.setText(all_quiz[i][1]);
                b2.setText(all_quiz[i][2]);
                b3.setText(all_quiz[i][3]);
                int resID = getResources().getIdentifier(all_quiz[i][0], "drawable", getPackageName());
                num = i;
                imageView.setImageResource(resID);
                break;
            }

        }

    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Main4Activity.this,Main2Activity.class);
        startActivity(intent);
    }
}
