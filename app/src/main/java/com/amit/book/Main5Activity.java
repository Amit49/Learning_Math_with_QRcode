package com.amit.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    TextView t1,t2;
    DatabaseHelper databaseHelper;
    Main4Activity main4Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t1.setText(databaseHelper.u);
        //System.out.println(databaseHelper.u);
        if(databaseHelper.u.equals("Amit")){
            t2.setText(Integer.toString(main4Activity.Amit_num));
        }
        else if(databaseHelper.u.equals("Apu")){
            t2.setText(Integer.toString(main4Activity.Apu_num));
        }

    }
}
