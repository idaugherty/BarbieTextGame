package characters;

import java.util.Random;
import resources.PearlChest;

/**
 * A Barbie subclass representing a "Mermaid Tale" character.
 * <p>
 * This Barbie collects pearls from a shared {@link PearlChest} while swimming.
 */
public class MermaidTaleBarbie extends Barbie {

    private final String mermaidTaleType;
    private final String stateOfBarbie;
    private final PearlChest pearlChest;
    private final Random random = new Random();

    public MermaidTaleBarbie(int id, String typeOfBarbie, String mermaidTaleType,
                             String stateOfBarbie, PearlChest pearlChest) {
        super(id, typeOfBarbie);
        if (mermaidTaleType == null || mermaidTaleType.trim().isEmpty())
            throw new IllegalArgumentException("mermaidTaleType cannot be null or empty");
        if (stateOfBarbie == null || stateOfBarbie.trim().isEmpty())
            throw new IllegalArgumentException("stateOfBarbie cannot be null or empty");
        if (pearlChest == null)
            throw new NullPointerException("pearlChest cannot be null");

        this.mermaidTaleType = mermaidTaleType;
        this.stateOfBarbie = stateOfBarbie;
        this.pearlChest = pearlChest;
    }

    @Override
    public void talk(String speech) {
        BarbieBehaviors.requireSpeech(speech);
        System.out.println(getName() + " says: \"" + speech + "\"");
    }

    @Override
    public void walk() {
        System.out.println(getName() + " glides through shallow water.");
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " begins her mermaid adventure!");
            for (int i = 0; i < 5; i++) {
                swim();
                Thread.sleep(random.nextInt(500) + 200);

                // Collect pearls
                pearlChest.collectPearl(getName());
                Thread.sleep(random.nextInt(500) + 200);

                // Talk to sea creatures
                talk("Hello, little fish!");
                Thread.sleep(random.nextInt(500) + 200);
            }
            System.out.println(getName() + " has completed her mermaid adventure!");
        } catch (InterruptedException e) {
            System.err.println(getName() + " was interrupted during swimming.");
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void argueWithKen(String speech) {
        BarbieBehaviors.requireSpeech(speech);
        System.out.println(getName() + " argues with Ken: " + speech);
    }

    public void swim() {
        System.out.println(getName() + " swims gracefully in the ocean.");
    }

    public String getMermaidTaleType() {
        return mermaidTaleType;
    }

    public String getStateOfBarbie() {
        return stateOfBarbie;
    }
}
