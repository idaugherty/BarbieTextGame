package resources;

/**
 * Thread-safe bag of magic dust for FairySecretBarbie.
 */
public class MagicDustBag {

    private int dustAmount;

    /**
     * Creates a new MagicDustBag with the specified initial amount of dust.
     *
     * @param initialDust the initial quantity of magic dust
     */
    public MagicDustBag(int initialDust) {
        this.dustAmount = initialDust;
    }

    /**
     * Collects one unit of magic dust from the bag in a thread-safe manner.
     *
     * @param collectorName the name of the Barbie collecting the dust
     */
    public synchronized void collectDust(String collectorName) {
        if (dustAmount > 0) {
            dustAmount--;
            System.out.println(collectorName + " collected some magic dust! Remaining: " + dustAmount);
        } else {
            System.out.println(collectorName + " found the MagicDustBag empty!");
        }
    }

    /**
     * Returns the remaining amount of dust in the bag.
     *
     * @return the quantity of dust left
     */
    public synchronized int getDustAmount() {
        return dustAmount;
    }
}

