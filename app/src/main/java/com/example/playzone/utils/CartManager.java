package com.example.playzone.utils;

import com.example.playzone.model.Game;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static CartManager instance;
    private  final List<Game> cartList;

    private CartManager(){

        cartList = new ArrayList<Game>();
    }

    public static synchronized CartManager getInstance(){
        if(instance == null){
            instance = new CartManager();
        }
        return  instance;
    }


    public void addGame(Game game){
        cartList.add(game);
    }

    public void removeGame(Game game){cartList.remove(game);}

    public List<Game> getCartList(){
        return cartList;
    }

    public int getCartCount(){
        return cartList.size();
    }




}
