package com.example.playzone.adapter;
// Adapter class responsible for displaying games in a RecyclerView and handling game item clicks.

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playzone.R;
import com.example.playzone.model.Game;

import java.util.List;
// Adapter responsible for displaying the list of games inside the RecyclerView
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    // List of games to be displayed
    private List<Game> gameList;
    // Listener used to handle game card click events
    private OnGameClickListener listener;

    // Interface for handling item click events
    public interface OnGameClickListener {
        void onGameClick(Game game);
    }

    // Constructor - initialize the game list and click listener
    public GameAdapter(List<Game> gameList, OnGameClickListener listener) {
        this.gameList = gameList;
        this.listener = listener;
    }
    // Creates a new ViewHolder and inflates the game card layout
    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game_card, parent, false);
        return new GameViewHolder(view);
    }
    // Binds game data to the views of each card
    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game game = gameList.get(position);
        holder.bind(game, listener);
    }
    // Returns the number of games in the list
    @Override
    public int getItemCount() {
        return gameList != null ? gameList.size() : 0;
    }

    // ViewHolder that holds the views of each game card
    public static class GameViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgGame;
        private TextView txtTitle;
        private TextView txtCategory;
        private TextView txtPrice;

        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
// Initializes the views inside the game card layout
            imgGame = itemView.findViewById(R.id.imgGameCover);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtCategory = itemView.findViewById(R.id.txtCategoriesTitle);
            txtPrice = itemView.findViewById(R.id.txtGamePrice);
        }
        // Displays the game information and handles card click events
        public void bind(final Game game, final OnGameClickListener listener) {
            txtTitle.setText(game.getTitle());
            txtCategory.setText(game.getCategory());
            txtPrice.setText("$" + game.getPrice());
            imgGame.setImageResource(game.getImageResId());
            // Sets a click listener for the game card
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onGameClick(game);
                    }
                }
            });
        }
    }
}