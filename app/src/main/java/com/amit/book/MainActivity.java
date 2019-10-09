package com.amit.book;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Usernamefield;
    private EditText Passwordfield;
    private Button Buttonfield;


    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usernamefield =(EditText) findViewById(R.id.UserNameId);
        Passwordfield =(EditText) findViewById(R.id.PasswordId);
        Buttonfield = (Button) findViewById(R.id.LoginButtonId);
        Buttonfield.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase =databaseHelper.getWritableDatabase();
        //databaseHelper.insertData(1,"Amit","123");
        //databaseHelper.insertData(2,"Apu","123");


    }

    @Override
    public void onClick(View view) {

        String username = Usernamefield.getText().toString();
        String password = Passwordfield.getText().toString();

        if (view.getId()==R.id.LoginButtonId){

            Boolean result = databaseHelper.findpassword(username,password);

            if (result==true){
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Wrong Username and Password",Toast.LENGTH_LONG).show();
            }
        }

    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
