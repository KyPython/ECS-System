package ecs.ecs.components;

public class Component {
}

public interface Component {}

public class PositionComponent implements Component {
    public float x, y;
    public PositionComponent(float x, float y) { this.x = x; this.y = y; }
}
public class VelocityComponent implements Component {
    public float dx, dy;
    public VelocityComponent(float dx, float dy) { this.dx = dx; this.dy = dy; }
}
public class HealthComponent implements Component {
    public int hp;
    public HealthComponent(int hp) { this.hp = hp; }
}
