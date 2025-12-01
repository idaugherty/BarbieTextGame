package engine;

import characters.Barbie;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code GameEngine} class serves as the central controller of the BarbieTextGame.
 * It is responsible for creating, starting, and managing all Barbie threads, ensuring
 * that concurrent actions run smoothly.
 */
public class GameEngine {

    private final List<Barbie> barbieThreads;
    private boolean isRunning;

    public GameEngine() {
        this.barbieThreads = new ArrayList<>();
        this.isRunning = false;
    }

    /** Add a Barbie thread to the engine. */
    public void addBarbieThread(Barbie barbie) {
        barbieThreads.add(barbie);
    }

    /** Starts all Barbie threads and manages them until completion. */
    public void startGame() {
        isRunning = true;
        System.out.println("GameEngine: Starting all Barbie adventures...");

        for (Barbie barbie : barbieThreads) {
            barbie.start();
        }

        manageThreads();
        isRunning = false;
        System.out.println("GameEngine: All Barbie adventures completed!");
    }

    /** Waits for all Barbie threads to finish execution. */
    public void manageThreads() {
        for (Barbie barbie : barbieThreads) {
            try {
                barbie.join();
            } catch (InterruptedException e) {
                System.err.println(barbie.getName() + " was interrupted.");
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Returns whether the game engine is currently running.
     *
     * @return true if the game is running; false otherwise
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Getter for the list of Barbie threads.
     * Allows stream/lambda operations on all Barbie threads.
     *
     * @return a list of all Barbie threads managed by the engine
     */
    public List<Barbie> getBarbieThreads() {
        return barbieThreads;
    }
}


