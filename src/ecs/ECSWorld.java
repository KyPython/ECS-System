package ecs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ECSWorld {
    private final AtomicInteger nextEntityId = new AtomicInteger(0);

    // Simplified Component Storage (as mentioned in your README)
    public Map<Integer, PositionComponent> positions = new HashMap<>();
    public Map<Integer, VelocityComponent> velocities = new HashMap<>();

    public int createEntity(long frameId) {
        int entityId = nextEntityId.incrementAndGet();

        // LOG: Entity Creation Lifecycle
        System.out.println(String.format("[TRACE_%d] [ENTITY_CREATE] ID: %d", frameId, entityId));

        return entityId;
    }

    public void destroyEntity(int entityId, long frameId) {
        // LOG: Entity Destruction Lifecycle
        System.out.println(String.format("[TRACE_%d] [ENTITY_DESTROY] ID: %d", frameId, entityId));

        positions.remove(entityId);
        velocities.remove(entityId);
    }
}