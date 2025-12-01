package resources;

/**
 * Thread-safe MusicBox for TwelveDancingPrincessesBarbie.
 * <p>
 * Multiple Barbie threads can interact with the music box concurrently.
 * Methods are synchronized to ensure only one action occurs at a time.
 */
public class MusicBox {

    /** Indicates whether the music box is currently playing. */
    private boolean isPlaying;

    /** Constructs a new MusicBox, initially not playing. */
    public MusicBox() {
        this.isPlaying = false;
    }

    /**
     * Starts the music box.
     * <p>
     * Synchronized to prevent multiple threads from starting music simultaneously.
     */
    public synchronized void startMusic(String barbieName) {
        if (!isPlaying) {
            isPlaying = true;
            System.out.println(barbieName + " starts the music box!");
        } else {
            System.out.println(barbieName + " tries to start the music box, but it's already playing.");
        }
    }

    /**
     * Stops the music box.
     * <p>
     * Synchronized to ensure only one thread stops the music at a time.
     */
    public synchronized void stopMusic(String barbieName) {
        if (isPlaying) {
            isPlaying = false;
            System.out.println(barbieName + " stops the music box.");
        } else {
            System.out.println(barbieName + " tries to stop the music box, but it's already stopped.");
        }
    }

    /**
     * Checks whether the music box is currently playing.
     *
     * @return {@code true} if the music is playing, {@code false} otherwise
     */
    public synchronized boolean isPlaying() {
        return isPlaying;
    }
}