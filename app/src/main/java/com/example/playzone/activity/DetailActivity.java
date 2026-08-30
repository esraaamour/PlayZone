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

// Game details screen displayed when clicking on a card
public class DetailActivity extends AppCompatActivity {

    private ImageView imgGame;
    private TextView txtTitle, txtCategory, txtPrice, txtDescription;
    private Button btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();

        if (getIntent() != null && getIntent().hasExtra("selected_game")) {
            Game game = (Game) getIntent().getSerializableExtra("selected_game");

            if (game != null) {
                displayGameDetails(game);
            }
        }

        if (btnAddToCart != null) {
            btnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(DetailActivity.this, "The game has been added to the cart!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initViews() {
        // مطابقة كاملة مع الـ IDs في ملف activity_detail.xml
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
            txtPrice.setText("$" + game.getPrice());
        }

        if (txtDescription != null) {
            txtDescription.setText(game.getDescription());
        }

        if (imgGame != null) {
            imgGame.setImageResource(game.getImageResId());
        }
    }
}