package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class taskActivity extends AppCompatActivity {

    Data data;
    private ListView listView;
    private Button addTaskActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        data = new Data(this);
        addTaskActivity = findViewById(R.id.buttonAddTaskActivity);
        listView = (ListView) findViewById(R.id.listViewTasks);


        addTaskActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(taskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}