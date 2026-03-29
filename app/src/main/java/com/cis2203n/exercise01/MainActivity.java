package com.cis2203n.exercise01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;
    private TextView counterDisplay;

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

        counterDisplay = findViewById(R.id.tvCounter);
        counterDisplay.setText(String.valueOf(mCounter));

        Button increaseButton = findViewById(R.id.btnIncrease);

        increaseButton.setOnClickListener(v -> {
            mCounter++;
            counterDisplay.setText(String.valueOf(mCounter));
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", mCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mCounter = savedInstanceState.getInt("COUNT_KEY");
        counterDisplay.setText(String.valueOf(mCounter));
    }
}