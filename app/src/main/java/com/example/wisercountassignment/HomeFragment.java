package com.example.wisercountassignment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wisercountassignment.adapters.TasksRecyclerViewAdapter;
import com.example.wisercountassignment.databinding.FragmentHomeBinding;
import com.google.android.material.chip.Chip;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding fragmentHomeBinding;
    private TasksRecyclerViewAdapter tasksRecyclerViewAdapter;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentHomeBinding =FragmentHomeBinding.inflate(inflater);
        View view = fragmentHomeBinding.getRoot();

        String[] tags = {"Today", "Upcoming", "Reminders", "Overdue", "Completed"};
        String[] tagColors = {"#0F81EC", "#B86F00", "#B3261E", "#375692", "#1A614A"};
        String[][] tasks = {{"Grocery Shopping", "Bring groceries, toothpaste, tea, milk, sugar, vegetables.dlkasdna dlkasdlk asd lksalkdsm laksmdlkasd Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco"},
                            {"Laundry","Give clothes for laundry including suit and trousers."},
                {"Exercise","Go for walk for 30 minutes, and play Badminton on the court. Take all the accessories."}};

        for (int i=0; i< tags.length; i++)
        {
            com.google.android.material.chip.Chip newChip = new Chip(inflater.getContext());
            newChip.setText(tags[i]);
            newChip.setChipBackgroundColor(ColorStateList.valueOf(Color.parseColor(tagColors[i])));
            newChip.setTextColor(ColorStateList.valueOf(Color.WHITE));
            fragmentHomeBinding.ChipGroup.addView(newChip);
        }

        fragmentHomeBinding.tasksRecyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        tasksRecyclerViewAdapter = new TasksRecyclerViewAdapter(tasks);
        fragmentHomeBinding.tasksRecyclerView.setAdapter(tasksRecyclerViewAdapter);

        return view;
    }
}