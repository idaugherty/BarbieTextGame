Student: Bella Daugherty

Course: CSC325-FA25

# BarbieTextGame — "Mermaids, Music & Magic"

## Game title and story summary

BarbieTextGame is a small, text-based simulation that brings together a few fantasy-themed Barbie characters for short, concurrent adventures. The main characters include:

- Mermaid Tale Barbie — dives into the ocean, swims, and collects pearls from a shared `PearlChest`.
- Twelve Dancing Princesses Barbie — coordinates with sisters to dance using a shared `MusicBox`.
- Fairy Secret Barbie — gathers magic dust from a `MagicDustBag` to help friends.

The `GameEngine` creates these characters as separate threads and starts their adventures. Each character prints short messages to the console to narrate actions such as swimming, dancing, talking, or collecting resources. The goal of the project is educational: demonstrate object-oriented design and basic thread synchronization in Java while keeping the behavior output visible and readable.

## How to build and run

Requirements

- Java JDK 11 or newer

Build steps (PowerShell)

1. From the repository root, compile the sources into the `bin` directory:

```powershell
javac -d bin src\characters\*.java src\engine\*.java src\main\*.java src\resources\*.java
```

2. The `bin` directory will now contain compiled classes preserving package structure.

Run

1. After compiling, run the supplied demo `main.Main`:

```powershell
java -cp bin main.Main
```

What `main.Main` does

- Creates shared resource objects (`PearlChest`, `MusicBox`, `MagicDustBag`).
- Instantiates example Barbies and adds them to a `GameEngine` instance.
- Starts the engine, which starts each Barbie thread and waits for all of them to finish.

Example console output (short)

```
GameEngine: Starting all Barbie adventures...
Mermaid Tale-2 begins her mermaid adventure!
Mermaid Tale-2 swims gracefully in the ocean.
Dancing Princess-3 is starting her dance adventure!
...
GameEngine: All Barbie adventures completed!
```

## Brief explanation of thread synchronization approach

This project uses a clear, conservative synchronization strategy focused on keeping shared state inside small, well-documented resource objects. The approach has three main elements:

1. Encapsulate shared state in resource classes

   - `PearlChest`, `MusicBox`, and `MagicDustBag` each own the data they protect (pearl count, whether music is playing, and dust amount, respectively). Encapsulation makes it easier to reason about access and locking.

2. Use `synchronized` methods for mutual exclusion

   - Methods that mutate or read shared state are declared `synchronized` (for example, `PearlChest.collectPearl()`, `MusicBox.startMusic()`/`stopMusic()`, and `MagicDustBag.collectDust()`).
   - Using `synchronized` on instance methods ensures that only one thread may execute any synchronized method on the same object at a time. This prevents data races and keeps operations atomic relative to each other.

3. Keep thread coordination simple and explicit

   - The `GameEngine` is responsible for starting threads with `Thread.start()` and waiting for them with `Thread.join()`.
   - Threads are given descriptive names (`setName(...)`) to make logging readable. Character logic is intentionally simple (short loops, `Thread.sleep(...)` between actions) so interactions remain deterministic enough to observe.

Why this is appropriate for this project

- The synchronized-method approach is simple to implement and reason about, which is ideal for teaching concurrency basics. It avoids complex lock ordering or multi-object locking, reducing the chance of deadlocks in this small simulation.
- For higher-performance or more complicated coordination (barriers, waiting for a specific number of events, or lock-free designs), one would adopt `java.util.concurrent` primitives such as `ReentrantLock`, `CountDownLatch`, `Semaphore`, or concurrent collections. Those are useful when contention, throughput, or advanced coordination patterns are the focus.

## Files of interest (quick reference)

- `src/characters/Barbie.java` — abstract base class, default behaviors, thread naming
- `src/characters/MermaidTaleBarbie.java` — collects pearls and demonstrates per-thread activity
- `src/characters/TwelveDancingPrincessesBarbie.java` — coordinates dancing via `MusicBox`
- `src/characters/FairySecretBarbie.java` — uses `MagicDustBag`
- `src/resources/PearlChest.java` — synchronized pearl collection
- `src/resources/MusicBox.java` — synchronized music control
- `src/resources/MagicDustBag.java` — synchronized dust collection
- `src/engine/GameEngine.java` — starts and manages Barbie threads
- `src/main/Main.java` — demo entry point

---

