package com.example.testofmyskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private Button changeActivityButton; // = button "Add new coworker", sends us to another page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE,null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int ageIndex = cursor.getColumnIndex(DBHelper.KEY_AGE);
            int phoneIndex = cursor.getColumnIndex(DBHelper.KEY_PHONE);
            int genderIndex = cursor.getColumnIndex(DBHelper.KEY_GENDER);
            do{
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", name = " + cursor.getString(nameIndex) +
                        ", age = " + cursor.getInt(ageIndex) +
                        ", phone number = " + cursor.getString(phoneIndex) +
                        ", gender = " + cursor.getString(genderIndex));
            }while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");

        changeActivityButton = findViewById(R.id.b_add);
        changeActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainActivity.this;

                Class destinationActivity = Main2Activity.class;

                Intent main2ActivityIntent = new Intent(context, destinationActivity);

                startActivity(main2ActivityIntent);
            }
        });
    }
}
