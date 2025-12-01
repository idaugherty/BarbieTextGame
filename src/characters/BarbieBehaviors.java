package characters;

/**
 * Defines behaviors for a Barbie character used in the text game.
 *
 * <p>This interface declares basic actions that a Barbie instance can perform
 * in the game such as speaking, walking, and arguing with Ken. Implementations
 * should provide the concrete behavior for each action (for example printing
 * messages, updating game state, or interacting with other characters).
 *
 * <p>Typical implementations might output text to the console or update model
 * objects representing the game world.
 *
 * @author Bella Daugherty
 * @since 1.0
 */
public interface BarbieBehaviors {

    /**
     * Make Barbie speak the provided line of text.
     *
    * <p>The speech parameter must not be {@code null} or empty. Implementations
    * should call {@link #requireSpeech(String)} to validate input or otherwise
    * ensure the contract is met.
    *
    * @param speech the line of text Barbie should say; must not be {@code null}
    *               or empty
    * @throws IllegalArgumentException if {@code speech} is {@code null} or empty
     */
    void talk(String speech);

    /**
     * Make Barbie perform a walking action.
     *
     * <p>Implementations decide how walking is represented (for example
     * printing "Barbie walks" to the console or advancing a position in the
     * game world).
     */
    void walk();

    /**
     * Make Barbie run.
     *
     * <p>Implementations decide how running is represented in the game.
     */
    void run();

    /**
     * Make Barbie argue with Ken using the provided speech line.
     *
     * @param speech the argument or line directed at Ken.
     */
    void argueWithKen(String speech);

    /**
     * Validate that a speech string meets the non-null, non-empty contract.
     *
     * <p>Implementations can call this helper before using a {@code speech}
     * parameter. It throws {@link IllegalArgumentException} when the input is
     * {@code null} or blank (only whitespace).
     *
     * @param speech the speech to validate
     * @throws IllegalArgumentException if {@code speech} is {@code null} or blank
     */
    static void requireSpeech(String speech) {
        if (speech == null || speech.trim().isEmpty()) {
            throw new IllegalArgumentException("speech must not be null or empty");
        }
    }
}
