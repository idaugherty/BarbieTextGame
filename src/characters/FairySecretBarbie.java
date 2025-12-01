package characters;

import java.util.Random;
import resources.MagicDustBag;

/**
 * A concrete {@link Barbie} representing a "Fairy Secret" character.
 * <p>
 * This Barbie uses {@link MagicDustBag} to collect magic dust during her
 * adventures.
 */
public class FairySecretBarbie extends Barbie {

    private final String wingType;
    private final MagicDustBag magicDustBag;
    private final Random random = new Random();

    public FairySecretBarbie(int id, String typeOfBarbie, String wingType, MagicDustBag magicDustBag) {
        super(id, typeOfBarbie);
        if (wingType == null || wingType.trim().isEmpty())
            throw new IllegalArgumentException("wingType cannot be null or empty");
        if (magicDustBag == null)
            throw new NullPointerException("magicDustBag cannot be null");

        this.wingType = wingType;
        this.magicDustBag = magicDustBag;
    }

    @Override
    public void talk(String speech) {
        BarbieBehaviors.requireSpeech(speech);
        System.out.println(getName() + " says: \"" + speech + "\"");
    }

    @Override
    public void walk() {
        System.out.println(getName() + " glides gracefully across the meadow.");
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " begins her fairy adventure!");
            for (int i = 0; i < 5; i++) {
                walk();
                Thread.sleep(random.nextInt(500) + 200);

                // Collect magic dust
                magicDustBag.collectDust(getName());
                Thread.sleep(random.nextInt(500) + 200);

                // Talk to imaginary friends
                talk("I sprinkle some magic dust!");
                Thread.sleep(random.nextInt(500) + 200);

                // Fly for a short burst
                fly();
                Thread.sleep(random.nextInt(500) + 200);
                land();
            }
            System.out.println(getName() + " has completed her adventure!");
        } catch (InterruptedException e) {
            System.err.println(getName() + " was interrupted during her adventure.");
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void argueWithKen(String speech) {
        BarbieBehaviors.requireSpeech(speech);
        System.out.println(getName() + " argues with Ken: " + speech);
    }

    public void fly() {
        System.out.println(getName() + " flies gracefully with " + wingType + " wings.");
    }

    public void land() {
        System.out.println(getName() + " lands softly on the ground.");
    }

    public String getWingType() {
        return wingType;
    }
}
