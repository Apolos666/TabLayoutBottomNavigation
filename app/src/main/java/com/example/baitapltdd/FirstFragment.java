package com.example.baitapltdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button buttonToDetail = view.findViewById(R.id.buttonToDetail);
        buttonToDetail.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            startActivity(intent);
        });

        return view;
    }
}