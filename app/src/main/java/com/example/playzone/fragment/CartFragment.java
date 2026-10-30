package com.example.playzone.fragment;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playzone.R;
import com.example.playzone.adapter.GameAdapter;
import com.example.playzone.model.Game;
import com.example.playzone.utils.CartManager;

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

        // 2. Load data for cart items
        cartList = CartManager.getInstance().getCartList();

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

        // Swipe left or right to remove an item from the cart
        ItemTouchHelper.SimpleCallback swipeCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView,
                                          @NonNull RecyclerView.ViewHolder viewHolder,
                                          @NonNull RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getBindingAdapterPosition();
                        if (position == RecyclerView.NO_POSITION) return;

                        Game removedGame = cartList.get(position);
                        CartManager.getInstance().removeGame(removedGame);
                        adapter.notifyItemRemoved(position);
                        calculateTotal();

                        Toast.makeText(getContext(),
                                removedGame.getTitle() + " removed from cart",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                                            @NonNull RecyclerView.ViewHolder viewHolder,
                                            float dX, float dY, int actionState, boolean isCurrentlyActive) {

                        View itemView = viewHolder.itemView;

                        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE && dX != 0) {
                            Paint paint = new Paint();
                            paint.setColor(Color.parseColor("#D32F2F")); // red

                            // Draw the red rectangle in the area uncovered by the swipe
                            float radius = 12 * recyclerView.getContext().getResources().getDisplayMetrics().density; // 12dp to px

                            RectF background;
                            if (dX > 0) { // swiping right
                                background = new RectF(itemView.getLeft(), itemView.getTop(),
                                        itemView.getLeft() + dX + radius, itemView.getBottom());
                            } else { // swiping left
                                background = new RectF(itemView.getRight() + dX - radius, itemView.getTop(),
                                        itemView.getRight(), itemView.getBottom());
                            }
                            c.drawRoundRect(background, radius, radius, paint);
                        }

                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                    }
                };
        new ItemTouchHelper(swipeCallback).attachToRecyclerView(rvCartItems);


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