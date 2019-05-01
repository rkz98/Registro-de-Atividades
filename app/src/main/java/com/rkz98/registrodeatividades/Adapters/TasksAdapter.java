package com.rkz98.registrodeatividades.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rkz98.registrodeatividades.Models.Task;
import com.rkz98.registrodeatividades.R;

import org.w3c.dom.Text;

import java.util.List;

public class TasksAdapter extends BaseAdapter {

    private List<Task> tasks;
    private Activity activity;

    public TasksAdapter(Activity activity, List<Task> tasks) {
        this.tasks = tasks;
        this.activity = activity;
    }

    public int getCount() {
        return this.tasks.size();
    }

    public Object getItem(int position) {
        return this.tasks.get(position);
    }

    public long getItemId (int position) {
        return 0;
    }

    public View getView(int position, View v, ViewGroup viewGroup) {

        View view = this.activity.getLayoutInflater().inflate(R.layout.list_view, viewGroup, false);
        Task task = tasks.get(position);
        TextView day = view.findViewById(R.id.dayOfWeekId);
        TextView hours = view.findViewById(R.id.quantityHoursId);
        TextView taskDone = view.findViewById(R.id.taskNameId);

        day.setText(task.getDayOfWeek());
        hours.setText(Integer.toString(task.getQuantityHours()));
        taskDone.setText(task.getTaskEnd());

        return view;
    }
}
