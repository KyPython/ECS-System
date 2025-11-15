package ecs;

import java.util.Map;

public abstract class System {

    // Abstract method that includes the current frame's Trace ID (correlation ID)
    public abstract void update(double deltaTime, ECSWorld world, long frameId);
}