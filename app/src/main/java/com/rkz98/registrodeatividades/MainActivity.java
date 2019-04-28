package com.rkz98.registrodeatividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.rkz98.registrodeatividades.Adapters.TasksAdapter;
import com.rkz98.registrodeatividades.Models.DayOfWeek;
import com.rkz98.registrodeatividades.Models.Enum.Days;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<DayOfWeek> daysOfWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.daysOfWeek = new ArrayList<>();

        this.initDaysOfWeek();

        final TasksAdapter tasksAdapter  = new TasksAdapter(this, daysOfWeek);

        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(tasksAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DayOfWeek selectedDayOfWeek = daysOfWeek.get(position);
                Toast.makeText(MainActivity.this, "Dia selecionado: " + selectedDayOfWeek.getDay().getValue(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initDaysOfWeek() {
        this.daysOfWeek.add(new DayOfWeek(Days.MONDAY, 8));
        this.daysOfWeek.add(new DayOfWeek(Days.TUESDAY, 8));
        this.daysOfWeek.add(new DayOfWeek(Days.WEDNESDAY, 8));
        this.daysOfWeek.add(new DayOfWeek(Days.THURSDAY, 10));
        this.daysOfWeek.add(new DayOfWeek(Days.FRIDAY, 6));
        this.daysOfWeek.add(new DayOfWeek(Days.SATURDAY, 5));
        this.daysOfWeek.add(new DayOfWeek(Days.SUNDAY, 2));
    }
}
