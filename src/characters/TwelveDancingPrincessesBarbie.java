package characters;

import java.util.Random;
import resources.MusicBox;

/**
 * A Barbie subclass modeling one of the "Twelve Dancing Princesses" characters.
 * <p>
 * Each Barbie interacts with a shared {@link MusicBox} to synchronize dance actions.
 */
public class TwelveDancingPrincessesBarbie extends Barbie {

    private final String birthOrderPlacementOfBarbie;
    private final MusicBox musicBox;
    private final Random random = new Random();

    public TwelveDancingPrincessesBarbie(int id, String typeOfBarbie, String birthOrderPlacementOfBarbie,
                                        MusicBox musicBox) {
        super(id, typeOfBarbie);
        if (birthOrderPlacementOfBarbie == null || birthOrderPlacementOfBarbie.trim().isEmpty())
            throw new IllegalArgumentException("birthOrderPlacementOfBarbie cannot be null or empty");
        if (musicBox == null)
            throw new NullPointerException("musicBox cannot be null");

        this.birthOrderPlacementOfBarbie = birthOrderPlacementOfBarbie;
        this.musicBox = musicBox;
    }

    @Override
    public void talk(String speech) {
        BarbieBehaviors.requireSpeech(speech);
        System.out.println(getName() + " says: \"" + speech + "\"");
    }

    @Override
    public void walk() {
        System.out.println(getName() + " walks gracefully across the ballroom.");
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " is starting her dance adventure!");
            for (int i = 0; i < 5; i++) {
                musicBox.startMusic(getName());
                Thread.sleep(random.nextInt(500) + 200);

                danceBySelf();
                Thread.sleep(random.nextInt(500) + 200);

                danceWithSisters();
                Thread.sleep(random.nextInt(500) + 200);
            }
            musicBox.stopMusic(getName());
            System.out.println(getName() + " has finished dancing!");
        } catch (InterruptedException e) {
            System.err.println(getName() + " was interrupted during dancing.");
            Thread.currentThread().interrupt();
        }
    }

    public void danceBySelf() {
        System.out.println(getName() + " performs a solo dance.");
    }

    public void danceWithSisters() {
        System.out.println(getName() + " dances with her sisters in a circle.");
    }

    public String getBirthOrderPlacementOfBarbie() {
        return birthOrderPlacementOfBarbie;
    }
}
