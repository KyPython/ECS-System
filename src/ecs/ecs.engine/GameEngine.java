package ecs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameEngine {

    public static void main(String[] args) {
        new GameEngine().run();
    }

    public void run() {
        ECSWorld world = new ECSWorld();
        List<System> systems = new ArrayList<>();

        // Add systems
        systems.add(new MovementSystem());

        // Initialize state (LOG: Entity Creation)
        long initialFrame = 1;
        int player = world.createEntity(initialFrame);
        world.positions.put(player, new PositionComponent(10, 5));
        world.velocities.put(player, new VelocityComponent(0.5f, 0.2f));

        // Game Loop Variables
        long frameId = initialFrame;
        double targetFPS = 60.0;
        double targetFrameTimeMs = 1000.0 / targetFPS; // 16.67ms
        double deltaTime = targetFrameTimeMs / 1000.0; // Delta time in seconds

        System.out.println("\n--- Starting Observable Game Engine ---\n");

        // Simple loop for demonstration
        for (int i = 0; i < 60; i++) {
            frameId++;

            // Start of Frame Tracing & Metric
            long frameStartTime = System.nanoTime();

            // LOG: Frame Start with Trace ID
            System.out.println(String.format("\n[TRACE_%d] [LOOP_START] Frame #%d", frameId, frameId));

            // --- 1. System Updates (The core logic) ---
            for (System system : systems) {
                // Pass the Trace ID to every System update
                system.update(deltaTime, world, frameId);
            }

            // --- 2. End of Frame Metrics & Alerting ---
            long frameDurationNano = System.nanoTime() - frameStartTime;
            double frameDurationMs = frameDurationNano / 1_000_000.0;
            double currentFPS = 1000.0 / frameDurationMs;

            // LOG: Frame End with Metrics
            System.out.println(String.format(
                    "[TRACE_%d] [LOOP_END] Completed in %.2fms | FPS: %.1f",
                    frameId, frameDurationMs, currentFPS));

            // OBSERVABILITY: ALERTING LOGIC (Session 4)
            if (currentFPS < 30.0) {
                System.err.println(String.format(
                        "*** [HIGH_ALERT] Frame #%d: FPS dropped below 30.0! Current: %.1f ***",
                        frameId, currentFPS));
            }

            // Simple thread sleep to simulate frame timing (optional, for real-time control)
            try {
                long sleepTimeMs = (long) (targetFrameTimeMs - frameDurationMs);
                if (sleepTimeMs > 0) {
                    TimeUnit.MILLISECONDS.sleep(sleepTimeMs);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n--- Simulation Complete ---");
    }
}