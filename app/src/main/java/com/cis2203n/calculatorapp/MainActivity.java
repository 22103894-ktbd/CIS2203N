package com.cis2203n.calculatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// The main activity is the main screen of the calculator app.
// It extends app combat activity which provides compatibility support for older Android version.
public class MainActivity extends AppCompatActivity{

    TextView display;
    double operandA = 0;
    double operandB = 0;
    String operator = "";

    // onCreate() is called when the activity is first created
    // it is responsible for initializing the UI and setting up components
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        // For savedInstanceState this line is if the activity was recreated
        // (for example after screen rotation) restore the previous display value
        if(savedInstanceState != null){
            display.setText(savedInstanceState.getString("displayValue"));
        }
    }
    // it handles the number when the user pressed the button 0 - 9
    public void numberClick(View view){
        Button button = (Button) view;
        String number = button.getText().toString();
        if(display.getText().toString().equals("0")){
            display.setText(number);
        }else{
            display.append(number);
        }
    }
    // it handles when an operator (+, -, *, /) is pressed
    public void operatorClick(View view){
        Button button = (Button) view;
        operandA = Double.parseDouble(display.getText().toString());
        operator = button.getText().toString();
        display.setText("0");
    }
    // it handles when the equals = button is pressed
    public void equalsClick(View view){
        // get the second operand from the display
        operandB = Double.parseDouble(display.getText().toString());
        double result = 0;
        // perform the calculation based on the selected operator
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
                // it prevents division by zero which causes errors
                if(operandB == 0){
                    display.setText(getString(R.string.divide_zero));
                    return;
                }
                result = operandA / operandB;
                break;
        }
        display.setText(String.valueOf(result));
    }
    // it handles the clear button, and it resets the calculator to its default state
    public void clearClick(View view){
        display.setText("0");
        operandA = 0;
        operandB = 0;
        operator = "";
    }
    // So the custom operator example it converts the value using a fixed multiplier
    // so for example: could represent currency conversion or a custom calculation
    @SuppressLint("DefaultLocale")
    public void customOperator(View view){
        double value = Double.parseDouble(display.getText().toString());
        double result = value * 8.94;
        display.setText(String.format("%.2f", result));
    }

    // so this method saves the current display value when the activity is
    // destroyed temporarily (like when you rotate the screen)
    // this prevents the calculator result from being lost
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("displayValue", display.getText().toString());
    }
}