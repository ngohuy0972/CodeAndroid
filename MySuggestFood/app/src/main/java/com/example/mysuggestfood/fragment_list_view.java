package com.example.mysuggestfood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class fragment_list_view<arrayAdapter> extends ListFragment {

    String[] arrayFood = {"Food_1","Food_2","Food_3","Food_4","Food_5","Food_6","Food_7","Food_8",};
    ArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_view,container,false);
        adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,arrayFood);
        setListAdapter((ListAdapter) adapter);
        return view;
    }
}
