package com.rkz98.registrodeatividades;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.rkz98.registrodeatividades.Adapters.TasksAdapter;
import com.rkz98.registrodeatividades.Models.Task;
import com.rkz98.registrodeatividades.Models.Enum.Days;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private List<Task> tasks = new ArrayList<>();
    private final TasksAdapter tasksAdapter  = new TasksAdapter(this, tasks);
    private Task task = new Task();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        final EditText textInput = findViewById(R.id.textInputId);
        Button dateButton = findViewById(R.id.dateButtonId);
        Button timeButton = findViewById(R.id.timeButtonId);
        final Button confirmButton = findViewById(R.id.confirmButtonId);

        textInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                task.setTaskEnd(textInput.getText().toString());
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setDayOfWeek();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "Time Picker");
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmTask();
            }
        });

        listView.setAdapter(tasksAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task selectedTask = tasks.get(position);
                Toast.makeText(MainActivity.this, "Dia selecionado: " + selectedTask.getTaskEnd(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(MainActivity.this, hourOfDay + " horas e " + minute + " minutos", Toast.LENGTH_LONG).show();
        task.setQuantityHours(hourOfDay);
    }

    private void setDayOfWeek() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escolha um dia da semana");

         final String[] daysOfWeek = {
                Days.MONDAY.getValue(),
                Days.TUESDAY.getValue(),
                Days.WEDNESDAY.getValue(),
                Days.THURSDAY.getValue(),
                Days.FRIDAY.getValue(),
                Days.SATURDAY.getValue(),
                Days.SUNDAY.getValue(),
        };

        int checkedItem = 0;

        builder.setSingleChoiceItems(daysOfWeek, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, daysOfWeek[which], Toast.LENGTH_LONG).show();
                task.setDayOfWeek(daysOfWeek[which]);
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("Cancelar", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void confirmTask() {
        if ((task.getDayOfWeek() != null) && (task.getQuantityHours() != 0) && (task.getTaskEnd() != null)) {
            tasks.add(new Task(task.getTaskEnd(), task.getDayOfWeek(), task.getQuantityHours()));
            tasksAdapter.notifyDataSetChanged();
            task.setDayOfWeek(null);
            task.setTaskEnd(null);
            task.setQuantityHours(0);
        } else {
            Toast.makeText(MainActivity.this, "Por favor, valide os campos!", Toast.LENGTH_LONG).show();
        }
    }
}
