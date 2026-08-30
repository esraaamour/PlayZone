package com.example.playzone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playzone.R;
import com.example.playzone.adapter.GameAdapter;
import com.example.playzone.model.Game;
import com.example.playzone.utils.DummyData;

import java.util.List;

public class CartFragment extends Fragment implements GameAdapter.OnGameClickListener {

    private RecyclerView rvCartItems;
    private TextView txtTotalPrice;
    private Button btnCheckout;
    private GameAdapter adapter;
    private List<Game> cartList;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Initialize views
        rvCartItems = view.findViewById(R.id.rvCartItems);
        txtTotalPrice = view.findViewById(R.id.txtTotalPrice);
        btnCheckout = view.findViewById(R.id.btnCheckout);

        // 2. Load dummy data for cart items
        cartList = DummyData.getDummyGames();

        // 3. Setup RecyclerView and Adapter
        adapter = new GameAdapter(cartList, this);
        rvCartItems.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCartItems.setAdapter(adapter);

        // 4. Calculate total price of cart items
        calculateTotal();

        // 5. Handle checkout button click
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Checkout completed successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Helper method to calculate the total price dynamically
    private void calculateTotal() {
        double total = 0.0;
        if (cartList != null) {
            for (Game game : cartList) {
                total += game.getPrice();
            }
        }
        txtTotalPrice.setText(String.format("Total: $%.2f", total));
    }

    @Override
    public void onGameClick(Game game) {
        Toast.makeText(getContext(), game.getTitle() + " selected from cart", Toast.LENGTH_SHORT).show();
    }
}