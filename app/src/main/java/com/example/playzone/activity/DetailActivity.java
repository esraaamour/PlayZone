package com.example.playzone.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.playzone.R;
import com.example.playzone.model.Game;
import com.example.playzone.utils.CartManager;

import java.util.Locale;

// Game details screen displayed when clicking on a card
public class DetailActivity extends AppCompatActivity {

    private Game selectedGame;
    private ImageView imgGame;
    private TextView txtTitle, txtCategory, txtPrice, txtDescription;
    private Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();

        if (getIntent() != null && getIntent().hasExtra("selected_game")) {
            //  Store the game in the global selectedGame variable instead of a local variable
            selectedGame = (Game) getIntent().getSerializableExtra("selected_game");

            if (selectedGame != null) {
                displayGameDetails(selectedGame);
            }
        }

        if (btnAddToCart != null) {
            btnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedGame != null) {
                        //  Add the selected game to the cart
                        CartManager.getInstance().addGame(selectedGame);

                        Toast.makeText(DetailActivity.this, "The game has been added to the cart!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error: Game data is null!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void initViews() {
        imgGame = findViewById(R.id.imgGameCoverDetail);
        txtTitle = findViewById(R.id.txtGameTitleDetail);
        txtCategory = findViewById(R.id.txtGameCategoryDetail);
        txtPrice = findViewById(R.id.txtGamePriceDetail);
        txtDescription = findViewById(R.id.txtGameDescriptionDetail);
        btnAddToCart = findViewById(R.id.btnAddToCartDetail);
    }

    private void displayGameDetails(Game game) {
        if (txtTitle != null) {
            txtTitle.setText(game.getTitle());
        }

        if (txtCategory != null) {
            txtCategory.setText(game.getCategory());
        }

        if (txtPrice != null) {
            txtPrice.setText(String.format(Locale.US, "$%.2f", game.getPrice()));        }

        if (txtDescription != null) {
            txtDescription.setText(game.getDescription());
        }

        if (imgGame != null) {
            imgGame.setImageResource(game.getImageResId());
        }
    }
}