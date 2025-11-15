package ecs;

import java.util.*;

public class ECSWorld {
    private int nextEntityId = 0;
    private final Set<Integer> entities = new HashSet<>();
    public final Map<Integer, PositionComponent> positions = new HashMap<>();
    public final Map<Integer, VelocityComponent> velocities = new HashMap<>();
    public final Map<Integer, HealthComponent> healths = new HashMap<>();

    public Entity createEntity() {
        int id = nextEntityId++;
        entities.add(id);
        return new Entity(id);
    }
}
