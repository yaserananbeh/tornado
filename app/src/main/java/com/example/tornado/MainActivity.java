package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addDishBtn=findViewById(R.id.addDishBtn);
        Button ourMenuBtn=findViewById(R.id.menuBtn);

        addDishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showAddDishForm=new Intent(MainActivity.this,AddDish.class);
                startActivity(showAddDishForm);
            }
        });

        ourMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showMenuPage=new Intent(MainActivity.this,Menu.class);
                startActivity(showMenuPage);
            }
        });
    }
}