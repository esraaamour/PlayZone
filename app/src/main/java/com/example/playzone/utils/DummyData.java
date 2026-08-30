package com.example.playzone.utils;

// Utility class that provides dummy game data and game categories for testing and display.

import com.example.playzone.R;
import com.example.playzone.model.Game;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    // Returns a list of available games
    public static List<Game> getDummyGames() {
        List<Game> games = new ArrayList<>();

        games.add(new Game(
                "Red Dead Redemption 2",
                "Action / Open World",
                59.99,
                "An epic tale of life in America at the dawn of the modern age. Experience the journey of Arthur Morgan and the Van der Linde gang.",
                R.drawable.ic_launcher_background
        ));

        games.add(new Game(
                "God of War Ragnarök",
                "Action / Adventure",
                69.99,
                "An epic journey following Kratos and Atreus through the Nine Realms as they prepare for the prophesied battle of Ragnarök.",
                R.drawable.ic_launcher_background
        ));

        games.add(new Game(
                "Elden Ring",
                "RPG / Souls-like",
                59.99,
                "An action RPG set in a vast dark-fantasy world full of danger and mystery, created by Hidetaka Miyazaki and George R. R. Martin.",
                R.drawable.ic_launcher_background
        ));

        games.add(new Game(
                "Cyberpunk 2077",
                "RPG / Sci-Fi",
                49.99,
                "An open-world action-adventure RPG set in Night City, a megalopolis obsessed with power, glamour, and body modification.",
                R.drawable.ic_launcher_background
        ));

        games.add(new Game(
                "FC 24",
                "Sports",
                69.99,
                "The most authentic football experience featuring updated club kits and over 19,000 fully licensed players.",
                R.drawable.ic_launcher_background
        ));

        return games;
    }

    // Returns a list of game categories for the ListView
    public static List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Action");
        categories.add("RPG");
        categories.add("Sports");
        categories.add("Adventure");
        categories.add("Strategy");
        categories.add("Racing");
        return categories;
    }
}