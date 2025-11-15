package ecs;

import java.util.Map;

public class MovementSystem extends System {
    // METRIC: Tracks total entities processed for throughput analysis
    private long totalUpdatesProcessed = 0;

    @Override
    public void update(double deltaTime, ECSWorld world, long frameId) {

        // TRACE: System Execution Start
        System.out.println(String.format("[TRACE_%d] [SYSTEM_START] MovementSystem", frameId));
        long startTime = System.nanoTime();

        int processedThisFrame = 0;

        // Note: This is a simplified iteration based on your README structure
        for (Map.Entry<Integer, PositionComponent> entry : world.positions.entrySet()) {
            int entityId = entry.getKey();
            PositionComponent pos = entry.getValue();

            // Check if entity has VelocityComponent
            VelocityComponent vel = world.velocities.get(entityId);
            if (vel != null) {

                String oldPos = pos.toString(); // For Logging State Change

                // Update Logic
                pos.x += vel.vx * deltaTime;
                pos.y += vel.vy * deltaTime;

                // TRACE: Log Component State Change
                System.out.println(String.format(
                        "[TRACE_%d] [STATE_CHANGE] Entity: %d | Component: Position | OLD: %s -> NEW: %s",
                        frameId, entityId, oldPos, pos.toString()));

                processedThisFrame++;
            }
        }

        // METRIC: Update and Log System Throughput
        totalUpdatesProcessed += processedThisFrame;
        long durationMs = (System.nanoTime() - startTime) / 1_000_000;

        System.out.println(String.format(
                "[TRACE_%d] [METRIC] MovementSystem: Took %dms | Processed %d entities (Total: %d)",
                frameId, durationMs, processedThisFrame, totalUpdatesProcessed));
    }
}