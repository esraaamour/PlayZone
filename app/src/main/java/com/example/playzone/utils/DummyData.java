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
                "Grand Theft Auto VI",
                "Action / Open World",
                79.99,
                "Grand Theft Auto VI is an upcoming action-adventure game developed and published by Rockstar Games. It is due to be the eighth main Grand Theft Auto game, following Grand Theft Auto V (2013), and the sixteenth entry overall. Set within the fictional US state of Leonida, based on Florida, the story follows the romantic criminal duo of Jason Duval and Lucia Caminos. Players will be able to freely roam Leonida's open world, which features the Miami-inspired Vice City.",
                R.drawable.grand_theft_auto_png
        ));

        games.add(new Game(
                "Phantom Blade Zero",
                "Action / Adventure",
                69.99,
                "Be the Dark Raider exiled by \"The Order\", embark on the path of vengeance, and uncover the darkest secrets of Wulin!\n",
                R.drawable.phantom_blade_zero
        ));

        games.add(new Game(
                "Elden Ring",
                "RPG / Souls-like",
                59.99,
                "The Golden Order has been broken.\n" +
                        "\n" +
                        "Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring and become an Elden Lord in the Lands Between.\n" +
                        "\n" +
                        "In the Lands Between ruled by Queen Marika the Eternal, the Elden Ring, the source of the Erdtree, has been shattered.\n" +
                        "\n" +
                        "Marika's offspring, demigods all, claimed the shards of the Elden Ring known as the Great Runes, and the mad taint of their newfound strength triggered a war: The Shattering. A war that meant abandonment by the Greater Will.\n" +
                        "\n" +
                        "And now the guidance of grace will be brought to the Tarnished who were spurned by the grace of gold and exiled from the Lands Between. Ye dead who yet live, your grace long lost, follow the path to the Lands Between beyond the foggy sea to stand before the Elden Ring.",
                R.drawable.elden_ring
        ));

        games.add(new Game(
                "EA SPORTS FC™ 27 Standard Edition",
                "RPG / Sci-Fi",
                69.99,
                "HyperMotion integrates advanced full-team mocap data and machine learning to heighten gameplay in every match in FIFA 22, harnessing the power of next generation consoles to deliver the most realistic, responsive and fluid gameplay experience we’ve ever built. FIFA 22 brings a new season of innovation across every mode in the game; enjoy more consistency between the posts with a goalkeeper rewrite that brings more composure to the most important position on the pitch, live out your football dreams as you create and manage your custom club to glo… Read more\n",
                R.drawable.ea_sport_fc_27_standard_edition
        ));

        games.add(new Game(
                "Call of Duty Modern Warfare 4",
                "Sports",
                69.99,
                "War erupts on the Korean Peninsula as North Korea launches a full-scale invasion that threatens to destabilize the world in Call of Duty®: Modern Warfare® 4.\n" +
                        "\n" +
                        "A young squad of South Korean soldiers fight to survive on the collapsing front lines, while half a world away a vengeful Captain Price wages a personal war from the shadows as he stays one step ahead of those hunting him. As Price’s off-book mission collides with the forces behind the invasion, the war spreads beyond anyone’s control.",
                R.drawable.call_of_duty_modern_warfare
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