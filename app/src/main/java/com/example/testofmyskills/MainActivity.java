package com.example.testofmyskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button changeActivityButton; // = button "Add new coworker", sends us to another page

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
