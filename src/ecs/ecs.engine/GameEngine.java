package ecs.ecs.engine;

public class GameEngine {
    public static void main(String[] args) {
        ECSWorld world = new ECSWorld();
        Entity player = world.createEntity();
        world.positions.put(player.getId(), new PositionComponent(0, 0));
        world.velocities.put(player.getId(), new VelocityComponent(1, 1));
        world.healths.put(player.getId(), new HealthComponent(10));

        Entity enemy = world.createEntity();
        world.positions.put(enemy.getId(), new PositionComponent(5, 5));
        world.velocities.put(enemy.getId(), new VelocityComponent(-1, 0));
        world.healths.put(enemy.getId(), new HealthComponent(5));

        MovementSystem moveSys = new MovementSystem();
        HealthSystem healthSys = new HealthSystem();

        for (int tick = 0; tick < 3; tick++) {
            System.out.println("-- Tick " + tick + " --");
            moveSys.update(world);
            healthSys.update(world);
        }
    }
}

