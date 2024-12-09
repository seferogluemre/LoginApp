package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        user=findViewById(R.id.editUsername);
        pass=findViewById(R.id.editPassword);


    }
    public void routeSettings(View view){
        Intent settingsForm=new Intent(getApplicationContext(),SettingsActivity.class);
        startActivity(settingsForm);
    }


    public void login(View view){
        String username,password;
        username=user.getText().toString();
        password=pass.getText().toString();

        if(username.equals("emre") && password.equals("123456")){
            Toast.makeText(this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
            Intent homePage=new Intent(getApplicationContext(),homepage.class);
            startActivity(homePage);
        }
        else{
            Toast.makeText(this, "Hatalı giriş tekrar dene", Toast.LENGTH_SHORT).show();
        }
    }
}