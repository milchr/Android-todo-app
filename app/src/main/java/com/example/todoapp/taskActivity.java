package com.example.todoapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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

        fillListView();

        addTaskActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(taskActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void fillListView() {
        Cursor tasks = data.getData();
        ArrayList<String> taskList = new ArrayList<>();
        while (tasks.moveToNext()) {
            taskList.add(tasks.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listView.setAdapter(adapter);
    }


}