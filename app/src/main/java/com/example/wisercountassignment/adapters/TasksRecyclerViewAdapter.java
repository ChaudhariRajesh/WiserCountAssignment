package com.example.wisercountassignment.adapters;


import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisercountassignment.R;

public class TasksRecyclerViewAdapter extends RecyclerView.Adapter<TasksRecyclerViewAdapter.ViewHolder> {

    private String[][] localDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }
    }

    public TasksRecyclerViewAdapter(String[][] dataSet) {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.task_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        RadioButton radioButton = viewHolder.itemView.findViewById(R.id.radioButton);
        TextView taskTitle = viewHolder.itemView.findViewById(R.id.taskTitle);
        TextView taskDescription = viewHolder.itemView.findViewById(R.id.taskDescription);
        TextView textViewOptions = viewHolder.itemView.findViewById(R.id.textViewOptions);
        taskTitle.setText(localDataSet[position][0]);
        taskDescription.setText(localDataSet[position][1]);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton.isChecked())
                    radioButton.setChecked(false);
                else
                    radioButton.setChecked(true);
            }
        });

    }
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
