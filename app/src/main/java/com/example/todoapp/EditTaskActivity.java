package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTaskActivity extends AppCompatActivity {

    Data data;
    private EditText editText;
    private Button save, delete;
    private int taskToEditId;
    private String taskToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        data = new Data(this);
        editText = findViewById(R.id.editTextEditTask);
        save = findViewById(R.id.buttonSave);
        delete = findViewById(R.id.buttonDelete);

        Intent intent = getIntent();
        taskToEditId = intent.getIntExtra("id", -1);
        taskToEdit = intent.getStringExtra("task");
        editText.setText(taskToEdit);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editText.getText().toString();
                if(task.equals("")){
                    toastMessage("wpisz conajmniej 3 znaki");
                } else {
                    data.updateData(task, taskToEdit, taskToEditId);
                }
            }
        });
    }

    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}