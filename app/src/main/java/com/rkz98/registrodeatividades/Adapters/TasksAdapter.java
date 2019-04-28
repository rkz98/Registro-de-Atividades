package com.rkz98.registrodeatividades.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rkz98.registrodeatividades.Models.DayOfWeek;
import com.rkz98.registrodeatividades.R;

import java.util.List;

public class TasksAdapter extends BaseAdapter {

    private List<DayOfWeek> daysOfWeek;
    private Activity activity;

    public TasksAdapter(Activity activity, List<DayOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
        this.activity = activity;
    }

    public int getCount() {
        return this.daysOfWeek.size();
    }

    public Object getItem(int position) {
        return this.daysOfWeek.get(position);
    }

    public long getItemId (int position) {
        return 0;
    }

    public View getView(int position, View v, ViewGroup viewGroup) {

        View view = this.activity.getLayoutInflater().inflate(R.layout.list_view, viewGroup, false);
        DayOfWeek dayOfWeek = daysOfWeek.get(position);
        TextView day = view.findViewById(R.id.dayOfWeekId);
        TextView hours = view.findViewById(R.id.quantityHoursId);

        day.setText(dayOfWeek.getDay().getValue());
        hours.setText(Integer.toString(dayOfWeek.getQuantityHours()));

        return view;
    }
}
