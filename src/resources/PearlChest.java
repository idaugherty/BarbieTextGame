package resources;

/**
 * Thread-safe chest of pearls for MermaidTaleBarbie.
 * <p>
 * Multiple MermaidTaleBarbie threads can safely collect pearls concurrently.
 * All access to the pearl count is synchronized to prevent race conditions.
 */
public class PearlChest {

    /** The number of pearls currently in the chest. */
    private int pearls;

    /**
     * Constructs a new {@code PearlChest} with an initial number of pearls.
     *
     * @param initialPearls the starting number of pearls; must be >= 0
     * @throws IllegalArgumentException if {@code initialPearls} is negative
     */
    public PearlChest(int initialPearls) {
        if (initialPearls < 0) {
            throw new IllegalArgumentException("initialPearls cannot be negative");
        }
        this.pearls = initialPearls;
    }

    /**
     * Mermaid collects a pearl from the chest.
     * <p>
     * This method is synchronized so that only one thread can collect a pearl
     * at a time. It prints the action and updates the remaining pearl count.
     *
     * @param collectorName the name of the Barbie collecting the pearl
     */
    public synchronized void collectPearl(String collectorName) {
        if (pearls > 0) {
            pearls--;
            System.out.println(collectorName + " collected a pearl! Pearls left: " + pearls);
        } else {
            System.out.println(collectorName + " found the chest empty!");
        }
    }

    /**
     * Gets the current number of pearls in the chest.
     * <p>
     * This method is synchronized to safely return the value even when
     * multiple threads are accessing it.
     *
     * @return the number of pearls remaining
     */
    public synchronized int getPearls() {
        return pearls;
    }

    /**
     * Adds pearls to the chest.
     * <p>
     * This method is synchronized to safely increase the count in multithreaded contexts.
     *
     * @param count the number of pearls to add; must be > 0
     * @throws IllegalArgumentException if {@code count} is <= 0
     */
    public synchronized void addPearls(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("count must be greater than zero");
        }
        pearls += count;
        System.out.println(count + " pearls added! Total pearls: " + pearls);
    }
}

