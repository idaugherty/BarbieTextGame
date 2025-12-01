package characters;

import java.util.Objects;

/**
 * Abstract base class for all Barbie characters in the multithreaded adventure game.
 * <p>
 * Each Barbie is a thread with its own unique behavior defined in {@link #run()}.
 * This class implements the {@link BarbieBehaviors} interface, providing shared
 * functionality such as talking, walking, and arguing with Ken.
 * <p>
 * Subclasses must override the {@link #run()} method to define the character's adventure.
 * They may also override default behaviors as needed.
 *
 * @author Bella Daugherty
 * @version 1.0
 * @since 1.0
 */
public abstract class Barbie extends Thread implements BarbieBehaviors {

    /** Unique numeric identifier for this Barbie */
    private final int id;

    /** Descriptive type of Barbie (e.g., Mermaid, Fairy Secret) */
    private final String typeOfBarbie;

    /**
     * Constructs a new Barbie instance.
     *
     * @param id numeric identifier of the Barbie
     * @param typeOfBarbie the descriptive type of Barbie (cannot be null or empty)
     * @throws NullPointerException if typeOfBarbie is null
     * @throws IllegalArgumentException if typeOfBarbie is empty or blank
     */
    public Barbie(int id, String typeOfBarbie) {
        this.id = id;
        Objects.requireNonNull(typeOfBarbie, "typeOfBarbie cannot be null");
        if (typeOfBarbie.trim().isEmpty()) {
            throw new IllegalArgumentException("typeOfBarbie cannot be empty");
        }
        this.typeOfBarbie = typeOfBarbie;
        setName(typeOfBarbie + "-" + id);
    }

    /**
     * Gets the numeric ID of this Barbie.
     *
     * @return the Barbie's ID
     */
    protected int getBarbieId() {
        return id;
    }

    /**
     * Gets the descriptive type of this Barbie.
     *
     * @return the type of Barbie
     */
    protected String getBarbieType() {
        return typeOfBarbie;
    }

    /**
     * Core thread behavior. Subclasses must define this method to implement
     * their specific adventure logic.
     */
    @Override
    public abstract void run();

    /**
     * Default talk behavior. Prints the Barbie's speech to console.
     *
     * @param speech the text Barbie will say
     */
    @Override
    public void talk(String speech) {
        BarbieBehaviors.requireSpeech(speech);
        System.out.println(getName() + " says: \"" + speech + "\"");
    }

    /**
     * Default walking behavior. Subclasses may override.
     */
    @Override
    public void walk() {
        System.out.println(getName() + " walks gracefully.");
    }

    /**
     * Default arguing behavior with Ken.
     *
     * @param speech the text directed at Ken
     */
    @Override
    public void argueWithKen(String speech) {
        BarbieBehaviors.requireSpeech(speech);
        System.out.println(getName() + " argues with Ken: \"" + speech + "\"");
    }
}
