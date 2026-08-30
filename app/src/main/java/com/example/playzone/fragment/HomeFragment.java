package com.example.playzone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playzone.R;
import com.example.playzone.activity.DetailActivity;
import com.example.playzone.adapter.GameAdapter;
import com.example.playzone.model.Game;
import com.example.playzone.utils.DummyData;

import java.util.List;

public class HomeFragment extends Fragment implements GameAdapter.OnGameClickListener {

    private RecyclerView rvGames;
    private GameAdapter adapter;
    private List<Game> gameList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Initialize RecyclerView from fragment_home.xml
        rvGames = view.findViewById(R.id.rvGames);

        // 2. Fetch dummy games list from DummyData
        gameList = DummyData.getDummyGames();

        // 3. Setup GameAdapter with listener
        adapter = new GameAdapter(gameList, this);

        // 4. Set GridLayoutManager (2 columns) and set adapter
        rvGames.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvGames.setAdapter(adapter);
    }

    // 5. Handle item clicks to navigate to DetailActivity
    @Override
    public void onGameClick(Game game) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("selected_game", game);
        startActivity(intent);
    }
}