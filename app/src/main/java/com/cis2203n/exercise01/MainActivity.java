package com.cis2203n.exercise01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.student_id));
        }

        Button myButton = findViewById(R.id.btnChangeName);
        TextView myText = findViewById(R.id.tvDepartment);

        myButton.setOnClickListener(v ->
                myText.setText(getString(R.string.chairwoman_name))
        );
    }
}