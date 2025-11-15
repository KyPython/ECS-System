package ecs.ecs.systems;

public class MovementSystem {
    public void update(ECSWorld world) {
        for (int id : world.positions.keySet()) {
            if (world.velocities.containsKey(id)) {
                PositionComponent pos = world.positions.get(id);
                VelocityComponent vel = world.velocities.get(id);
                pos.x += vel.dx;
                pos.y += vel.dy;
                System.out.println("Entity " + id + " moved to (" + pos.x + ", " + pos.y + ")");
            }
        }
    }
}

public class HealthSystem {
    public void update(ECSWorld world) {
        for (int id : world.healths.keySet()) {
            HealthComponent health = world.healths.get(id);
            if (health.hp <= 0) {
                System.out.println("Entity " + id + " is dead.");
            }
        }
    }
}

