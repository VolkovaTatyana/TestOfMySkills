package com.example.testofmyskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private EditText name;
    private EditText age;
    private EditText phone;
    private Button btnSave;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.et_name);
        age = findViewById(R.id.et_age);
        phone = findViewById(R.id.et_phone);
        btnSave = findViewById(R.id.b_save);

        dbHelper = new DBHelper(this);
        radioGroup = findViewById(R.id.r_group);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname = name.getText().toString();
                int iage = Integer.valueOf(age.getText().toString());
                String sphone = phone.getText().toString();

                SQLiteDatabase database = dbHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

                contentValues.put(DBHelper.KEY_NAME,sname);
                contentValues.put(DBHelper.KEY_AGE,iage);
                contentValues.put(DBHelper.KEY_PHONE,sphone);
                contentValues.put(DBHelper.KEY_GENDER,checkButton(view));

                database.insert(DBHelper.TABLE, null, contentValues);
            }
        };

        btnSave.setOnClickListener(onClickListener);

    }

    public String checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        return radioButton.getText().toString();
    }
}
