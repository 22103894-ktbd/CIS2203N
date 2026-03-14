package com.cis2203n.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView display;
    double operandA = 0;
    double operandB = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        if(savedInstanceState != null){
            display.setText(savedInstanceState.getString("displayValue"));
        }
    }
    public void numberClick(View view){
        Button button = (Button) view;
        String number = button.getText().toString();
        if(display.getText().toString().equals("0")){
            display.setText(number);
        }else{
            display.append(number);
        }
    }
    public void operatorClick(View view){
        Button button = (Button) view;
        operandA = Double.parseDouble(display.getText().toString());
        operator = button.getText().toString();
        display.setText("0");
    }

    public void equalsClick(View view){
        operandB = Double.parseDouble(display.getText().toString());
        double result = 0;
        switch (operator){
            case "+":
                result = operandA + operandB;
                break;
            case "-":
                result = operandA - operandB;
                break;
            case "*":
                result = operandA * operandB;
                break;
            case "/":
                if(operandB == 0){
                    display.setText(getString(R.string.divide_zero));
                    return;
                }
                result = operandA / operandB;
                break;
        }
        display.setText(String.valueOf(result));
    }
    public void clearClick(View view){
        display.setText("0");
        operandA = 0;
        operandB = 0;
        operator = "";
    }

    @SuppressLint("DefaultLocale")
    public void customOperator(View view){
        double value = Double.parseDouble(display.getText().toString());
        double result = value * 8.94;
        display.setText(String.format("%.2f", result));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("displayValue", display.getText().toString());
    }
}