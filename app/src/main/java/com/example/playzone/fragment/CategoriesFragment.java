package com.example.playzone.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.playzone.R;
import com.example.playzone.utils.DummyData;

import java.util.List;

public class CategoriesFragment extends Fragment {

    private ListView lvCategories;
    private List<String> categoryList;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvCategories = view.findViewById(R.id.listViewCategories);


        categoryList = DummyData.getCategories();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                categoryList
        ) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View itemView = super.getView(position, convertView, parent);
                TextView textView = itemView.findViewById(android.R.id.text1);
                if (textView != null) {
                    textView.setTextColor(Color.WHITE);
                    textView.setTextSize(18);
                    textView.setPadding(16, 24, 16, 24);
                }
                return itemView;
            }
        };

        lvCategories.setAdapter(adapter);

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categoryList.get(position);
                Toast.makeText(getContext(), "Selected Category: " + selectedCategory, Toast.LENGTH_SHORT).show();
            }
        });
    }
}