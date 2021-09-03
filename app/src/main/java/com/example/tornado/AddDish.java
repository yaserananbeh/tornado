package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        Button backToHomeBtn = findViewById(R.id.backToHomeBtn);
        Button submitNewDishBtn = findViewById(R.id.submitNewDishBtn);
        EditText dishName = findViewById(R.id.editTextDishName);
        EditText dishPrice = findViewById(R.id.editTextDishPrice);
        EditText dishIngredients = findViewById(R.id.editTextDishIngredients);

        backToHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnHomePage = new Intent(AddDish.this, MainActivity.class);
                startActivity(returnHomePage);
            }
        });

        submitNewDishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dish newDish = new Dish(dishName.getText().toString(), dishPrice.getText().toString(),
                        dishIngredients.getText().toString());
                AppDatabase appDatabase;
                appDatabase = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "dish").allowMainThreadQueries().build();
                appDatabase.dishDao().insertAll(newDish);
                Toast.makeText(getApplicationContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                Intent returnHomePage = new Intent(AddDish.this, MainActivity.class);
                startActivity(returnHomePage);
            }
        });

    }
}