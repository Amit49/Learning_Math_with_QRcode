package com.amit.book;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


/**
 * Created by User on 13-Jul-19.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String u;

    private static final String DATABASE_NAME ="userdetails.db";
    private static final String TABLE_NAME ="user_details";
    private static final String ID ="ID";
    private static final String NAME ="Name";
    private static final String PASSWORD ="Password";
    private static final int VERSION_NUMBER =9;

    private Context context;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255) NOT NULL,"+PASSWORD+" TEXT NOT NULL)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {

            Toast.makeText(context,"Oncreate is called",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);
            //sqLiteDatabase.execSQL("INSERT INTO "+TABLE_NAME+"( "+ID+","+NAME+","+PASSWORD+") VALUES (1,Amit,123)");

        }catch (Exception e){

            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();

        }

    }
    public boolean insertData (int id ,String name ,String password )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(PASSWORD,password);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        try {
            Toast.makeText(context,"Onupgrade is called",Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);


        }catch (Exception e){

            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();

        }

    }
    public Boolean findpassword(String username,String password){
        SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        Boolean result =false;
        if (cursor.getCount()==0){
            Toast.makeText(context, "No Data is found", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                String U_name = cursor.getString(1);
                u=U_name;
                String P_word = cursor.getString(2);
                if(U_name.equals(username) && P_word.equals(password)){
                    result =  true;
                    break;
                }
            }
        }
        return result;
    }
}
