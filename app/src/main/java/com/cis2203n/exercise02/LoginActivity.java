package com.cis2203n.exercise02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.cis2203n.exercise02.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity{

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSubmit.setOnClickListener(v -> validateLogin());
    }

    @SuppressLint("SetTextI18n")
    private void validateLogin(){

        String studentId = binding.etStudentId.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        if(studentId.isEmpty() || password.isEmpty()){
            binding.tvResult.setText("Please enter both Student ID and Password");
            return;
        }
        if(studentId.length() < 2){
            binding.tvResult.setText("Invalid Student ID");
            return;
        }

        String lastTwo = studentId.substring(studentId.length() - 2);
        String expectedPassword = "gearbobs" + lastTwo;

        if(password.equals(expectedPassword)){
            binding.tvResult.setText("Access Granted ✅");
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }else{
            binding.tvResult.setText("Access Denied ❌");
        }
    }
}