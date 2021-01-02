package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Data data;
    private Button add, view;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.addButton);
        view = findViewById(R.id.viewButton);
        editText = findViewById(R.id.editTextNewTask);
        data = new Data(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editText.getText().toString();
                if (editText.length() > 2) {
                    insertData(newTask);
                    editText.setText("");
                } else {
                    toastMessage("Wpisz conajmniej 3 litery");
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, taskActivity.class);
                startActivity(intent);
            }
        });
    }

    public void insertData(String newTask) {
        boolean insert = data.insertData(newTask);

        if (insert) {
            toastMessage("Udało się dodać zadanie");
        } else {
            toastMessage("Nie udało się dodać zadania");
        }
    }

    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}