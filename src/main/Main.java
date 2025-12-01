package main;

import characters.FairySecretBarbie;
import characters.MermaidTaleBarbie;
import characters.TwelveDancingPrincessesBarbie;
import engine.GameEngine;
import resources.MagicDustBag;
import resources.MusicBox;
import resources.PearlChest;

/**
 * Main entry point to run the BarbieTextGame with shared resources.
 */
public class Main {

    public static void main(String[] args) {

        // Shared resources
        MagicDustBag magicDustBag = new MagicDustBag(10);
        PearlChest pearlChest = new PearlChest(10);
        MusicBox musicBox = new MusicBox();

        // Create GameEngine
        GameEngine engine = new GameEngine();

        // Add Barbies with shared resources
        engine.addBarbieThread(new FairySecretBarbie(1, "Fairy Secret", "Butterfly", magicDustBag));
        engine.addBarbieThread(new MermaidTaleBarbie(2, "Mermaid Tale", "Coral Princess", "Mermaid", pearlChest));
        engine.addBarbieThread(new TwelveDancingPrincessesBarbie(3, "Dancing Princess", "3rd", musicBox));

        // Start the game
        engine.startGame();

        // Example of using streams/lambda in GameEngine to summarize
        long activeThreads = engine.getBarbieThreads().stream().filter(Thread::isAlive).count();
        System.out.println("Active Barbie threads after game start: " + activeThreads);
    }
}
